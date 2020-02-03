## 题目来源：[剑指offer23 链表中环的入口结点](https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

### 输入：head = [3,2,0,-4],假设-4指向2那个结点，输出2. 

### 战绩：执行用时 :16 ms, 在所有 C++ 提交中击败了54.89%的用户内存消耗 :9.9 MB, 在所有 C++ 提交中击败了25.51%的用户。

### 注：此题可以用map,把键当成指针，但是浪费空间，具体看“力扣142 环形链表II”。

### 思路：(1)首先需要判断有没有环,(2)需要判断环的结点数，(3)找入口结点
         - 如果走的快的指针追上了走的慢的指针，那么链表就包含环如果走的快的指针走到了末尾还没有追上，那么链表就不包含环
         - 岔开两个指针，只动一个指针，直到相等，其移动次数就是环中结点个数。
         - 先定义p1,p2指向头节点，如果环中有n个节点，先让p1移动n步,然后两个指针以相同的速度向前移动。当第二个指针指向环的入口结点时，第一个指针就绕着环走了一圈又回到入口结点
        
### AC代码：

```
/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(NULL) {
    }
};
*/
class Solution {
public:
    ListNode *EntryNodeOfLoop(ListNode *head) {
        ListNode *fast=head;
        ListNode *slow=head;
        if(head==NULL)
            return NULL;
        int flag=0;
        //如果走的快的指针追上了走的慢的指针，那么链表就包含环
        //如果走的快的指针走到了末尾还没有追上，那么链表就不包含环
        while(fast->next!=NULL&&slow->next!=NULL){
            fast=fast->next;
            if(fast->next!=NULL)
                fast=fast->next;
            else
                break;//没有环
            slow=slow->next;
            if(fast==slow){
                flag=1;
                break;
            }
        }
        if(flag==0)
            return NULL;
        int n=1;
        fast=fast->next;
        while(fast!=slow){
            fast=fast->next;
            n++;
        }
        //先定义p1,p2指向头节点，如果环中有n个节点，先让p1移动n步
        //然后两个指针以相同的速度向前移动。
        //当第二个指针指向环的入口结点时，第一个指针就绕着环走了一圈又回到入口结点
        fast=head;
        slow=head;
        for(int i=0;i<n;i++)
            fast=fast->next;
        while(fast!=slow){
            fast=fast->next;
            slow=slow->next;
        }
        //cout<<fast->val<<endl;
        return fast;
    }
};
```
