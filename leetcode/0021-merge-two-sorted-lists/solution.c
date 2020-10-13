/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    struct ListNode* final = NULL;
    struct ListNode* head;

    final = (struct ListNode*)malloc(sizeof(struct ListNode));

    if (l1 == NULL) {
        final = l2;
        return final;
    }
    if (l2 == NULL) {
        final = l1;
        return final;
    }    

    if (l1->val <= l2->val) {
        head = l1;
    } else {
        head = l2;
    }

    while (l1 != NULL && l2 != NULL) {
        if (l1->val <= l2->val) {             
            final->next = l1;
            l1 = l1->next;
            final = final->next;
        } else {            
            final->next = l2;
            l2 = l2->next;
            final = final->next;
        }       
    }
    
    if (l1 != NULL) {
        final->next = l1;
    }
    
    if (l2 != NULL) {
        final->next = l2;
    }
    return head;
}
