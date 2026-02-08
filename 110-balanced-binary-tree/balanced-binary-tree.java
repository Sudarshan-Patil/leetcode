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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root) == 0 ? false : true;
    }

    public int check(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int left = check(root.left);
        int right = check(root.right);

        if (left == 0 || right == 0 || Math.abs(left-right) > 1) {
            return 0;
        } else {
            return Math.max(left, right) + 1;
        }
    }


}