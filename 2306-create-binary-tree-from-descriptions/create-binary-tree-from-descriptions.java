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
    public TreeNode createBinaryTree(int[][] d) {
        HashSet<TreeNode> hchild = new HashSet();
        HashSet<TreeNode> hparent = new HashSet();
        HashMap<Integer, TreeNode> hm = new HashMap<>();

        for (int i=0; i<d.length; i++) {
            int parent = d[i][0];
            int child = d[i][1];
            int dir = d[i][2];
            TreeNode n, nc;
            if (hm.containsKey(parent)) {
                 n = hm.get(parent);
            } else {
                 n = new TreeNode(parent);
                hm.put(parent, n);
            }

            if (hm.containsKey(child)) {
                 nc = hm.get(child);
            } else {
                 nc = new TreeNode(child);
                hm.put(child, nc);
            }

            if (dir == 1) {
                n.left = nc;
            } else {
                n.right = nc;
            }

            hchild.add(nc);
            if (!hchild.contains(n)) {
                hparent.add(n);
            }

            if (hparent.contains(nc)) {
                hparent.remove(nc);
            }
        }

        return hparent.iterator().next();
    }
}