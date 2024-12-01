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
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ans.add(root.val);
        getLeft(root.left);
        getLeaf(root.left);
        getLeaf(root.right);
        getRight(root.right);

        return ans;
    }

    public void getLeft(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        ans.add(root.val);

        if (root.left == null) {
            getLeft(root.right);
        } else {
            getLeft(root.left);
        }

        return;
    }

    public void getLeaf(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }

        getLeaf(root.left);
        getLeaf(root.right);

        return;
    }

    public void getRight(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right == null) {
            getRight(root.left);
        } else {
            getRight(root.right);
        }

        ans.add(root.val);

        return;
    }


}