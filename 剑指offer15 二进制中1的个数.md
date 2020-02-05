## 题目来源：[剑指offer15 二进制中1的个数](https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

### 输入：5  输出：2

### 思路：把一个整数减去1，在和原来的数做与运算，会把该整数最右边的1变为0.那么一个整数的二进制表示中有几个1，就可以进行多少次这样的操作。

### AC代码：

```
class Solution {
public:
     int  NumberOf1(int n) {
         int ans=0;
         while(n){
             n=(n-1)&n;
             ans++;
         }
         return ans;
     }
};
```

## 相关题目1：用一条语句判断一个整数是不是2的整数次方。

### 思路1：一个整数如果是2的整数次方，那么二进制中有且只有一位1，而其他所有位都是0。基于上面的题目，进行一次操作：n&(n-1)，如果n变为了0，则说明该数是2的几次方。

## 相关题目2：输入两个整数m和n，计算需要改变m的二进制中多少位才可以变为n.

### 思路2：首先异或，然后统计得到的数中1的个数。
