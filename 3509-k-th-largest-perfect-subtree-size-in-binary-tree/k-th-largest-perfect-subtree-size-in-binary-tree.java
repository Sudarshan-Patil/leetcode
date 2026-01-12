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
    ArrayList<Integer> arr = new ArrayList<>();
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        isPerfect(root);

        Collections.sort(arr);
        int n = arr.size();
        if (k>n) {
            return -1;
        }

        n = n-k;

        return arr.get(n);
    }

    public int isPerfect(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isPerfect(root.left);
        int right = isPerfect(root.right);

        if (left == -1 || right == -1 || left != right) {
            return -1;
        } else {
            int t = 1 + left + right;
            arr.add(t);
            return t;
        }
    }
}