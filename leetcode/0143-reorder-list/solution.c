/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode *reverseList(struct ListNode*);

void reorderList(struct ListNode* head){
    struct ListNode* first, *second, *temp, *curr;    
    if (head == NULL || head->next == NULL)
        return head;
        
    first=second=head;
    while (first!=NULL && first->next!=NULL) 
    {
        second=second->next;
        first=first->next->next;
    }    
    if (first != NULL) {
        second=second->next;
    }
    first=head;
    while (first->next!=second) {
        first=first->next;
    }    
    first->next = NULL;
    first=head;
    second = reverseList(second);
    temp=second;
    while (temp!=NULL)
    {
        temp=temp->next;
        curr=first->next;
        second->next = first->next;
        first->next = second;
        second = temp;
        first=curr;
    }    
}

struct ListNode *reverseList(struct ListNode* head)
{
    struct ListNode* curr=head, *prev, *next;
    next=head;
    prev=NULL;
    while (next != NULL) {
        next =next->next;
        curr->next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
}
