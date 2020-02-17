## 题目来源：[剑指offer8 二叉树的下一个结点](https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

### 思路：
  - 如果一个结点有右子树，那么它的下一个结点就是右子树中最左的结点。
  - 如果这个结点没有右子树：
    - 如果这个结点是他父节点的左子节点，那么它的下一个结点就是它的父节点。
    - 否则这个结点是他父节点的右子节点：我们沿着父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的结点。如果这个结点存在，那么这个结点的父节点就是我们找的下一个结点。

### AC代码：

```
/*
struct TreeLinkNode {
    int val;
    struct TreeLinkNode *left;
    struct TreeLinkNode *right;
    struct TreeLinkNode *next;
    TreeLinkNode(int x) :val(x), left(NULL), right(NULL), next(NULL) {
        
    }
};
*/
class Solution {
public:
    TreeLinkNode* GetNext(TreeLinkNode* pNode)
    {
        if(pNode==NULL)
            return NULL;
        TreeLinkNode* pNext=NULL;
        if(pNode->right!=NULL){
            TreeLinkNode* pRight=pNode->right;
            while(pRight->left!=NULL)
                pRight=pRight->left;
            pNext=pRight;
        }
        else if(pNode->next!=NULL){
            TreeLinkNode* pCurrent=pNode;
            TreeLinkNode* pParent=pNode->next;
            while(pParent!=NULL&&pCurrent==pParent->right){
                pCurrent=pParent;
                pParent=pParent->next;
            }
            pNext=pParent;
        }
        return pNext;
    }
};
```
