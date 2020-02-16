## 题目来源：[剑指offer60 n个骰子的点数](https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/)

## 题意：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

### 输入:1  输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]

### 思路：n个骰子，每个骰子6个面，总情况数为6^n。设F(n,s)为当骰子数为n，和为s的情况数量。
  - 当n=1时，F(1,s)=1,其中s=1,2,3,4,5,6
  - 当n≥2时，F(n,s)=F(n−1,s−1)+F(n−1,s−2)+F(n−1,s−3)+F(n−1,s−4)+F(n−1,s−5)+F(n−1,s−6)。
  - 时间复杂度：O(n^2) 空间复杂度：O((n+1)(6n+1))=O(n^2)O((n+1)(6n+1))=O(n^2)
  - 由于n≤11，时间是不算长的.由于6^{11}==362797056没有超出int范围，故可以放心用int
  - 最后概率为P(n,s)=F(n,s)/6^n

### AC代码：

```
class Solution {
public:
    vector<double> twoSum(int n) {
        int dp[n+1][6*n+1];
        //边界条件
        memset(dp,0,sizeof(dp));
        for(int s=1;s<=6;s++)
            dp[1][s]=1;
        for(int i=2;i<=n;i++){
            for(int s=i;s<=6*i;s++){
                //求dp[i][s]
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)
                        break;//为0了
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
        double total = pow((double)6,(double)n);
        vector<double> ans(5*n+1,0);
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;
        }
        return ans;
    }
};
```
