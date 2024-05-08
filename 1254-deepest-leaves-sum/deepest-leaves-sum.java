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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(root);
        q.offer(null);
        int t = 0;
        int ans = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                t = ans;
                ans = 0;
                if (q.isEmpty()) {
                    break;
                }
                q.offer(null);
                continue;
            }
            ans += temp.val;
            if (temp.left!=null) {
                q.offer(temp.left);
            }
            if (temp.right!=null) {
                q.offer(temp.right);
            }
        }

        return t;
    }
}