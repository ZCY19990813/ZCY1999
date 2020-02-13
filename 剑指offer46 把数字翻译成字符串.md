## 题目来源：[剑指offer46 把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)

## 题意：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。0<=num<2^31

### 输入：12258 输出：5  解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

### 思路：dp.递归会有重复子问题，所以我们用dp来解决。设dp[i]表示从开始到第i位数字开始不同的翻译的数目，那么dp[i]=dp[i+1]+g(i,i+1)*dp[i+2]，其中g(i,i+1)表示这个二位数字在10-25之间就返回1，否则为0。

### AC代码：

```
class Solution {
public:
    int translateNum(int num) {
        if(num==0)
            return 1;
        string s=to_string(num);
        int dp[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            int t=0;
            if(i<s.size()-1)
                t=dp[i+1];
            else
                t=1;
            if(i<s.size()-1){
                int x=s[i]-'0';
                int y=s[i+1]-'0';
                x=x*10+y;
                if(x>=10&&x<=25){
                    if(i<s.size()-2)
                        t+=dp[i+2];
                    else
                        t+=1;
                }
            }
            dp[i]=t;
        }
        return dp[0];
    }
};
```
