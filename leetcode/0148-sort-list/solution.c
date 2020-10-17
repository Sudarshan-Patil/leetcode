/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* sortList(struct ListNode* head){
    struct ListNode* newHead, *prev=NULL, *curr=head;
    if (head == NULL || head->next == NULL)
        return head;
    newHead = sortList(head->next);        
    head->next = newHead;

    if (head->val > newHead->val) {
        head = newHead;
    }
    while (newHead!=NULL && curr->val > newHead->val) {  
        if (newHead->val < curr->val) {
            curr->next = newHead->next;
            newHead->next = curr;
            if (prev!=NULL)
                prev->next = newHead;
            prev = newHead;                        
            newHead= curr->next;
        } else {
            prev = curr;
            curr = newHead;            
            newHead = newHead->next;
        }        
    }
    return head;
}
