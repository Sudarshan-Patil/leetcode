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
    long ans = 0;
    static final int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        long total = getAllSum(root);
        getSum(root, total);

        return (int)(ans%mod);
    }

    public long getSum(TreeNode root, long total) {
        if (root == null) {
            return 0;
        }

        long temp = getSum(root.left, total) + getSum(root.right, total) + root.val;

        ans = Math.max(ans, (total-temp)*temp);
        
        return temp;
    }

    public long getAllSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long left = getAllSum(root.left);
        long right = getAllSum(root.right);

        return root.val + left + right;
    }
}