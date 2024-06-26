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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        getVal(root);

        return ans;
    }

    public int getVal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, getVal(root.left));
        int right = Math.max(0, getVal(root.right));
        
        ans = Math.max(ans, left+right+root.val);

        return Math.max(left, right)+root.val;
    }
}