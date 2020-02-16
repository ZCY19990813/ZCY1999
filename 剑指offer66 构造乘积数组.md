## 题目来源：[剑指offer66 构造乘积数组](https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/)

## 题意：给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

### 输入: [1,2,3,4,5] 输出: [120,60,40,30,24]

### 思路：如果用除法之间成绩除以这个数即可，这样只能计算除这个数外的乘积了，为了避免重复计算，我们用两个数组来记录一下乘积，一个从左边开始，一个从右边开始。

### AC代码：

```
class Solution {
public:
    vector<int> constructArr(vector<int>& a) {
        vector<int> ans;
        int n=a.size();
        if(n<1)
            return ans;
        if(n==1)
            return a;
        vector<int> b(n,1);
        vector<int> c(n,1);
        b[0]=a[0];
        for(int i=1;i<n;i++){
            b[i]=a[i]*b[i-1];
        }
        c[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--)
            c[i]=a[i]*c[i+1];
            
        ans.push_back(c[1]);
        for(int i=1;i<n-1;i++){
            ans.push_back(b[i-1]*c[i+1]);
        }
        ans.push_back(b[n-2]);
        return ans;
    }
};
```

