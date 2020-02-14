## 题目来源：[剑指offer48 最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

## 题意：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

### 输入："abcabcbb" 输出：3  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

### 思路1：利用l,r位置计算。这种方法不如下面的方法时间短。

### AC代码1：

```
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char,int> ma;
        s=" "+s;
        int l=1,r=0;
        int maxx=0;
        for(int i=1;i<s.size();i++){
            if(ma[s[i]]==0){
                ma[s[i]]=i;
                r++;
            }
            else{
                int pos=ma[s[i]];
                for(int j=l;j<pos;j++)
                    ma[s[j]]=0;
                r=i;
                l=pos+1;
                ma[s[i]]=i;
            }
            maxx=max(maxx,r-l+1);
        }
        return maxx;
    }
};
```
### 思路2：f(i)表示以第i个字符为结尾的不包含重复字符的子字符串的最长长度。当我们计算到以第i个字符为结尾的不包含重复字符的子字符串的最长长度f(i)时我们已经知道f(i-1)了。如果第i个字符之前没有出现过，那f(i)=f(i-1)+1；如果第i个字符之前出现过，首先我们要计算这个字符与上次出现的位置只差d,如果d<=f(i-1),说明上次出现的位置在f(i-1)对应的最长字串中，所以f(i)=d.如果d>f(i-1),说明上次出现的位置在f(i-1)对应的最长字串之前，所以f(i)=f(i-1)+1.
### AC代码2：
```
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int cur=0,maxlength=0;
        int pos[228];
        for(int i=0;i<228;i++)
            pos[i]=-1;
        for(int i=0;i<s.size();i++){
            int p=pos[s[i]];
            if(p<0||i-p>cur)
                cur++;
            else{
                if(cur>maxlength)
                    maxlength=cur;
                cur=i-p;
            }
            pos[s[i]]=i;
        }
        if(cur>maxlength)
            maxlength=cur;
        return maxlength;
    }
};
```
