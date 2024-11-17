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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> t = new ArrayList<Integer>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode p = q.poll();

                t.add(p.val);
                if (p.left != null) {
                    q.offer(p.left);
                }

                if (p.right != null) {
                    q.offer(p.right);
                }
            }
            if (ans.size()%2!=0) {
                Collections.reverse(t);
            }
            ans.add(t);
            t = new ArrayList<Integer>();
        }
        
        return ans;
    }
}