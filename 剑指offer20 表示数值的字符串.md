## 题目来源：[剑指offer20 表示数值的字符串](https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/)

## 题意：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。

### 思路：（中等题）分为：符号部分，小数区域（包含小数点与正数），指数部分e（包括e后面的有符号数字，无小数点），完事。

### AC代码：

```
class Solution {
public:
    bool isNumber(string s) {
        int i=0;
        while(i<s.size()&&s[i]==' ')
            i++;
        //cout<<i<<endl;
        s=s.substr(i);
        i=s.size()-1;
        while(i>=0&&s[i]==' ')
            i--;
        s=s.substr(0,i+1);
        //cout<<s<<"*"<<endl;
        if(s.size()==0)
            return false;
        i=0;
        if(s[i]=='-'||s[i]=='+')
            i++;
        int pointNum=0,digitalNum=0;
        while(i<s.size()&&(s[i]>='0'&&s[i]<='9'||s[i]=='.')){
            if(s[i]=='.')
                pointNum++;
            else
                digitalNum++;
            i++;
        }
        if(pointNum>1||digitalNum<1)//必须最多只有一个小数点
            return false;
        if(i==s.size())//字符串到尾部没有e
            return true;
        if(s[i]=='e'||s[i]=='E'){
            i++;
            if(i==s.size())
                return false;//字母e后边没有东西不合法
            if(s[i]=='-'||s[i]=='+'){
                i++;
                if(i==s.size())//符号后面必须有东西
                    return false;
            }
            while(i<s.size()&&(s[i]>='0'&&s[i]<='9'))
                i++;
            if(i==s.size())
                return true;
        }
        return false;
    }
};
```
