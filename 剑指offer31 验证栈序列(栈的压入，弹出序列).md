## 题目来源：[剑指offer31 验证栈序列(栈的压入，弹出序列)](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

### 输入：pushed = [1,2,3,4,5],popped = [4,5,3,2,1] 输出：true 解释：我们可以按以下顺序执行：push(1), push(2), push(3), push(4), pop() -> 4,push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

### 思路：所有的元素一定是按顺序 push 进去的，重要的是怎么 pop 出来？
  - 假设当前栈顶元素值为 2，同时对应的 popped 序列中下一个要 pop 的值也为 2，那就必须立刻把这个值 pop 出来。因为之后的 push 都会让栈顶元素变成不同于 2 的其他值，这样再 pop 出来的数 popped 序列就不对应了。
  - 将 pushed 队列中的每个数都 push 到栈中，同时检查这个数是不是 popped 序列中下一个要 pop 的值，如果是就把它 pop 出来。
  - 最后，检查不是所有的该 pop 出来的值都是 pop 出来了。

### AC代码：
```
class Solution {
public:
    bool IsPopOrder(vector<int>& pushed, vector<int>& popped) {
        int n=popped.size();
        int p2=0;
        stack<int> s;
        for(int i=0;i<n;i++){
            s.push(pushed[i]);
            while(!s.empty()&&p2<n&&s.top()==popped[p2]){
                s.pop();
                p2++;
            }
        }
        return p2==n;
        
    }
};
```

