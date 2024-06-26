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
    ArrayList<Integer> ls = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        getNodes(root);

        return getTree(0, ls.size()-1);
    }

    public void getNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        getNodes(root.left);
        ls.add(root.val);
        getNodes(root.right);

        return;
    }

    public TreeNode getTree(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(ls.get(mid));
        root.left = getTree(start, mid-1);
        root.right = getTree(mid+1, end);

        return root;
    }
}