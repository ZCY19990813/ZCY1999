## 题目来源：[剑指offer35 复杂链表的复制(力扣138)](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

## 题意：给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。要求返回这个链表的 深拷贝。 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val,random_index] 表示：val：一个表示 Node.val 的整数。random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为null 。

### 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

### 思路1：第一步：把链表的每个节点复制并将它放在原节点后面，只复制next指针；第二步：如果要找到cur的复制节点的random指针，可以通过cur->random->next找到；第三步：将原节点和新的节点分类开即可.

### AC代码1：

```
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/
class Solution {
public:
    void CloneNodes(Node* head){
        Node* p=head;
        while(p!=NULL){
            Node* t=new Node(p->val);
            t->next=p->next;
            p->next=t;
            p=t->next;
        }
    }
    void ConnectSiblingNodes(Node* head){
        Node* p=head;
        while(p!=NULL){
            Node* t=p->next;
            if(p->random!=NULL)
                t->random=p->random->next;
            p=t->next;
        }
    }
    Node* ReocnnectNodes(Node* head){
        Node* p=head;
        Node* ans=NULL;
        Node* q=NULL;
        if(p!=NULL){
            q=p->next;
            p->next=q->next;
            p=p->next;
        }
        ans=q;
        while(p!=NULL){
            q->next=p->next;
            q=q->next;
            p->next=q->next;
            p=p->next;
        }
        return ans;
    }
    Node* copyRandomList(Node* head) {
        CloneNodes(head);//第一步把N'复制在N后面，不包括random
        ConnectSiblingNodes(head);//第二步，把random复制上
        return ReocnnectNodes(head);//把偶数择出来
    }
};
```

### 思路2：用map存储一下，先复制正常的链表，在来一遍复制其他的。

### AC代码2：

```
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==NULL)
            return NULL;
        Node* newHead=new Node(head->val);
        Node *p=newHead,*q=head->next;
        map<Node*,Node*> oldTonew;
        oldTonew[head]=newHead;
        while(q!=NULL){
            Node *tmp=new Node(q->val);
            p->next=tmp;
            p=tmp;
            oldTonew[q]=tmp;
            q=q->next;
        }
        p=newHead;
        q=head;
        while(q!=NULL){
            p->random=oldTonew[q->random];
            p=p->next;
            q=q->next;
        }
        return newHead;
    }
};
```
