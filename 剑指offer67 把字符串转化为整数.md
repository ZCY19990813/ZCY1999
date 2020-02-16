## 题目来源：[剑指offer67 把字符串转化为整数](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)

### 题意：写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。(如果题目改为非法输入都输出0则下面代码需要改一下)
### 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。在任何情况下，若函数不能进行有效的转换时，请返回 0。

### 说明：假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231 − 1) 或 INT_MIN (−231) 。

### 输入:"4193 with words"  输出: 4193
### 输入："   -42" 输出：-42
### 输入："words and 987" 输出：0
### 输入："-91283472332" 输出：-2147483648

### 补充：atoi函数用来将字符串转化成一个整数，头文件:#include<stdlib.h>  char *str="12345.56";int n=atoi(str);输出12345.当返回值为0的时候怎么区分是合法的或者输入的是0呢？atoi是通过一个全局变量来区分的，如果是非法输入，则返回0并把这个全局变量做特殊标记，而输入为0的时候只会返回0，不会对全局变量进行操作。

### 下面代码一旦超过long long 就会出错，可以加在判断完正负号的时候加一句截取字符串前12位即可。

### AC代码：

```
class Solution {
public:
    int strToInt(string str) {
        long long int ans=0;//防止溢出
        int length=str.size();
        int start=0;
        while(str[start]==' '){
            start++;
            if(start>=length)
                return ans;
        } 
        bool zf=true;
        if(str[start]=='+')
            start++;
        else if(str[start]=='-')
            start++,zf=false;
        //cout<<start<<"*"<<endl;
        int flag=0;
        for(int i=start;i<length;i++){
            if(str[i]>='0'&&str[i]<='9'){
                ans=ans*10;
                if(ans>=INT_MAX)
                    break;
                ans+=str[i]-'0';
            }
            else 
		break;
        }
            //cout<<ans<<endl;
        if(zf==false)
            ans=-ans;
        if(ans>=INT_MAX)
            return INT_MAX;
        if(ans<=INT_MIN)
            return INT_MIN;
        return ans;
    }
};
```

### 牛客AC代码：非法字符串都输出0

```
class Solution {
public:
    int StrToInt(string str) {
        long long int ans=0;//防止溢出
        int length=str.size();
        int start=0;
        while(str[start]==' '){
            start++;
            if(start>=length)
                return ans;
        } 
        bool zf=true;
        if(str[start]=='+')
            start++;
        else if(str[start]=='-')
            start++,zf=false;
        int flag=0;
        //cout<<start<<"*"<<endl;
        for(int i=start;i<length;i++){
            if(str[i]>='0'&&str[i]<='9'){
                ans=ans*10;
                if(ans>=INT_MAX)
                    break;
                ans+=str[i]-'0';
            }
            else {
                flag=1;
                break;
            }
        }
            //cout<<ans<<endl;
        if(zf==false)
            ans=-ans;
        if(ans>INT_MAX)
            return 0;
        if(ans<INT_MIN)
            return 0;
        if(flag==1)
            return 0;
        return ans;
    }
};
```
