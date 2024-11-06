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
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {
                if (q.isEmpty() || (q.size() == 1 && q.peek() == null)) {
                    return root;
                }
                q.offer(null);
            } else {
                temp.next = q.peek();

                if (temp.left!=null) {
                    q.offer(temp.left);
                }

                if (temp.right!=null) {
                    q.offer(temp.right);
                }
            }
        }

        return root;
    }
}