## 题目来源：[剑指offer42 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

## 题意：输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。提示：1 <= arr.length <= 10^5，-100 <= arr[i] <= 100。

### 输入：[-3,-2,-2,-3] 输出：-2

### 思路1：遍历数组，如果和小于0，说明没有必要加上前面的，将和变为0，此处开始加即可，每次取最大值。

### AC代码
```
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n=nums.size();
        int maxx=-9999999,sum=0;
        if(n<=0)
            return 0;
        for(int i=0;i<n;i++){
            if(sum<=0)
                sum=nums[i];
            else
                sum+=nums[i];
            if(sum>=maxx)
                maxx=sum;
        }
        return maxx;
    }
};
```
### [做法2](https://blog.csdn.net/ZCY19990813/article/details/100932027)
