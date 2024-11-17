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
    public List<Double> averageOfLevels(TreeNode root) {
        double avg=0;
        List<Double> ans = new ArrayList<Double>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            avg = 0;
            for (int i=0; i<size; i++) {
                TreeNode p = q.poll();
                avg += p.val;
                if (p.left != null) {
                    q.offer(p.left);
                }

                if (p.right != null) {
                    q.offer(p.right);
                }
            }

            double average = avg/size;
            ans.add(average);
        }
        
        return ans;
    }
}