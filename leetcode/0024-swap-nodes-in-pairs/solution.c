/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool checkNodes(struct ListNode*, int);
struct ListNode* getNextNode(struct ListNode*, int);

struct ListNode* swapPairs(struct ListNode* head){
    struct ListNode* curr = head, *prev, *next, *temp, *newNode;
    prev = NULL;

    if (head == NULL || head->next == NULL || !checkNodes(head, 2))
        return head;
    
    temp = getNextNode(head, 2);
    prev = temp;

    for (int i=0; i<2;i++)
    {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    newNode = swapPairs(temp);    
    head->next = newNode;
    
    return prev;
}

struct ListNode* getNextNode(struct ListNode* head, int k)
{
    for (int i=0; i<k; i++)
    {        
        head = head->next;        
    }
    return head;
}

bool checkNodes(struct ListNode* head, int k)
{
    int i =0;
    for (i=0; i<k-1;i++)
    {
        if (head == NULL)
            break;
        head = head->next;        
    }    
    if (i==(k-1))
        return 1;
    return 0;
}
