## 题目来源：[剑指offer18 删除链表中重复的结点***](https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题意：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，返回链表头指针。

### 输入：1->2->3->3->4->4->5 输出：1->2->3->4->5

### AC代码1：
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
    ListNode* deleteDuplication(ListNode* head) {
        ListNode* p=head;
        if(head==NULL)
            return NULL;
        while(p->next!=NULL){
            int flag=0;
            while(p->val==p->next->val){
                if(p->next->next!=NULL){
                    p->next=p->next->next;
                }
                else{
                    p->next=NULL;
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                p=p->next;
        }
        return head;
    }
};
```
## 题意2：（对应力扣82）在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

### 输入：1->2->3->3->4->4->5 输出：1->2->5

### 思路：因为删除的结点太复杂，所以可以先将头节点不是重复的作为返回结点的头，之后在进行下一步操作。设置一个指针q=head,p=head->next,q就是总的指针一直往后移动形成的，t=q->next,一直这样往后遍历，注意细节。难度***

### AC代码2：

```
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *p=head;
        //先找到第一个不重复的点
        while(p!=NULL&&p->next!=NULL){
            ListNode *t=p->next;
            int flag=0;
            int v=p->val;
            while(t&&t->val==v){
                flag=1;
                t=t->next;
            }
            if(flag){
                p=t;
            }
            else
                break;
        }
        head=p;//现在头就是不重复的第一个结点
        if(p==NULL||p->next==NULL)
            return p;
        p=head->next;
        ListNode* q=head;
        while(p!=NULL&&p->next!=NULL){
            ListNode* t=p->next;
            int v=p->val;
            if(t->val==v){
                while(t&&t->val==v){
                    t=t->next;
                }
                p=t;
                q->next=p;
            }
            else{
                q=q->next;
                p=p->next;
            }
        }
        return head;
    }
};
```
