## 题目来源：[剑指offer25 合并两个有序链表](https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

### 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4

### 思路：就是不断插入的过程。

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
    ListNode* Merge(ListNode* l1, ListNode* l2) {
        ListNode *t,*ans;
        t=new ListNode(0);
        ans=new ListNode(0);
        ans=t;
        while(l1!=NULL&&l2!=NULL){
            if(l1->val<=l2->val){
                ListNode *p=new ListNode(0);
                p->val=l1->val;
                t->next=p;
                l1=l1->next;
                t=t->next;
            }
            else{
                ListNode *p=new ListNode(0);
                p->val=l2->val;
                t->next=p;
                l2=l2->next;
                t=t->next;
            }
        }
        if(l1!=NULL)
            t->next=l1;
        if(l2!=NULL)
            t->next=l2;
        ans=ans->next;
        return ans;
    }
};
```
