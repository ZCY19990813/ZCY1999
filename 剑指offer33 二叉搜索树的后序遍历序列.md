## 题目来源：[剑指offer33 二叉搜索树的后序遍历序列](https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

### 输入：[5,7,6,9,11,10,8] 输出：true
### 输入：[7,4,6,5] 输出：false

### 思路：二叉搜索树具有如下特征：(1)节点的左子树只包含小于当前节点的数。(2)节点的右子树只包含大于当前节点的数。(3)所有左子树和右子树自身必须也是二叉搜索树。可以根据左右根划分为左右子树，然后分别看其左右子树是不是满足二叉搜索树。


### AC代码：

```
class Solution {
public:
    bool Judje(vector<int> sequence,int left,int right){
        //cout<<left<<" "<<right<<endl;
        if(left==right)
            return true;
        if(left>right)
            return false;
        int root=sequence[right];
        int left1=0;
        for(int i=left;i<right;i++){
            if(sequence[i]>root)
                break;
            left1=i;
        }
        for(int i=left1+1;i<right;i++){
            if(sequence[i]<root)
                return false;
        }
        bool t1=true;
        if(left1>0)
            t1=Judje(sequence,left,left1);
        bool t2=true;
        if(left1<right-1)
            t2=Judje(sequence,left1+1,right-1);
        return t1&&t2;
    }
    bool VerifySquenceOfBST(vector<int> sequence) {
        int n=sequence.size();
        if(n<=0)
            return false;
        return Judje(sequence,0,n-1);
    }
};
```

