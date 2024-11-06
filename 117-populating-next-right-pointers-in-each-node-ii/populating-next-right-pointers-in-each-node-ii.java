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
        if (root == null) {
            return null;
        }

        root.next = null;

        Node ans = root;

        Node preserved = new Node(-1);
        Node prev = preserved;

        while (root!=null) {
            if (root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }

            if (root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }

            root = root.next;
            if (root==null) {
                root = preserved.next;
                prev = preserved;
                prev.next = null;
            }
        }

        return ans;
    }
}