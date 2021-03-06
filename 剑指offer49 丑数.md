## 题目来源：[剑指offer49 丑数](https://leetcode-cn.com/problems/ugly-number-ii/)

## 题意：编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。

### 输入：n=10 输出：12 解释：1,2,3,4,5,6,8,9,10,12是前10个丑数。

### 思路：采用动态规划思想，假设要找下标i对应的丑数dp[i],可以用i之前的所有丑数乘若干个2直到大于上一个丑数dp[i-1]，记此数为num1;同理用i之前的所有丑数乘若干个3直到大于上一个丑数dp[i-1]，记此数为num2；用i之前的所有丑数乘若干个5直到大于上一个丑数dp[i-1]，记此数为num3。这三个数中的最小数字就是第i个丑数dp[i]。但是呢，其实没必要把i之前的所有丑数乘2或者乘3或者乘5。在i之前的丑数中，肯定存在一个丑数（下标记为x2），乘2以后正好大于i的上一个丑数dp[i-1],x2之前的丑数乘2都小于等于dp[i-1];我们只需要记录x2，每次直接用这个下标对应的数乘2就行，并且在下标不满足时更新下标。同理我们也要记录乘3和乘5对应的下标。

### AC代码：

```
class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int>dp(n+1);
        dp[1]=1;
        int x2=1; //此下标对应的数乘2刚好大于上一个丑数，此下标之前的数乘2都小于等于上一个丑数
        int x3=1; //类似上方，乘2变成乘3
        int x5=1; //类似上方，乘3变成乘5
        for(int i=2;i<=n;++i)
        {
            dp[i]=min(min(dp[x2]*2,dp[x3]*3),dp[x5]*5);
            while(dp[x2]*2<=dp[i]) 
                x2++;
            while(dp[x3]*3<=dp[i]) 
                x3++;
            while(dp[x5]*5<=dp[i]) 
                x5++;
        }
        return dp[n];
    }
};
```
