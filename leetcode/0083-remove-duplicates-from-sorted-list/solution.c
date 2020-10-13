/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* deleteDuplicates(struct ListNode* head){
    struct ListNode* curr = head;
    struct ListNode* temp;
    while (curr != NULL && curr->next != NULL)
    {
        if (curr->val == curr->next->val)
        {
            temp = curr->next;
            curr->next = curr->next->next;
            free(temp);
        } else {
            curr = curr->next;
        }               
    }
    return head;
}
