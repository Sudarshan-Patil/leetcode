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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode t = new TreeNode(val);
            t.left = root;

            return t;
        }

        addRow(root, val, depth-1);

        return root;
    }

    public void addRow(TreeNode root, int val, int depth) {
        if (root == null || depth == 0) {
            return;
        }

        if (depth == 1) {
            TreeNode t1 = new TreeNode(val);
            t1.left = root.left;
            root.left = t1;
            TreeNode t2 = new TreeNode(val);
            t2.right = root.right;
            root.right = t2;
            return;
        }

        addRow(root.left, val, depth-1);
        addRow(root.right, val, depth-1);

        return;
    }
}