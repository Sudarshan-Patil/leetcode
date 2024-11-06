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
    int idx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        idx = postorder.length-1;

        return getTree(0, postorder.length-1, postorder, hm);
    }

    public TreeNode getTree(int s, int e, int[] postorder, HashMap<Integer, Integer> hm) {
        if (s>e) {
            return null;
        }

        TreeNode head = new TreeNode(postorder[idx--]);
        int index = hm.get(head.val);

        head.right = getTree(index+1, e, postorder, hm);
        head.left = getTree(s, index-1, postorder, hm);

        return head;
    }
}