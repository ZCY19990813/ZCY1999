## 题目来源：[剑指offer59 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

## 题意：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

### 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
  - 输出: [3,3,5,5,6,7] 
  - 解释: 
     - 滑动窗口的位置                最大值
     - ---------------               -----
     - [1  3  -1] -3  5  3  6  7        3
     -  1 [3  -1  -3] 5  3  6  7        3
     -  1  3 [-1  -3  5] 3  6  7        5
     -  1  3  -1 [-3  5  3] 6  7        5
     -  1  3  -1  -3 [5  3  6] 7        6
     -  1  3  -1  -3  5 [3  6  7]       7


### 思路：index是一个两端开口的队列，用来保存有可能是滑动窗口最大值的数字的下标。在存入一个数字的下标之前，首先要判断队列里已有数字是否小于待存入的数字。如果已有的数字小于待存入的数字，那么这些数字已经不可能是滑动窗口的最大值了，因此他们将会被依次的从队列尾部删除。同时，如果队列头部的数字已经从窗口里面滑出，那么滑出的数字也需要从队列的头部删除。

### AC代码：

```
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int size) {
        vector<int> ans;
        if(nums.size()<size||size<=0)
            return ans;
        deque<int> index;
        for(int i=0;i<size;i++){
            while(!index.empty()&&nums[i]>nums[index.back()])
                index.pop_back();
            index.push_back(i);
        }
        for(int i=size;i<nums.size();i++){
            ans.push_back(nums[index.front()]);
            while(!index.empty()&&nums[i]>nums[index.back()])
                index.pop_back();
            if(!index.empty()&&index.front()<=(int)(i-size))
                index.pop_front();
            index.push_back(i);
        }
        ans.push_back(nums[index.front()]);
        return ans;
    }
};
```

## 题目来源：[剑指offer59 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)

## 题意：请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。若队列为空，pop_front 和 max_value 需要返回 -1。

### 输入：["MaxQueue","push_back","push_back","max_value","pop_front","max_value"][[],[1],[2],[],[],[]] 输出：[null,null,null,2,1,2]

### 思路：用一个队列保存正常元素，另一个双向队列保存单调递减的元素 。入栈时，第一个队列正常入栈；第二个队列是递减队列，所以需要与之前的比较，从尾部把小于当前value的全部删除（因为用不到了）。出栈时，第一个队列正常出栈；第二个队列的头部与出栈的值作比较，如果相同，那么一起出栈。


### AC代码：

```
class MaxQueue {
public:
    MaxQueue() {
        
    }
    
    int max_value() {
        if(q2.empty())
            return -1;
        return q2.front();
    }
    
    void push_back(int value) {
        q1.push_back(value);
        while(!q2.empty()){
            if(q2.back()<=value)
                q2.pop_back();
            else 
                break;
        }
        q2.push_back(value);
    }
    
    int pop_front() {
        if(q1.empty())
            return -1;
        int t=q1.front();
        if(q2.front()==t)
            q2.pop_front();
        q1.pop_front();
        return t;
    }
    private:
        deque<int> q1;
        deque<int> q2;
};

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue* obj = new MaxQueue();
 * int param_1 = obj->max_value();
 * obj->push_back(value);
 * int param_3 = obj->pop_front();
 */
```
