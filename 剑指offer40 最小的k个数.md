## 题目来源：[剑指offer40 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

## 题意：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

### 输入： [3,2,1] 2 输出：[1,2]或[2,1]

### 思路1：由39题得到启发，如果左边的数刚好为k个数就可以。下面是允许修改数组的时候才让用。时间复杂度O(n).

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
    vector<int> getLeastNumbers(vector<int>& nums, int k) {
        vector<int> ans;
        if(k<=0||k>nums.size())
            return ans;
        int start=0,end=nums.size()-1;
        int index=Partition(nums,start,end);
        while(index!=k-1){
            if(index>k-1){
                end=index-1;
                index=Partition(nums,start,end);
            }
            else{
                start=index+1;
                index=Partition(nums,start,end);
            }
        }
        for(int i=0;i<k;i++)
            ans.push_back(nums[i]);
        return ans;
    }
};
```

### 思路2：先用一个容器放入k个数，不断替换。如果用红黑树的话时间会是O(nlogk)，但下面代码的时间复杂度为O(nk)。

### AC代码：

```
class Solution {
public:
    vector<int> getLeastNumbers(vector<int>& nums, int k) {
        vector<int> t;
        if(k<=0||k>nums.size())
            return t;
        for(int i=0;i<nums.size();i++){
            if(t.size()<k)
                t.push_back(nums[i]);
            else{
                int maxx=-1,p=-1;
                for(int j=0;j<k;j++){
                    if(t[j]>=maxx){
                        maxx=t[j];
                        p=j;
                    }
                }
                if(nums[i]<maxx){
                    t[p]=nums[i];
                }
            }
        }
        return t;
    }
};
```

