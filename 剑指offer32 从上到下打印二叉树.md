## 题目来源：[剑指offer32 从上到下打印二叉树](https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意1：从上往下打印出二叉树的每个节点，同层节点从左至右打印。

### 输入：[10,6,14,4,8,12,16] 输出：[10,6,14,4,8,12,16]

### 思路：不能递归，找个队列存一下。

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
    vector<int> PrintFromTopToBottom(TreeNode* root) {
        vector<int> ans;
        if(root==NULL)
            return ans;
        queue<TreeNode*> q;
        q.push(root);
        while(q.size()){
            TreeNode* t=q.front();
            q.pop();
            ans.push_back(t->val);
            if(t->left!=NULL)
               q.push(t->left);
            if(t->right!=NULL)
               q.push(t->right);
        }
        return ans;
    }
};
```

## 题意2：

### 输入：输出：

### 思路：

### AC代码：
```

```


## 题意3：

### 输入：输出：

### 思路：

### AC代码：
```

```
