/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node root = head;
        Node ans = new Node(-1);
        Node res = ans;
        while (head!=null) {
            Node current = new Node(head.val);
            ans.next = current;
            ans = current;
            hm.put(head, current);
            head = head.next;
        }
       
        head = root;

        while (head!=null) {
            Node temp = hm.get(head);
            if (head.random == null) {
                temp.random = null;
            } else {
                temp.random = hm.get(head.random);
            }
            head = head.next;
        }

        return res.next;
    }
}