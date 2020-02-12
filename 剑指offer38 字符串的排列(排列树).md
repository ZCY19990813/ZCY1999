## 题目来源：[剑指offer38 字符串的排列(排列树)](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof)

## 题意：输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

### 输入：s="abc" 输出：["abc","acb","bac","bca","cab","cba"]

### 思路：典型的排列树，需要注意可能会有重复的，所以先用set去重，注意s为空的情况。

### AC代码：

```
class Solution {
public:
    set<string> ans;
    void DFS(string s,int n,int k){
        if(k>n)
            return ;
        if(k==n){
            ans.insert(s);
            return ;
        }
        for(int i=k;i<n;i++){
            swap(s[k],s[i]);
            DFS(s,n,k+1);
            swap(s[k],s[i]);
        }
    }
    vector<string> Permutation(string s) {
        vector<string> se;
        if(s.size()==0)
            return se;
        DFS(s,s.size(),0);
        set<string>::iterator it;
        for(it=ans.begin();it!=ans.end();it++){
            se.push_back(*it);
        }
        return se;
    }
};
```

