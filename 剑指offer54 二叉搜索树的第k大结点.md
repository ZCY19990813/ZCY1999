## 题目来源：[剑指offer54 二叉搜索树的第k大结点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)

## 题意：给定一棵二叉搜索树，请找出其中第k大的节点。

### 输入：[5,3,6,2,4,null,null,1] 3 输出:4 

### 思路：中序遍历是左根右，这个的思路是右根左，直到k个位置结束。

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
    int kthLargest(TreeNode* root, int k) {
        if(root==NULL||k<=0)
            return NULL;
        TreeNode* t=KthNodeCore(root,k);
        if(t==NULL)
          return 0;
        return t->val;
    }
    TreeNode* KthNodeCore(TreeNode* root,int& k){
        TreeNode* t=NULL;
        if(root!=NULL&&root->right!=NULL)
            t=KthNodeCore(root->right,k);
        if(t==NULL){
            if(k==1)
                t=root;
            k--;
        }
        if(root!=NULL&&t==NULL&&root->left!=NULL)
            t=KthNodeCore(root->left,k);
        return t;
    }
};
```
