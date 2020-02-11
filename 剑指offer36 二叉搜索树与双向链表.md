## 题目来源：[剑指offer36 二叉搜索树与双向链表](https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

### 输入：[10,6,14,4,8,12,16]输出：[4,6,8,10,12,14,16](双向)

### 思路：利用中序遍历，将左子树先转化为双向链表，递归来实现。

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
    TreeNode* Convert(TreeNode* pRootOfTree)
    {
        TreeNode *ans=NULL;
        ConnectNode(pRootOfTree,&ans);
        //ans指向双向链表的尾结点
        //我们需要返回右结点
        TreeNode* p=ans;
        while(p!=NULL&&p->left!=NULL)
            p=p->left;
        return p;
    }
    void ConnectNode(TreeNode* p,TreeNode** ans){
        if(p==NULL)
            return ;
        TreeNode *pCurrent=p;
        if(pCurrent->left!=NULL)
            ConnectNode(pCurrent->left,ans);
        pCurrent->left=*ans;
        if(*ans!=NULL)
            (*ans)->right=pCurrent;
        *ans=pCurrent;
        if(pCurrent->right!=NULL)
            ConnectNode(pCurrent->right,ans);
    }
};
```

