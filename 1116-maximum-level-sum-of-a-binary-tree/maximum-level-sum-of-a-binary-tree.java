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
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        getSum(root, 1);
        int index = -1;
        int ans = Integer.MIN_VALUE;
        for (int key:hm.keySet()) {
            if (ans < hm.get(key)) {
                ans = hm.get(key);
                index = key;
            }
        }

        return index;
    }

    public void getSum(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (!hm.containsKey(level)) {
            hm.put(level, root.val);
        } else {
            hm.put(level, hm.get(level) + root.val);
        }

        getSum(root.left, level+1);
        getSum(root.right, level+1);

        return;
    }
}