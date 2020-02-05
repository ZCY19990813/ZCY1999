## 题目来源：[剑指offer10 斐波那契数列](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

### 输入：5  输出：8

### 思路：备忘录方法，n=1时为1，n=2时为2，n=3时为3……，所以f(n)=f(n-1)+f(n-2)，为了减少递归的次数，找个数组记录一下。

### AC代码：

```
class Solution {
public:
    vector<int> ans;
    int f(int n){
        int length=ans.size()-1;
        if(n<=length)
            return ans[n];
        ans.push_back(f(n-1)+f(n-2));
        return ans[n];
    }
    int jumpFloor(int number) {
        ans.push_back(0);
        ans.push_back(1);
        ans.push_back(2);
        int answer=f(number);
        return answer;
    }
};
```

## 题意：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

### 输入：n=4 输出：n=8

### 思路：n=1时为1，n=2时为2，n=3时为4……，所以f(n)=2^(n-1)，直接用快速幂。

### AC代码：

```
class Solution {
public:
    int jumpFloorII(int number) {
        return fast_power(2,number-1);
    }
    int fast_power(int a,int b){
        int ans=1;
        while(b){
            if(b&1)
                ans=a*ans;
            a=a*a;
            b>>=1;
        }
        return ans;
    }
};
```
