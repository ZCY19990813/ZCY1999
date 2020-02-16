## 题目来源：[剑指offer65 不用加减乘除做加法](https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)

## 题意：写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

### 输入: 2 -1 输出: 1

### 思路：
 - 1.计算不进位的和，相当于对两个数进制异或：1101^1001=0100；
 - 2.计算进位，第1位相当于对两个数求与：1101&1001=1001，然后再对其进行左移1位：1001<<1=10010。
 - 然后再重复以上两个步骤。这里再异或一次就得到结果了，没进位：0100^10010=10110=22。
 - 计算a+b，等价于(a^b)+((a&b)<<1)。
 - 由于公式中又出现了+号，因此要再重复2）这个等价的计算过程。
 - 结束条件是：没有进位了。

### AC代码：

```
class Solution {
public :
    int add(int a, int b) {
        unsigned int aa=a;
        unsigned int bb=b;
        while (bb != 0) {
            int temp = aa ^ bb;   //相加各位的值
            bb = (aa & bb) << 1;   //计算进位的值，一定要加括号，位移优先级高于与运算的
            aa = temp;   //让a作为temp（相加各位的值的结果），再和b（进位）去异或，就是相加操作，只要进位不为0，这个循环就一直进行下去
        }
        return aa;
    }
};
```

### 变形：那如果求减法呢？先b取反加1

```
class Solution {
public :
    int add(int a, int b) {
        unsigned int aa=a;
        unsigned int bb=~b;
        //取反加一
        int aaa=1;
        while(aaa!=0){
            int t=aaa^bb;
            aaa=(aaa&bb)<<1;
            bb=t;
        }
        //现在bb就是b取反加一
        while (bb != 0) {
            int temp = aa ^ bb;   //相加各位的值
            bb = (aa & bb) << 1;   //计算进位的值，一定要加括号，位移优先级高于与运算的
            aa = temp;   //让a作为temp（相加各位的值的结果），再和b（进位）去异或，就是相加操作，只要进位不为0，这个循环就一直进行下去
        }
        return aa;
    }
};
```


### 补充：不用新的变量交换两个变量的值：
  - a=a+b; b=a-b; a=a-b;
  - a=a^b; b=a^b; a=a^b;
