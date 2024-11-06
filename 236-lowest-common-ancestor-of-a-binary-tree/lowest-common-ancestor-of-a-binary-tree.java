/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; } 
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (search(root.left, p) && search(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (search(root.right, p) && search(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public boolean search(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        if (search(root.left, p) || search(root.right, p)) {
            return true;
        }

        return false;
    }
}