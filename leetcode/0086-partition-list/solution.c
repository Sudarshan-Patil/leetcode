/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* partition(struct ListNode* head, int x){
    struct ListNode* temp=head, *prev, *curr, *next;    
    curr=NULL;
    if (head == NULL || head->next == NULL) {
        return head;
    }
    
    if (head->val >= x) {
        curr=head;
        prev=NULL;
    }    
    temp=head;

    while (temp!=NULL && temp->next != NULL) {
        if (temp->val > x && curr == NULL) {
            curr=temp;
        }
        if (temp->next->val >= x && curr == NULL) {
            curr = temp->next;
            prev = temp;                        
        }
        if (temp->next->val < x && temp->val >= x)
        {               
            next = temp->next;
            temp->next = next->next;
            next->next = curr;
            if (prev != NULL)
                prev->next = next;
            else
                head=next;
            prev = next;
        } else {
            temp=temp->next;            
        }      
    }
    
    return head;
}
