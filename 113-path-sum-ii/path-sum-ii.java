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
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path(root, targetSum, new ArrayList<Integer>());

        return ans;
    }

    public void path(TreeNode root, int t, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && t-root.val == 0) {
            res.add(root.val);
            ans.add(new ArrayList<Integer>(res));
            res.remove(res.size()-1);
            return;
        }

        res.add(root.val);
        path(root.left, t-root.val, res);
        path(root.right, t-root.val, res);
        res.remove(res.size()-1);
        
        return;
    }
}