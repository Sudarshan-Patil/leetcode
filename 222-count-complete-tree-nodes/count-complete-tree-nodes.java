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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getLeftHeight(root.left);
        int right = getRightHeight(root.right);
        // System.out.println(left+ " : " + right);
        if (left == right) {
            return ((2<<left)-1);
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root!=null) {
            count++;
            root = root.left;
        }

        return count;
    }

    public int getRightHeight(TreeNode root) {
        int count = 0;
        while (root!=null) {
            count++;
            root = root.right;
        }

        return count;
    }
}