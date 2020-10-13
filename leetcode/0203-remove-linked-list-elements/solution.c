/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* removeElements(struct ListNode* head, int val){
    struct ListNode* curr = head;
    struct ListNode* temp;
    struct ListNode* prev = NULL;
    
    while(1){
        if (head != NULL && head->val == val) {
            curr = head;
            head = head->next;
            free(curr);
        } else {
            curr = head;
            break;
        }        
    }
    
    while (curr != NULL) {        
        if (curr->val == val) {
            temp = curr;
            prev->next = curr->next;
            curr = curr->next;
            free(temp);
        } else {
            prev = curr;
            curr = curr->next;
        }            
    }
    return head;
}
