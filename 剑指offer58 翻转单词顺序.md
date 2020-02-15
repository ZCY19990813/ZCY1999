## 题目来源：[剑指offer58 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

## 题意1：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

### 输入1： "  hello world!  " 输出: "world! hello" 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

### 思路1：下面是借助了一个vector存储了一下。

### AC代码1：

```
class Solution {
public:
    string reverseWords(string s) {
        vector<string> ans;
        for(int i=0;i<s.size();){
            string t="";
            while(s[i]==' ')
                i++;
            while(i<s.size()&&s[i]!=' '){
                t+=s[i];
                i++;
            }
            if(t!="")
                ans.push_back(t);
        }
        string sum="";
        for(int i=ans.size()-1;i>=0;i--){
            sum+=ans[i];
            if(i!=0)
                sum+=' ';
        }
        return sum;
    }
};
```
### 如果输出为" world!  hello  "，那么就不用考虑空格，一个巧妙办法是反转全部的字符串，在反转单个字符串(剑指offer的思想，先翻转所有的字符，然后利用滑动窗口的思想，遇到' '就翻转，然后两者一起跳转到' '后重新滑动。)。

### AC代码：

```
class Solution {
public:
    string ReverseSentence(string str) {
        if (str.size()<=0) 
            return str;
        string chars = str;
        reverseChars(chars, 0, str.size() - 1);
        // 利用滑动窗口
        // 遇到' '执行翻转
        int l = 0;
        int r = 0;
        while (l < str.size()) {
            if (chars[r] == ' ') {
                reverseChars(chars, l, r - 1);
                // 交换完之后,一起跳过' '
                r++;
                l = r;
            }
            if (r == str.size() - 1) {
                reverseChars(chars, l, r);
                // 到了最后交换玩就break，否则r会出现越界，可以在while中加对r的判断
                break;
            }
            r++;
        }
        return chars;
    }
    void reverseChars(string& chars, int l, int r) {
        while (l < r) {
            swap(chars[l],chars[r]);
            l++;
            r--;
        }
    }
};
```

## 题目来源2：[剑指offer58 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

## 题意2：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

### 输入2： s = "abcdefg", k = 2 输出: "cdefgab"

### 思路2：注意不合法的情况。

### AC代码2：
```
class Solution {
public:
    string LeftRotateString(string s, int n) {
        if(s.size()<=0||n>s.size())
            return s;
        return s.substr(n)+s.substr(0,n);
    }
};
```
