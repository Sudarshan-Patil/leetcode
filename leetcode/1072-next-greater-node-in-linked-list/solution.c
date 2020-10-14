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
int* nextLargerNodes(struct ListNode* head, int* returnSize){    
    struct ListNode* temp=head;
    int max=0,comp;
    int n=0;
    while (temp != NULL) {
        ++n;
        temp = temp->next;
    }
    int *arr = (int*) malloc(sizeof(int) * n);
    
    *returnSize = n;
    
    for (int i=0; i<n; i++) 
    {
        temp = head;
        head = head->next;          
        comp = temp->val;
        while (temp!=NULL && temp->next != NULL) {            
            if (comp < temp->next->val) {
                max = temp->next->val;
                comp = max;
                break;
            }            
            temp = temp->next;
        }
        arr[i] = max;
        max = 0;
    }
    return arr;
}
