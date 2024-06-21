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
    public int pathSum(TreeNode root, int targetSum) {
        long t = (long)targetSum;
        getCount(root, t);
        path(root, t);

        return ans;
    }

    public void path(TreeNode root, long t) {
        if (root == null) {
            return;
        }

        getCount(root.left, t);
        path(root.left, t);
        getCount(root.right, t);
        path(root.right, t);
        return;
    }

    public void getCount(TreeNode root, long t) {
        if (root == null) {
            return;
        }

        if (t-root.val == 0) {
            ans++;
        }

        getCount(root.left, t-root.val);
        getCount(root.right, t-root.val);

        return;
    }
}