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
        Node newHead = null;
        Node tail = null;
        Node root = head;
        HashMap<Node, Node> hm = new HashMap<>();

        while (root!=null) {
            Node newNode = new Node(root.val);

            hm.put(root, newNode);
            if (newHead == null) {
                newHead = newNode;
            }

            if (tail == null) {
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }

            root = root.next;
        }

        root = head;
        tail = newHead;

        while (root!=null) {
            if (root.random != null) {
                tail.random = hm.get(root.random);
            }
            root = root.next;
            tail = tail.next;
        }

        return newHead;
    }
}