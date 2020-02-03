## 题目来源：[剑指offer22 链表中倒数第k个结点](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题意：输入一个链表，输出该链表中倒数第k个结点。

### 输入: 4->2->1->3  k=3 输出: 2->1->3

### 注意：避免代码的鲁莽性，需要考虑几个边界条件：(1)输入的为空指针 (2)k的值超过链表的长度或者小于等于0

### AC代码：

```
/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution {
public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
        int p=k-1;
        ListNode *fast=pListHead;
        //ListNode *slow=NULL;
        if(pListHead==NULL||k<=0)
            return NULL;
        while(pListHead->next!=NULL&&p>0){
            pListHead=pListHead->next;
            p--;
        }
        if(p>0)
            return NULL;
        while(pListHead->next!=NULL){
            pListHead=pListHead->next;
            fast=fast->next;
        }
        return fast;
    }
};
```
