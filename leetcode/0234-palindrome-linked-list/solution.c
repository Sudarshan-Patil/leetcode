/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


bool isPalindrome(struct ListNode* head){
    struct ListNode *p1, *p2, *next, *curr;
    struct ListNode *prev = NULL;
    
    p1=p2=head;
    
    while (p1 != NULL && p1->next != NULL) {
        p2 = p2->next;
        p1 = p1->next->next;
    }
    
    p1 = head;
    curr = p2;
    while (curr != NULL) {        
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    
    p2 = prev;
    while (p1 != NULL && p2 != NULL) {
        if (p1->val != p2->val) {
            return 0;
        }
        p1 = p1->next;
        p2 = p2->next;
    }
    return 1;
}
