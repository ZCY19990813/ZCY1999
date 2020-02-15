## 题目来源：[剑指offer51 数组中的逆序对(困难)](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)

## 题意：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

### 输入：[7,5,6,4] 输出：5

### 思路：先把数组分隔成子数组，统计出子数组内部的逆序对的数目，然后在统计出两个相邻子数组之间逆序对的数目。在统计逆序对的过程中，还需要对数组进行排序，实际上就是归并排序的过程。时间复杂度O(nlogn)，空间复杂度O(n)。

### AC代码：

```
class Solution {
public:
    int reversePairs(vector<int>& nums) {
        int n=nums.size();
        if(n<=0)
            return 0;
        vector<int> copyy;
        for(int i=0;i<n;i++)
            copyy.push_back(nums[i]);
        return  Judje(nums,copyy,0,n-1);
    }
    int Judje(vector<int>& nums,vector<int>& copy,int s,int e){
        if(s==e){
            copy[s]=nums[s];
            return 0;
        }
        int length=(e-s)/2;
        int left=Judje(copy,nums,s,s+length);
        int right=Judje(copy,nums,s+length+1,e);

        int i=s+length;//i初始化为前半段最后一个数字的下标
        int j=e;//j初始化为后半段最后一个数字的下标

        int index=e;
        int count=0;

        while(i>=s&&j>=s+length+1){
            if(nums[i]>nums[j]){
                copy[index--]=nums[i--];
                count+=j-s-length;
            }
            else
                copy[index--]=nums[j--];
        }
        for(;i>=s;i--)
            copy[index--]=nums[i];
        for(;j>=s+length+1;j--)
            copy[index--]=nums[j];
        return left+right+count;
    }
};
```
