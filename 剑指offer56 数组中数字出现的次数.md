## 题目来源：[剑指offer56 数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/)

## 题意1：一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)

### 输入1：nums = [4,1,4,6] 输出1：[1,6] 或 [6,1]

### 思路1：如果是一个数字出现一次，其他都是两次，那么之接异或就好了，但是这个有两个数出现了1次，所以我们想着如何把这些数分组，使得分好的两个数组其中各有一个出现一次的数字。两个数字异或后右边数第一个1是分组的依据。

### AC代码1：

```
class Solution {
public:
    int Judje(int x,int p){//判断从右边数第k位是不是1
        x>>=p;
        return x&1;
    }
    vector<int> singleNumbers(vector<int>& nums) {
        int t=0;
        for(int i=0;i<nums.size();i++)
            t^=nums[i];
        int p=0;
        while(t){
            if(t%2!=0)
                break;
            p++;
            t/=2;
        }
        int ans1=0,ans2=0;
        for(int i=0;i<nums.size();i++){
            if(Judje(nums[i],p))
                ans1^=nums[i];
            else
                ans2^=nums[i];
        }
        return vector<int>{ans1,ans2};
    }
};
```
## 题目来源2：[剑指offer56 数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/)

## 题意2：在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

### 输入2：[3,4,3,3] 输出2:[4]

### 思路2：出现3次，那么二进制中为1的肯定能%3=0，所以我们根据二进制存储一下，找到二进制中位数%3==1的即可。

### AC代码2：

```
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int diget[32]={0};
        for(int i=0;i<nums.size();i++){
            for(int j=0;nums[i]!=0;j++){
                if(nums[i]%2==1)
                    diget[j]++;
                nums[i]/=2;
            }
        }
        long long int p=1;
        int ans=0;
        for(int i=0;i<32;i++){
            //cout<<diget[i]<<" ";
            if(diget[i]%3==1)
                ans+=p;
            p*=2;
        }
        return ans;
    }
};
```
