/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* insertionSortList(struct ListNode* head){
        struct ListNode* temp, *curr, *prev, *prevt;
    if (head==NULL || head->next == NULL)
        return head;
    
    prev = NULL;
    
    if (head->val > head->next->val) {
        prev = head;
        head=head->next;
        prev->next = head->next;
        head->next = prev;
    }    
    temp=head;
    prevt=head;
    
    while (temp!=NULL && prevt->next != NULL) {
        curr=head;
        prev=NULL;
        prevt=temp;
        temp=temp->next;                
        while (curr!=temp && temp!=NULL && curr!= NULL) {            
            if (curr->val > temp->val) {
                prevt->next = temp->next;
                if (prev != NULL)
                    prev->next = temp;
                temp->next = curr;
                if (curr == head)
                    head = temp;
                temp = prevt;                
                break;                
            } else {
                prev = curr;
                curr = curr->next;
            }             
        }
    }
    return  head;
}
