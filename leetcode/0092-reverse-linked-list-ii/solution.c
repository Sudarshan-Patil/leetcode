/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* reverseBetween(struct ListNode* head, int m, int n){
    if (head == NULL || head->next == NULL)
        return head;
    if (m==n || n==1)
        return head;
    
    struct ListNode* temp=head, *next, *prev, *newNode;
    prev=head;
    if (m == 1) {        
        prev=NULL;
        for (int i=0; i<n;i++) {
            next = temp->next;
            temp->next=prev;
            prev=temp;
            temp=next;
        }  
    } else {
        temp=head->next;
    }
    
    newNode = reverseBetween(temp, m-1, n-1);
    head->next = newNode;
    return prev;
}
