## 题目来源：[剑指offer39 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

## 题意：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。你可以假设数组是非空的，并且给定的数组总是存在多数元素。

### 输入： [1, 2, 3, 2, 2, 2, 5, 4, 2] 输出：2

### 思路1：因为会超过半数，所以在排好序后中间的数一定是所求数字，可以采取快速排序的思想。在随机快速排序算法中，我们先在数组中随机选择一个数字，然后调整数组中数字的顺序，使得比选中的数字小的在其左边，否则在右边，如果被选中的数字的下标是n/2,则这个数字就是所求。

### 注意：如果题目没有说数组是合法的，那需要判断一下。

### AC代码
```
class Solution {
public:
    int Partition(vector<int>& nums, int low, int high) {
        // 任取一元素与首元素交换，以交换后的首元素作为基准
        int r = low + rand() % (high - low + 1);
        int tmp = nums[low];
        nums[low] = nums[r];
        nums[r] = tmp;
        int pivot = nums[low];
        // 由向量两端向中部扫描
        while (low < high) {
            while (low < high && pivot <= nums[high])
                high--;
            nums[low] = nums[high];
            while (low < high && pivot >= nums[low])
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
    int majorityElement(vector<int>& nums) {
        int mid=(nums.size())>>1;
        int start=0,end=nums.size()-1;
        int index=Partition(nums,start,end);
        while(index!=mid){
            if(index>mid){
                end=index-1;
                index=Partition(nums,start,end);
            }
            else{
                start=index+1;
                index=Partition(nums,start,end);
            }
        }
        return nums[mid];
    }
};
```

### 思路2：数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所以数字出现的次数的和还要多。所以我们需要保存两个值，一个是数组中的一个数字，另一个是它出现的次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，次数就加1，否则次数减1，如果次数为0，就记录下一个数字，并把次数置为1.

### AC代码：

```
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if(nums.size()<=0)
            return 0;
        int num=nums[0];
        int time=1;
        for(int i=1;i<nums.size();i++){
            if(time==0){
                num=nums[i];
                time=1;
            }
            else if(num==nums[i])
                time++;
            else
                time--;
        }
        return num;
    }
};
```


### AC代码（检查是否数组满足条件）：
```
class Solution {
public:
    bool Check(vector<int>& nums,int num){
        int time=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==num)
                time++;
        }
        if(time*2<=nums.size())
            return false;
        return true;
    }
    int MoreThanHalfNum_Solution(vector<int>& nums) {
        if(nums.size()<=0)
            return 0;
        int num=nums[0];
        int time=1;
        for(int i=1;i<nums.size();i++){
            if(time==0){
                num=nums[i];
                time=1;
            }
            else if(num==nums[i])
                time++;
            else
                time--;
        }
        if(!Check(nums,num))
            return 0;
        return num;
    }
};
```
