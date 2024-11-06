/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root==null) { return root; }
        Node ans = root;
        while (root.left!=null) {
            Node temp = root;
            while (root!=null) {
                root.left.next = root.right;
                if (root.next!=null) {
                    root.right.next = root.next.left;
                }
                root = root.next;
            }
            root = temp.left;
        }
            
        return ans;
    }
}