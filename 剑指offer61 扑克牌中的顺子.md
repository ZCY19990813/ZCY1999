## 题目来源：[剑指offer61 扑克牌中的顺子](https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

## 题意：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。数组长度为 5 数组的数取值为 [0, 13] .

### 输入:[0,0,1,2,5]  输出: true

### 思路：不是顺子的情况只有两种： 1）有对子（即重复数字）； 2）大小王数目不够弥补断裂空缺。 排序再判断即可（5个元素排序时间复杂度可以忽略）。

### AC代码：

```
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int s=0;//需要0的数目
        int i=4;
        for(i=4;i>=1;ia--){
            if(nums[i-1]==0)//跳出后，i为0的数量
                break;
            if(nums[i]==nums[i-1])
                return 0;
            s+=nums[i]-nums[i-1]-1;
        }
        return s<=i;
    }
};
```
