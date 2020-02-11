## 题目来源：[剑指offer34 二叉树中和为某一值的路径](https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

### 输入：[10,5,12,4,7] 输出：[[10,5,7],[10,12]]

### 思路：DFS递归，写的时候注意pop,否则输出的不是正确的路径。

### AC代码：

```
/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
class Solution {
public:
    vector<vector<int>> ans;
    bool static cmp(vector<int>& p,vector<int>& q){
        return p.size()>q.size();
    }
    void Judje(TreeNode* root,vector<int>& t,int sum,int expectNumber){
        t.push_back(root->val);
        sum+=root->val;
        if(sum==expectNumber&&root->left==NULL&&root->right==NULL){
            ans.push_back(t);
        }
        if(root->left!=NULL)
            Judje(root->left,t,sum,expectNumber);
        if(root->right!=NULL)
            Judje(root->right,t,sum,expectNumber);
        t.pop_back();//****
        return ;
    }
    vector<vector<int> > FindPath(TreeNode* root,int expectNumber) {
        if(root==NULL)
            return ans;
        vector<int> t;
        Judje(root,t,0,expectNumber);
        sort(ans.begin(),ans.end(),cmp);
        return ans;
    }
};
```

