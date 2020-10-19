/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* add(struct ListNode*, struct ListNode*, int, int);

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    struct ListNode* temp1 = l1, *newNode;
    struct ListNode* temp2 = l2;
    int countl1=0;
    int countl2=0;
    while (temp1 != NULL) {
        ++countl1;
        temp1=temp1->next;
    }
    
    while (temp2 != NULL) {
        ++countl2;
        temp2=temp2->next;
    }
    if (l1==NULL) {
        return l2;
    }
    if (l2==NULL) {
        return l1;
    }
    temp1 = add(l1,l2,countl1, countl2);
    if (temp1->val >= 10) {
        newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
        newNode->val = temp1->val%10;
        temp1->val = temp1->val/10;
        newNode->next = temp1->next;
        temp1->next = newNode;
    }
    return temp1;
}

struct ListNode* add(struct ListNode* l1,struct ListNode* l2,int countl1, int countl2)
{
    struct ListNode* newNode,*sum;
    int t1,t2;
    t1 = countl1;
    t2 = countl2;
    newNode = (struct ListNode*)malloc(sizeof(struct ListNode));    
    if (l1 == NULL && l2 == NULL)
        return NULL;
        
    if (countl2 == countl1) {
        sum = add(l1->next,l2->next, --countl1, --countl2);
    }    
    if (countl1 > countl2) {
        sum = add(l1->next,l2,--countl1, countl2);
    }
    if (countl2 > countl1) {
        sum = add(l1,l2->next,countl1, --countl2);
    }

    if (sum == NULL) {        
        newNode->val = l1->val + l2->val;
        newNode->next = sum;
    } else if (t1 == t2) {
        newNode->val = l1->val + l2->val + (sum->val/10);
        sum->val = sum->val%10;         
        newNode->next = sum;
    } else if (t1 > t2) {
        newNode->val = l1->val + (sum->val/10);
        sum->val = sum->val%10;        
        newNode->next = sum;
    } else {
        newNode->val = l2->val + (sum->val/10);
        sum->val = sum->val%10;        
        newNode->next = sum;
    }
    return newNode;
}

