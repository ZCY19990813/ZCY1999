## 题目来源：[剑指offer45 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

## 题意：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

### 输入：[3,30,34,5,9]   输出："3033459"

### 思路：不能按照大小排序，两个变量n,m.拼接后nm和mn，看谁小谁排在前面。

### AC代码：

```
class Solution {
public:
    static bool cmp(int p,int q){
        string a="",b="";
        a+=to_string(p);
        a+=to_string(q);
        b+=to_string(q);
        b+=to_string(p);
        return a<b;
    }
    string minNumber(vector<int>& nums) {
        string ans="";
        sort(nums.begin(),nums.end(),cmp);
        for(int i=0;i<nums.size();i++)
            ans+=to_string(nums[i]);
        return ans;
    }
};
```

