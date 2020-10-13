/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    struct ListNode* temp1 = headA;
    struct ListNode* temp2 = headB;
    
    int i=0;
    int j=0;

    while (temp1!=NULL) {
        ++i;
        temp1 = temp1->next;
    }
    
    while (temp2!=NULL) {
        ++j;
        temp2 = temp2->next;
    }
        
    temp1 = headA;
    if (i>j) {        
        for(int k=0; k<(i-j); k++) {
            temp1 = temp1->next;     
        }
    }
    
    temp2 = headB;
    if (i<j) {        
        for(int k=0; k<(j-i); k++) {            
            temp2 = temp2->next;    
        }
    }    
    
    while (temp1!=NULL && temp2!=NULL) {
        if (temp1 == temp2) {
            return temp1;
        }
        temp1 = temp1->next;
        temp2 = temp2->next;
    }
    return NULL;
}
