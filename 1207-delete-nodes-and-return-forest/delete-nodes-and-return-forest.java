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
    List<TreeNode> ans = new ArrayList<TreeNode>();
    HashSet<Integer> hs = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i=0; i<to_delete.length; i++) {
            hs.add(to_delete[i]);
        }

        remove(root, true, null, true);

        return ans;
    }

    public void remove(TreeNode root, boolean pr, TreeNode parent, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (pr && !hs.contains(root.val)) {
            ans.add(root);
        }

        if (hs.contains(root.val)) {
            if (parent!=null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            remove(root.left, true, null, isLeft);
            remove(root.right, true, null, isLeft);
        } else {
            remove(root.left, false, root, true);
            remove(root.right, false, root, false);
        }

        return;
    }
}