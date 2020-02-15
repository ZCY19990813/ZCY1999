## 题目来源：[剑指offer55 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/submissions/)

## 题意1：输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

### 输入1：[3,9,20,null,null,15,7] 输出1:3

### 思路1：遍历找最大的深度

### AC代码1：

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
    int maxDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        int ans=0;
        depthAdd(root,ans,1);
        return ans;
    }
    void depthAdd(TreeNode* root,int& ans,int k){
        if(root->left==NULL&&root->right==NULL){
            if(k>=ans)
                ans=k;
            return ;
        }
        if(root->left!=NULL)
          depthAdd(root->left,ans,k+1);
        if(root->right!=NULL)
            depthAdd(root->right,ans,k+1);
        return ;
    }
};
```
## 题目来源2：[剑指offer55 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)

## 题意2：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

### 输入2：[3,9,20,null,null,15,7] 输出2:true

### 思路2：注意每个结点只遍历一次。先判断其左右子树是不是符合，每次遍历记住深度。

### AC代码2：

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
    bool isBalanced(TreeNode* root) {
        int ans=0;
        return isDepth(root,ans);
    }
    bool isDepth(TreeNode* root,int& depth){
        if(root==NULL){
            depth=0;
            return true;
        }
        int left,right;
        if(isDepth(root->left,left)&&isDepth(root->right,right)){
            int t=right-left;
            if(abs(t)<=1){
                depth=max(left,right)+1;
                return true;
            }
        }
        return false;
    }
};
```
