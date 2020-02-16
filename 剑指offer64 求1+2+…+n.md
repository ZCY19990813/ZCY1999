## 题目来源：[剑指offer64 求1+2+…+n](https://leetcode-cn.com/problems/qiu-12n-lcof/)

## 题意：求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

### 输入: 3 输出: 6

### 思路1：A && B
  - A 为 true，则返回表达式 B 的 bool 值
  - A 为 false，则返回 false

### AC代码1：

```
class Solution {
public:
    int sumNums(int n) {
        n && (n += sumNums(n-1));
        return n;
    }
};

```

### AC代码2：利用虚函数求解

```
class ConSum     //用构造函数实现
{
public:
	ConSum()      //利用创建n个对象来调n次构造函数
	{
		n++;
		sum += n;
	}
	static int GetSum()
	{
		return sum;
	}
	static int n;   //用静态数据存储才可达到累加效果
	static int sum;
};

int ConSum::n = 0;       //初始化静态成员
int ConSum::sum = 0;
class Solution {
public:
    int sumNums(int n) {
        ConSum::n = 0;       //初始化静态成员
        ConSum::sum = 0;
        ConSum *a = new ConSum[n];
	return ConSum::GetSum();   //访问静态成员函数必须用域作用符
    }
};
```
