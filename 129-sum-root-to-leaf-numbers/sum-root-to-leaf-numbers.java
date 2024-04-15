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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        getSum(root, "");

        return ans;
    }

    public void getSum(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            s += root.val;
            ans += Integer.parseInt(s);
            return;
        }

        getSum(root.left, s+root.val);
        getSum(root.right, s+root.val);

        return;
    } 
}