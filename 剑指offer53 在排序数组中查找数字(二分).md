## 题目来源：[剑指offer53 在排序数组中查找数字](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

## 题意1：统计一个数字在排序数组中出现的次数。

### 输入1：nums = [5,7,7,8,8,10], target = 8 输出: 2

### 思路1：可以通过二分找到该数存在，然后遍历左右，但时间上和遍历数组没有区别，所以我们需要通过二分找到左边界和右边界，然后求差。

### AC代码1：

```
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n=nums.size();
        if(n<=0)
            return 0;
        int left=0;
        int right=n-1;
        int ans1=0,ans2=0;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>=target)
                right=mid;
            else
                left=mid+1;
        }
        if(nums[left]!=target)
            return 0;
        ans1=left;
        right=n;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]<=target)
                left=mid+1;
            else
                right=mid;
        }
        ans2=left;
        return ans2-ans1;
    }
};
```
## 题目来源：[0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

## 题意2：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

### 输入2：[0,1,3] 输出2：2

### 思路2：可以求和来找出那个数，但有更好的方法：二分，需要找到一个可以标志的特点，最后点落在了下标上面。根据下标来找那个数。

### AC代码2：

```
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n=nums.size();
        if(n<=0)
            return 0;
        int left=0,right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==mid)
                left=mid+1;
            else{
                if(mid==0||nums[mid-1]==mid-1)
                    return mid;
                right=mid-1;
            }
        }
        if(left==n)
            return n;
        return -1;
    }
};
```

## 题意3：排序数组中下标与数字相同的元素

### 输入3：[-3,-1,1,3,5] 输出3：3

### 思路3：二分。

### AC代码3：

```
int Judje(vector<int>& nums) {
        int n=nums.size();
        if(n<=0)
            return 0;
        int left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==mid)
                return mid;
	    if(nums[mid]>mid)
		right=mid-1;
            else
		left=mid+1;
        }
        return -1;
    }
```
