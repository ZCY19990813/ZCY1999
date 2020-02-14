## 题目来源：[剑指offer50 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

## 题意：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。

### 输入："abaccdeff" 输出："b"

### 思路：用空间换取时间，先遍历一遍用map存下来，之后在遍历一遍找第一个只出现一次的。

### AC代码：

```
class Solution {
public:
    char firstUniqChar(string s) {
        char ans=' ';
        map<char,int> ma;
        for(int i=0;i<s.size();i++)
            ma[s[i]]++;
        for(int i=0;i<s.size();i++)
            if(ma[s[i]]==1){
                ans=s[i];
                break;
            }
        return ans;
    }
};
```
