## 题目来源：[剑指offer47 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)

## 题意：在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

### 输入：[[1,3,1],[1,5,1],[4,2,1]] 输出：12 解释：路径1->3->5->2->1可以拿到最多价值的礼物。

### 思路：dp.每一个可以来自左边或者右边，经过观察，没有必要开二维数组，只需要一维即可。

### AC代码：

```
class Solution {
public:
    int maxValue(vector<vector<int>>& grid) {
        int n=grid.size();
        if(n<=0)
            return 0;
        int m=grid[0].size();
        if(m<=0)
            return 0;
        int dp[m];
        dp[0]=grid[0][0];
        for(int i=1;i<m;i++)
            dp[i]=max(grid[0][i]+dp[i-1],dp[i-1]);
        for(int i=1;i<n;i++){
            dp[0]=max(dp[0]+grid[i][0],dp[0]);
            for(int j=1;j<m;j++){
                int t=dp[j];
                dp[j]=max(dp[j-1],t)+grid[i][j];
            }
        }
        return dp[m-1];
    }
};
```

