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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        while (root!=null) {
            int left = getHeight(root.left);
            int right = getHeight(root.right); 

            if (left == right) {
                return root;
            } else {
                if (left > right) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }

        return null;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
}