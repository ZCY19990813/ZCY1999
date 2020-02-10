## 题目来源：[剑指offer27 二叉树的镜像](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：操作给定的二叉树，将其变换为源二叉树的镜像。

### 输入：[4,2,7,1,3,6,9] 输出：[4,7,2,9,6,3,1]

### 思路：不断递归，交换左右子树

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
    void Mirror(TreeNode* p){
        if(p==NULL)
           return ;
        if(p->left==NULL&&p->right==NULL)
            return ;
        TreeNode* t=p->left;
        p->left=p->right;
        p->right=t;
        if(p->left!=NULL)
            Mirror(p->left);
        if(p->right!=NULL)
            Mirror(p->right);
    }
};
```

