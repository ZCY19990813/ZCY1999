## 题目来源[力扣题目39 组合总和（DFS）](https://leetcode-cn.com/problems/combination-sum/)

### 执行用时 :20 ms, 在所有 cpp 提交中击败了64.95%的用户内存消耗 :9.2 MB, 在所有 cpp 提交中击败了97.10%的用户

## 题意：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字可以无限制重复被选取。说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合。 

### 示例1：candidates = [2,3,6,7], target = 7,求解集为:[[7],[2,2,3]]
### 示例2：输入: candidates = [2,3,5], target = 8,所求解集为:[[2,2,2,2],[2,3,3],[3,5]]

## 思路：DFS搜索，做这个题的时候遇到一个问题，就是有重复的元素，解决的方法就是加入一个k,如下
## AC代码：
```
class Solution {
public:
    //target是给出的和，sum是当前的和，t是当前放入的元素，k是当前层数
    void DFS(int target,int sum,vector<vector<int>>& v,vector<int>& t,vector<int>& candidates,int k){
        if(sum>target)
           return ;
        if(sum==target){
            v.push_back(t);
            return ;
        }
        for(int i=k;i<candidates.size();i++){
            t.push_back(candidates[i]);
            DFS(target,sum+candidates[i],v,t,candidates,i);
            t.pop_back();
        }
        return ;
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> v;
        vector<int> t;
        DFS(target,0,v,t,candidates,0);
        return v;
    }
};
```
