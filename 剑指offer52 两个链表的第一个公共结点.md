## 题目来源：[剑指offer52 两个链表的第一个公共结点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

## 题意：输入两个链表，找出它们的第一个公共节点。

### 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 输出：Reference of the node with value = 2 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

### 思路：我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。

### AC代码：

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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA==NULL||headB==NULL)
            return NULL;
        ListNode* node1=headA;
        ListNode* node2=headB;
        while(headA!=headB){
            if(headA==NULL)
                headA=node2;
            else
                headA=headA->next;
            if(headB==NULL)
                headB=node1;
            else
                headB=headB->next;
        }
        return headA;
    }
};
```

### 可以先遍历一遍两个链表的长度，算出差几个（n个），然后在让较长的链表往前移动n次，然后两个链表一起往后走，最终找到相等的结点，就是第一个相等的结点。
