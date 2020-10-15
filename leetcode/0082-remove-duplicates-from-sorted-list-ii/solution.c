/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* deleteDuplicates(struct ListNode* head){
    struct ListNode* temp;
    struct ListNode* prev, *del;
    
    bool flag = false;  
    
    while (head!=NULL && head->next != NULL && head->val == head->next->val)
    {        
        while (head!= NULL && head->next!=NULL && head->val == head->next->val) {
            flag = true;
            temp = head;
            head= head->next;
            free(temp);
        }
        if (flag) {
            temp = head;
            head= head->next;
            free(temp);
            flag=false;
        } else {
            prev = temp;
            temp = temp->next;   
        }        
    }    
    
    while (head!= NULL && head->next!=NULL && head->val == head->next->val)
    {
        flag = true;
        temp = head;
        head= head->next;
        free(temp);
    }
    if (flag)
    {
        temp = head;
        head= head->next;
        free(temp);
        flag=false;
    }
    
    if (head == NULL || head->next == NULL)
        return head;
    
    temp = head;
    prev=temp;            
    temp=temp->next;
    while (temp!=NULL && temp->next != NULL)
    {        
        while (temp!=NULL && temp->next != NULL && temp->val == temp->next->val) {
            flag = true;
            del = temp;            
            prev->next = temp->next;            
            temp = temp->next;
            free(del);
        }
        if (flag) {
            del = temp;            
            prev->next = temp->next;            
            temp = temp->next;   
            flag=false;
        } else {
            prev = temp;
            temp = temp->next;   
        }        
    }    
    return head;
}
