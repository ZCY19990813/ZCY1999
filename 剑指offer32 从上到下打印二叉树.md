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

## 题意2：[把二叉树打印成多行](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

### 输入：[3,9,20,null,null,15,7] 输出：[[3],[9,20],[15,7]]

### 思路：

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
    void DFS(int level,TreeNode* root,vector<vector<int>>& v){
        if(root==NULL)
            return ;
        if(level>=v.size()) 
            v.push_back(vector<int>());//创建完了才能放
        v[level].push_back(root->val);
        DFS(level+1,root->left,v);
        DFS(level+1,root->right,v);
        return ;
    }
    vector<vector<int>> Print(TreeNode* root) {
        vector<vector<int>> v;
        DFS(0,root,v);
        return v;
    }
    
};
```


## 题意3：[按之字形顺序打印二叉树](https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

### 输入：[3,9,20,null,null,15,7] 输出:[[3],[20,9],[15,7]]

### 补充：插入元素：vec.insert(vec.begin()+i,a);在第i+1个元素前面插入a; 删除元素：vec.erase(vec.begin()+2);删除第3个元素

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
    void DFS(int level,TreeNode* root,vector<vector<int>>& v){
        if(root==NULL)
            return ;
        if(level>=v.size()) 
            v.push_back(vector<int>());//创建完了才能放
        if(level%2==0)
           v[level].push_back(root->val);
        else
           v[level].insert(v[level].begin(),root->val);
        DFS(level+1,root->left,v);
        DFS(level+1,root->right,v);
        return ;
    }
    vector<vector<int>> Print(TreeNode* root) {
        vector<vector<int>> v;
        DFS(0,root,v);
        return v;
    }
    
};
```
