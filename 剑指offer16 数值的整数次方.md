## 题目来源：[剑指offer16 数值的整数次方](https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0

### 输入：2 ，2输出：4

### 思路：更改快速幂模板即可。需要注意的是，指数为负数的时候，指数或者底数为0的情况。

### AC代码：

```
class Solution {
public:
    double Power(double a, int b) {
        int flag=0;
        if(b<0){
            flag=1;
            b*=-1;
        }
        double ans=1;
        while(b){
            if(b&1)
                ans=a*ans;
            a=a*a;
            b>>=1;
        }
        if(flag==1)
            return 1.0/ans;
        else
            return ans;
    }
};

```
