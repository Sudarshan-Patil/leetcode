/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* reverseList(struct ListNode* head){
    struct ListNode* curr;
    struct ListNode* prev;
    curr = head;
    prev = NULL;
    while (curr != NULL) {
        head = head->next;
        curr->next = prev;
        prev = curr;
        curr = head;
    }
    return prev;
}
