## 题目来源：[剑指offer9 用两个栈实现队列](https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

### 思路：放入的时候直接放入栈1即可，出的时候看栈2有没有，如果有直接从栈2出即可；如果栈2没有，需要从栈1搬到栈2，再从栈2出。

### AC代码：

```
class Solution
{
public:
    void push(int node) {
        stack1.push(node);
    }

    int pop() {
        if(stack2.size()==0){
            while(stack1.size()>0){
                int data=stack1.top();
                stack1.pop();
                stack2.push(data);
            }
        }
        if(stack2.size()==0)//此时不能出
            return 0;
        int data=stack2.top();
        stack2.pop();
        return data;
    }

private:
    stack<int> stack1;
    stack<int> stack2;
};
```
