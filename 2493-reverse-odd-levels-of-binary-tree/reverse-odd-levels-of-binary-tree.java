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
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> d = new LinkedList<>();
        d.offerLast(root);
        int step = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                TreeNode temp = d.pollFirst();

                if (temp.left != null) {
                    d.offerLast(temp.left);
                }

                if (temp.right != null) {
                    d.offerLast(temp.right);
                }
            }
            ++step;
            if (step%2 != 0) {
                d = reverse(d);
            }
        }

        return root;
    }

    public Deque<TreeNode> reverse(Deque<TreeNode> d) {
        Deque<TreeNode> front  = new LinkedList<TreeNode>();
        Deque<TreeNode> tail  = new LinkedList<TreeNode>();

        while (!d.isEmpty()) {
            TreeNode f = d.pollFirst();
            TreeNode t = d.pollLast();

            int temp = f.val;
            f.val = t.val;
            t.val = temp;

            front.offerLast(f);
            tail.offerFirst(t);
        }
        
        while (!tail.isEmpty()) {
            front.offerLast(tail.pollFirst());
        }

        return front;
    }
}