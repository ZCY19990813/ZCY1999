## 题目来源：[力扣104 二叉树的最大深度(简单题)](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)

### 战绩：执行用时 :12 ms, 在所有 C++ 提交中击败了72.73%的用户，内存消耗 :19.6 MB, 在所有 C++ 提交中击败了5.09%的用户

## 题意：给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。说明: 叶子节点是指没有子节点的节点。

### 输入： [3,9,20,null,null,15,7] 输出：3

### 思路：递归
### AC代码：
```
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxx=-1;
    void depth(TreeNode* root,int dep){
        maxx=max(dep,maxx);
       // cout<<root->val<<" "<<dep<<endl;
        if(root->left!=NULL)
            depth(root->left,dep+1);
        if(root->right!=NULL)
            depth(root->right,dep+1);
        return ;
    }
    int maxDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        depth(root,1);
        return maxx;
    }
};
```
