/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.flatten(root);
    }
    
    public int next() {
        int temp = this.root.val;
        this.root = this.root.right;
        return temp;
    }
    
    public boolean hasNext() {
        return this.root != null;
    }

    public void flatten(TreeNode root) {
        this.root = this.flattenList(root);
       
       return;
    }

    public TreeNode flattenList(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode head = null;
        TreeNode tail = null;
        while (!st.isEmpty() || root!=null) {
            if (root!=null) {
                st.push(root);
                root = root.left;
            } else {
                TreeNode temp = st.pop();
                if (head == null) {
                    head = temp;
                }

                if (tail == null) {
                    tail = temp;
                } else {
                    tail.right = temp;
                    tail = tail.right;
                }
                root = temp.right;
            }
        }

        return head;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */