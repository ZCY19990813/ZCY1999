## 题目来源：[力扣 240. 搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

### 战绩：执行用时 :76 ms, 在所有 C++ 提交中击败了60.83%的用户，内存消耗 :12.9 MB, 在所有 C++ 提交中击败了29.96%的用户

## 题意：编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：每行的元素从左到右升序排列。每列的元素从上到下升序排列。


### 输入：matrix=[ [1,   4,  7, 11, 15], [2,   5,  8, 12, 19], [3,   6,  9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]
]给定 target = 5，返回 true。给定 target = 20，返回 false。

### 思路：来源是力扣上面的面试题目4，上面有个很巧妙的算法，因为行列都是排好序的，所以只需要先看右上角与需要比较值的大小，如果右上角的值较大，那么这一列不可能出现想要的数；如果右上角的值较小，那么这一行就可删除掉，每次都看右上角是不是需要的值即可。
### AC代码：
```
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size()==0)
            return false;
        //cout<<"&&"<<endl;
        int n=matrix.size()-1;
        int m=matrix[0].size()-1;
        int p=0,q=m;
        while(p>=0&&q>=0&&p<=n&&q<=m){
            //cout<<p<<" "<<q<<" "<<matrix[p][q]<<endl;
            if(matrix[p][q]==target)
                return true;
            else if(matrix[p][q]>target)
                q--;
            else if(matrix[p][q]<target)
                p++;
        }
        return false;
    }
};
```
