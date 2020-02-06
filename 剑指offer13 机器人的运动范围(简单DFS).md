## 题目来源：[剑指offer13 机器人的运动范围(简单DFS)](https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

### 输入：5  n=4 m=6 输出：18

### 思路：简单DFS，每次到这个位置判断一下是不是符合，如果符合就继续向其他位置走。缺点就是使用内存较多。

### AC代码：

```
class Solution {
public:
    int dir[4][2]={0,1,0,-1,1,0,-1,0};
    bool cheack(int x,int y,int k){
        int s=0;
        while(x){
            s+=x%10;
            x/=10;
        }
        while(y){
            s+=y%10;
            y/=10;
        }
        if(s<=k)
            return true;
        else
            return false;
    }
    int ans=0;
    bool vis[1100][1100];
    void dfs(int k,int n,int m,int x,int y)
    {
        if(cheack(x,y,k)){
            ans++;
            vis[x][y]=true;
        }
        else
            return ;
        for(int i=0;i<4;i++){
            int xx=x+dir[i][0];
            int yy=y+dir[i][1];
            if(xx>=0&&xx<n&&yy>=0&&yy<m){
                if(vis[xx][yy]==false)
                    dfs(k,n,m,xx,yy);
            }
        }
    }
    int movingCount(int threshold, int rows, int cols){
        memset(vis,false,sizeof(vis));
        dfs(threshold,rows,cols,0,0);
        return ans;
    }
};
```
