/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {
    struct ListNode *slow, *fast;
    int i=0;
    if (head==NULL || head->next == NULL)
    {
        return NULL;
    }
    slow=fast=head;
    while (fast != NULL && fast->next != NULL) {        
        slow=slow->next;
        fast=fast->next->next;
        if (slow==fast) {
            break;            
        }
    }
    if (slow != fast){
        return NULL;
    }
    slow=head;
    while (slow!=fast){
        slow=slow->next;
        fast=fast->next;
        ++i;
    }
    return slow;
}
