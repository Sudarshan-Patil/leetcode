/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


int getDecimalValue(struct ListNode* head){
    struct ListNode* temp = head;
    int i=0;
    int dec = 0;
    while (temp!= NULL) {
       i++;
       temp = temp->next;
    }    
    
    temp = head;
    for(int k=i-1;k>=0;k--) {
        dec = dec + temp->val*(1<<k);        
        temp = temp->next;
    }
    return dec;
}
