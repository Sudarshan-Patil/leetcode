/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
struct ListNode** splitListToParts(struct ListNode* root, int k, int* returnSize){
    struct ListNode** final = (struct ListNode**)calloc(k, sizeof(struct ListNode));
    struct ListNode* head=root, *temp;    
    int count=0;
    while (head!=NULL) {
        head=head->next;
        ++count;
    }
    int split=count/k;            
    int j = count%k;
    
    if (split==0) {
        j=0;
    }
    
    int index = 0, i=0;
    head = root;        
    while (head!=NULL) {
        i = split;        
        final[index] = head;       
        while (i-1>0 && head) {
            head=head->next;
            --i; 
        }
        if (!head)
            break;
        
        if (j>0) {
            head = head->next;
            --j;
        }
        if (head) {
            temp=head->next;
            head->next=NULL;
            head=temp;
            index++;   
        }        
    }
    
    while (index<k) {
        final[index] = NULL;
        ++index;
    }
    
    *returnSize = k;
    return final;    
}