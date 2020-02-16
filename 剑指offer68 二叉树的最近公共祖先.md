## 题目来源：[剑指offer68 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

## 题意：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

### 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8  输出:6 
### 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4  输出: 2

### 思路：因为二叉搜索树的特点就是左子树的值小于根节点的值，根节点的值小于右子树的值，所以我们就需要根据值来判断是往左子树走还是往右子树走。

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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==NULL||p==NULL||q==NULL)
            return NULL;
        while(root!=NULL){
            if(root->val >= p->val && root->val <= q->val||root->val >= q->val && root->val <= p->val)
                return root;
            else if(root->val > p->val && root->val > q->val)
                root=root->left;
            else if(root->val < p->val && root->val < q->val)
                root=root->right;
        }
        return root;
    }
};
```

## 题目来源：[剑指offer68 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

## 题意：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

### 输入:  root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3

### 思路：两个节点p,q分为两种情况：(1)p和q在相同子树中.(2)p和q在不同子树中.从根节点遍历，递归向左右子树查询节点信息.递归终止条件：如果当前节点为空或等于p或q，则返回当前节点.递归遍历左右子树，如果左右子树查到节点都不为空，则表明p和q分别在左右子树中，因此，当前节点即为最近公共祖先；如果左右子树其中一个不为空，则返回非空节点。

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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root==NULL || root == p || root == q) {
            return root;
        }
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if (left && right) {
            return root;
        }
        return left ? left : right;
    }
};
```
