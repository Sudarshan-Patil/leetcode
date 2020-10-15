/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* rotateRight(struct ListNode* head, int k){
    struct ListNode* temp=head, *curr;
    int size=0;            
    if (head==NULL || head->next == NULL)
    {
        return head;
    }
    while (temp!= NULL)
    {
        ++size;
        temp = temp->next;
    }
    temp = head;
    
    k = k%size;
        
    for (int i=0; i<k; i++) {
        while (temp!= NULL && temp->next != NULL)
        {            
            curr = temp;
            temp = temp->next;            
        }
        temp->next = head;
        head = temp;
        curr->next = NULL;
    }
    return temp;
}


