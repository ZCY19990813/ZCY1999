## 题目来源：[剑指offer19 正则表达式匹配](https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/)

## 题意：请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。s 可能为空，且只包含从 a-z 的小写字母。p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

### 输入 ："aa" "a"  输出：false
### 输入 ："aa" "a*"  输出：true
### 输入 ："ab" ".*"  输出：true
### 输入 ："aab" "c*a*b"  输出：true
### 输入 ："mississippi" "mis*is*p*."  输出：false


### 思路：
 - 字符串的data()函数将string转化成char型数组
 - 两个if语句排除所有肯定为true和肯定为false的情况，注意当第一个字符串为空，第二个不为空时依然可能匹配成功
 - 第三个if语句 分情况讨论 下一个字符是否为'*'
   - 若下一个字符不是*时,当上一个字符匹配成功时(注意匹配成功的两种可能情况)，接下来用递归isMatch(str+1,pat+1)继续匹配即可
若匹配失败，则直接返回false
   - 若下一个字符是星号时，则接下来的星号可以代表0个或多个；若代表0个字符，则递归isMatch(str,pat+2)直接跳过'*',若代表一个字符,则递归isMatch(str+1,pat)，去比较str中下一个字符。而当星号代表多于一个字符时，事情其实和代表一个字符的情形相同，因为匹配多于一个字符时,相当于str从下一个位置继续开始往后进行匹配。若匹配失败，此时因为星号前的字符可以出现0次，并不妨碍其后依然可能匹配成功，故return isMatch(str,pat+2)跳过星号继续判断**


### AC代码：

```
class Solution {
public:
    bool isMatch(string s, string p) {
    char* str=s.data(),*pat=p.data();
    if(*str=='\0'&&*pat=='\0') return true;
    if(*str!='\0'&&*pat=='\0') return false;

    if(*(pat+1)!='*'){
         if(*str==*pat||(*str!='\0'&&*pat=='.'))
            return isMatch(str+1,pat+1);
         else return false;
    }
    else{
         if(*str==*pat||(*str!='\0'&&*pat=='.'))
            return isMatch(str,pat+2)||isMatch(str+1,pat);
         else return isMatch(str,pat+2);
    }     
    }
};

```
### 思路：使用动态规划自底向上方法。定义boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]，初始化dp[s.length()][p.length()] = true，表示当两者都为空时匹配。如何得到dp[i][j]的值？首先判断s.charAt(i)和p.charAt(j)是否匹配，匹配的条件是两个字符相同，或者p.charAt(j)是'.'。然后判断p.charAt(j + 1)是不是'*'，若是，由于'*'可匹配0个字符，当dp[i][j + 2] == true时dp[i][j] = true，另外当目前的字符匹配且d[i + 1][j] == true时dp[i][j] = true。如果p.charAt(j + 1)不是'*'，则dp[i][j] = true当且仅当目前的字符匹配且dp[i + 1][j + 1] == true。最后返回dp[0][0]。

### AC代码：

```
class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length(), pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[sLength][pLength] = true;
        for (int i = sLength; i >= 0; i--) {
            for (int j = pLength - 1; j >= 0; j--) {
                boolean charMatch = i < sLength && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j < pLength - 1 && p.charAt(j + 1) == '*')
                    dp[i][j] = dp[i][j + 2] || charMatch && dp[i + 1][j];
                else
                    dp[i][j] = charMatch && dp[i + 1][j + 1];
            }
        }
        return dp[0][0];
    }
} 
```
