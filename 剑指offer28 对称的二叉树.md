## 题目来源：[剑指offer28 对称的二叉树](nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

### 输入：[1,2,2,3,4,4,3] 输出：true


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
};
*/
class Solution {
public:
    bool Judje(TreeNode *t1,TreeNode *t2){
        if(t1==NULL && t2==NULL)
            return true;
        else
        if(t1==NULL||t2==NULL)
            return false;
        else
        {
            if(t1->val==t2->val&&(Judje(t1->left,t2->right)==1)&&(Judje(t1->right,t2->left)==1))
                return true;
            else
                return false;
        }
    }
    bool isSymmetrical(TreeNode* root) {
        return Judje(root,root);
    }
};
```

