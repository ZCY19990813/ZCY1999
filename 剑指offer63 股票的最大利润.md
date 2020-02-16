## 题目来源：[剑指offer63 股票的最大利润](https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/)

## 题意：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

### 输入: [7,1,5,3,6,4] 输出: 5
### 输入：[7,6,4,3,1] 输出：0

### 思路：记录每次的最小值，然后就每一位与最小值差的最大值即可。

### AC代码：

```
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size()<2)
            return 0;
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.size();i++){
            if(prices[i]-min>=max)
                max=prices[i]-min;
            if(prices[i]<min)
                min=prices[i];
        }
        return max;
    }
};
```
