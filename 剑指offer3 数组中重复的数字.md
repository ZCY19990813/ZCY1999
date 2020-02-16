## 题目来源：[剑指offer3 数组中重复的数字](https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

### 输入:[2,3,1,0,2,5,3] 输出: 2

### 思路：改变数组。从头开始扫描数组中的数字，如果该数不等于下标，那么就与该数为下标值的交换，直到与下标相等，如果在交换的过程中发现该位置与这个数相等，就发现了重复的数字。每个数字最多交换两次就可以找到属于自己的位置，所以总的时间复杂度O(n).

### AC代码：

```
class Solution {
public:
    // Parameters:
    //        numbers:     an array of integers
    //        length:      the length of array numbers
    //        duplication: (Output) the duplicated number in the array number
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    bool duplicate(int numbers[], int length, int* duplication) {
        if(length<=0||numbers==nullptr)
            return false;
        for(int i=0;i<length;i++)
            if(numbers[i]<0||numbers[i]>length-1)
                return false;
        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    *duplication=numbers[i];
                    return true;
                }
                swap(numbers[i],numbers[numbers[i]]);
            }
        }
        return false;
    }
};
```

### [不修改数组找出重复的数字(力扣287)](https://github.com/ZCY19990813/ZCY1999/blob/master/%E5%8A%9B%E6%89%A3287%20%E5%AF%BB%E6%89%BE%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0.md)
