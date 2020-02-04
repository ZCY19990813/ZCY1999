## 题目来源：[剑指Offer5 替换空格 ](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

### 输入：We Are Happy.  输出：We%20Are%20Happy.

### 思路：需要想到一个时间复杂度为O(n)的算法，可以先遍历一遍字符串找到空格的个数，找到扩展之后字符串的长度，从后往前遍历之前长度的数组，直接从后往前赋值即可。 

### AC代码：

```
class Solution {
public:
  void replaceSpace(char *str,int length) {
    int n=0;
    for(int i=0;i<length;i++){
        if(str[i]==' ')
            n++;
    }
    //int p=length-1;
    n=2*n+length;
    int q=n-1;
    //cout<<p<<" "<<q<<endl;
    for(int i=length-1;i>=0;i--){
        cout<<str[i]<<endl;
        if(str[i]==' '){
            str[q--]='0';
            str[q--]='2';
            str[q--]='%';
        }
        else
            str[q--]=str[i];
    }
 }
};
```
