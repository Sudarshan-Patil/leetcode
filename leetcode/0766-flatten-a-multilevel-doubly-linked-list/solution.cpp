/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    Node* flatten(Node* head) {
        if (head==NULL)
            return head;
        
        Node* newNode = NULL;        
        Node* tempNode = NULL;        
        Node* temp = NULL;
        
        if (head->child!=NULL)
            newNode = flatten(head->child);
            head->child = NULL;
            
        temp=head->next;
        if (newNode != NULL) {
            head->next = newNode;
            newNode->prev = head;
            newNode->child = NULL;
            while (newNode->next != NULL) {
                newNode = newNode->next;
            }
        }                    
        
        tempNode = flatten(temp);
        if (tempNode != NULL) {
            if (newNode != NULL) {
                newNode->next = tempNode;
                tempNode->prev = newNode;  
                tempNode->child = NULL;
            } else {
                head->next = tempNode;
                tempNode->prev = head; 
                tempNode->child = NULL;
            }                   
        }      
        return head;
    }         
};
