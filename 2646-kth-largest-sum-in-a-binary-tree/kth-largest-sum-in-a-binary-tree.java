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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        q.offer(root);
        q.offer(null);
        long sum = 0;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();

            if (t == null) {
                pq.offer(sum);
                if (pq.size() > k) {
                    pq.poll();
                }
                sum = 0;
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                sum += t.val;

                if (t.left!=null) {
                    q.offer(t.left);
                }

                if (t.right!=null) {
                    q.offer(t.right);
                }
            }
        }

        return pq.size() == k ? pq.peek() : -1;
    }
}