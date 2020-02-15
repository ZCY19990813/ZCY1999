## 题目来源：[剑指offer57 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

## 题意1：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

### 输入1： nums = [2,7,11,15], target = 9 输出1：[2,7] 或者 [7,2]

### 思路1：因为数组是排好序的，所以之间用双指针即可。一个头，一个尾。

### AC代码1：

```
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n=nums.size();
        vector<int> ans;
        if(n<2)
            return ans;
        int left=0,right=n-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                ans.push_back(nums[left]);
                ans.push_back(nums[right]);
                return ans;
            }
            else if(nums[left]+nums[right]>target)
                right--;
            else if(nums[left]+nums[right]<target)
                left++;
        }
        return ans;
    }
};
```
## 题目来源2：[剑指offer57 和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)

## 题意2：输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

### 输入2：target = 9 输出2：[[2,3,4],[4,5]]

### 思路2：由上一个题目的影响，我们也可以用双指针来解决问题，小于3的一定不能组成，所以我们可以设这个序列中最小的数为l,初始为1，设这个序列中最大的数为r,初始化为2，然后一直往下l++或者r++.注意停止的条件，r<(1+target)/2。

### AC代码2：

```
class Solution {
public:
    vector<vector<int>> findContinuousSequence(int target) {
        vector<vector<int>> ans;
        if(target<3)
            return ans;
        vector<int> t;
        int sum=3;
        t.push_back(1);
        t.push_back(2);
        int end=(target+1)/2;
        while(t.size()>0&&t[0]<end){
            //cout<<"*";
            //cout<<t[0]<<" "<<t.size()<<" "<<sum<<endl;
            if(t.size()==2&&sum==target){
                ans.push_back(t);
                break;
            }
            if(sum==target){
                ans.push_back(t);
                sum-=t[0];
                t.erase(t.begin());
            }
            else if(sum>target){
                sum-=t[0];
                t.erase(t.begin());
            }
            else {
                sum+=t[t.size()-1]+1;
                t.push_back(t[t.size()-1]+1);
            }
        }
        return ans;
    }
};
```
