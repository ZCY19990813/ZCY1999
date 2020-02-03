## 题目来源：[剑指offer 21 调整数组顺序使奇数位于偶数前面](https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

### 输入: [1,2,3,4,5,6,7] 输出: [1,3,5,7,2,4,6]

### 思路1：如果只是不考虑顺序，可以设置两个指针。例如代码1.
### 思路2：但是是需要考虑顺序的，可以优先考虑时间或者空间，如果时间优先的话借助空间来辅佐(代码2)，如果空间不够的话可以增加时间(代码3).

### 代码1(没考虑顺序，未AC)：
```
class Solution {
public:
    void reOrderArray(vector<int> &array) {
        int n=array.size();
        int left=0,right=n-1;
        while(left<right){
            while(array[left]%2!=0&&left<n)
                left++;
            while(array[right]%2==0&&right>=0)
                right--;
            if(left<right){
                swap(array[left],array[right]);
            }
        }
    }
};
```
### 代码2：
```
class Solution {
public:
    void reOrderArray(vector<int> &array) {
        int n=array.size();
        vector<int> ans;
        for(int i=0;i<n;i++)
            if(array[i]%2!=0)
                ans.push_back(array[i]);
        for(int i=0;i<n;i++)
            if(array[i]%2==0)
                ans.push_back(array[i]);
        for(int i=0;i<n;i++)
            array[i]=ans[i];
    }
};
```
### 代码3：

```
class Solution {
public:
    void reOrderArray(vector<int> &array) {
        int n=array.size();
        int left=0;
        while(left<n){
            while(array[left]%2!=0&&left<n)//找到偶数
                left++;
            int right=left+1;
            while(array[right]%2==0&&right<n)//从left+1开始找到下一个奇数
                right++;
            if(right<n){
                int t=array[right];
                for(int i=right;i>left;i--){//不能直接交换left和right，需要往后移动
                    array[i]=array[i-1];
                }
                array[left]=t;
            }
            else break;//不满足跳出，否则时间超限
        }
    }
};
```
