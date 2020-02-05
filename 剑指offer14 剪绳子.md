## 题目来源：[剑指offer14 剪绳子](https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。2<=n<=60

### 思路1：动态规划。时间空间复杂度O(n)。在剪第一刀的时候，我们有n-1种选择：1,2……n-1,因此a[n]=max(a[i]*a[n-i])。

### AC代码：
```
class Solution {
public:
    vector<int> a;
    int cutRope(int number) {
	if(number==2)
            return 1;
        if(number==3)
            return 2;
        a.push_back(0);
        a.push_back(1);
        a.push_back(2);//这里不是代表a[2]=2,因为在进行下面操作的时候，例如4=2*2，需要用到a[2]=2.
        a.push_back(3);
        //a[n]=max(a[i]*a[n-i]) 1<=i<=n-1
        for(int i=4;i<=number;i++){
            int maxx=0;
            for(int j=1;j<=i/2;j++){
                if(a[j]*a[i-j]>maxx)
                    maxx=a[j]*a[i-j];
            }
            a[i]=maxx;
        }
        return a[number];
    }
};
```

### 思路2：贪心。当n>=5的时候，我们尽量把绳子剪成长度为3的绳子，当n==4,把绳子剪成长度为2的绳子。

### AC代码：

```
class Solution {
public:
    int cutRope(int number) {
        if(number==2)
            return 1;
        if(number==3)
            return 2;
        int timesof3=number/3;
        if(number-timesof3*3==1)
            timesof3-=1;
        int timesof2=(number-timesof3*3)/2;
        return (pow(3,timesof3)*pow(2,timesof2));
    }
};
```
