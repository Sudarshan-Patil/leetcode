/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addAtEnd(struct ListNode*, int);

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    struct ListNode* head;
    struct ListNode* temp;
    int carry=0;
    int sum=0;
    
    sum = l1->val + l2->val;
    l1=l1->next;
    l2=l2->next;
    temp = (struct ListNode*)malloc(sizeof(struct ListNode));
    if (sum > 9) {
        carry = sum/10;   
        sum = sum%10;        
    } 
    temp->val = sum;
    temp->next = NULL;
    head = temp;
    
    while(l1 != NULL && l2 !=NULL)
    {
        sum = l1->val + l2->val+carry;
        carry=0;
        if (sum > 9) {
            carry = sum/10;        
            sum = sum%10;            
        }      
        temp = addAtEnd(temp, sum);      
        l1=l1->next;
        l2=l2->next;
    }   
    
    while (l1 != NULL) 
    {
        sum = l1->val+carry;
        carry=0;
        if (sum > 9) {
            carry = sum/10;        
            sum = sum%10;            
        }      
        temp = addAtEnd(temp, sum);      
        l1=l1->next;
    }
    
    while (l2 != NULL) 
    {
        sum = l2->val+carry;
        carry=0;
        if (sum > 9) {
            carry = sum/10;        
            sum = sum%10;            
        }      
        temp = addAtEnd(temp, sum);
        l2=l2->next;
    }
    if (carry != 0) {
        temp = addAtEnd(temp, carry);
    }
    return head;
}

struct ListNode* addAtEnd(struct ListNode* head, int sum)
{
    struct ListNode* temp;
    temp = (struct ListNode*)malloc(sizeof(struct ListNode));
    temp->val = sum;
    head->next = temp; 
    head = head->next;
    head->next = NULL;
    return head;
}
