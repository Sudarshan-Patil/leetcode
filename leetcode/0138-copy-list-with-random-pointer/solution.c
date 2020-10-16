/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *next;
 *     struct Node *random;
 * };
 */

struct Node* copyRandomList(struct Node* head) {
	struct Node* next=head, *temp, *newNode, *curr, *head1;
    if (head==NULL) {
        return head;
    }
    curr=head1=NULL;
    while (next!=NULL) {
        temp=next;
        next = next->next;
        
        newNode=malloc(sizeof(struct Node));
        newNode->next=NULL;
        if (curr!=NULL)
            curr->next = newNode;
        if (head1== NULL)
            head1=newNode;
        
        curr = newNode;
        newNode->val = temp->val;
        temp->next=newNode;
        newNode->random = temp;
    }
    temp=head1;
    while (temp!=NULL)
    {
        if (temp->random->random != NULL)
            temp->random = temp->random->random->next;
        else 
            temp->random=NULL;
        temp = temp->next;
    }
    return head1;
}
