/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool checkInArray(int, int*, int);

int numComponents(struct ListNode* head, int* G, int GSize){
    struct ListNode* temp = head;
    int count = 0;
    int a;
    while(temp != NULL)
    {
        a=0;
        while (temp !=NULL && checkInArray(temp->val, G, GSize)) { 
            ++a;
            temp=temp->next;            
        }
        if (a>0) {
            count++;   
        }
        if (temp == NULL) {
            break;    
        }
        temp=temp->next;
    }
    return count;
}

bool checkInArray(int a, int* G, int GSize)
{
    for (int i=0; i<GSize; i++) 
    {
        if (a == G[i])
        {
            return 1;
        }
    }
    return 0;
}
