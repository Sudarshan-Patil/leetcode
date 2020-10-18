/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* oddEvenList(struct ListNode* head){
    if (head == NULL || head->next == NULL)
        return head;
    
    struct ListNode* curr=head, *prev, *next;    
    prev = head->next;
    next = head->next->next;
    while (next != NULL && prev != NULL) {                
        prev->next = next->next;
        next->next = curr->next;
        curr->next = next;
        curr=curr->next;
        prev = prev->next;
        if (prev != NULL)
            next = prev->next;
    }
    return head;
}
