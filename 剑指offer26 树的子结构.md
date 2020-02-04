## 题目来源：[剑指offer26 树的子结构](https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

### 输入：[3,4,5,1,2,NULL,NULL,NULL,NULL,0] [4,1,2]  顺序遍历的二叉树  输出：true

### 思路：先在二叉树中找到结点值相同的结点，如果相同就在判断接下来的结点是否相同，如果不相同就继续遍历大树。

### 注意：因为结点的值为int型，如果是double型，就不能用==表示结点值相同了，如果两个值的差的绝对值小于0.0000001,就可以说这两个值相同。

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
    bool HasSubtree(TreeNode* pRoot1, TreeNode* pRoot2)
    {
        bool ans=false;
        if(pRoot1!=NULL&&pRoot2!=NULL){
            if(Equal(pRoot1->val,pRoot2->val))
                ans=DoesTree1HaveTree2(pRoot1,pRoot2);
            if(!ans)
                ans=HasSubtree(pRoot1->left,pRoot2);
            if(!ans)
                ans=HasSubtree(pRoot1->right,pRoot2);
        }
        return ans;
    }
    bool Equal(int pRoot1val,int pRoot2val){
        if(pRoot1val==pRoot2val)
            return true;
        return false;
    }
    bool DoesTree1HaveTree2(TreeNode* pRoot1,TreeNode* pRoot2){
        if(pRoot2==NULL)
            return true;
        if(pRoot1==NULL)
            return false;
        if(!Equal(pRoot1->val,pRoot2->val))
            return false;
        return DoesTree1HaveTree2(pRoot1->left,pRoot2->left)&&DoesTree1HaveTree2(pRoot1->right,pRoot2->right);
    }
};
```
