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
 class Pair{
    int row;
    int val;
    Pair(int row, int val) {
        this.row = row;
        this.val = val;
    }
 }
class Solution {
    TreeMap<Integer, ArrayList<Pair>> hm = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(root, 0, 0);

        for (int key:hm.keySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            Collections.sort(hm.get(key), new Comparator<Pair>(){
                public int compare(Pair p1, Pair p2) {
                    if (p1.row == p2.row) {
                        return p1.val-p2.val;
                    }
                    return p1.row-p2.row;
                }
            });
            for (int i=0; i<hm.get(key).size(); i++) {
                temp.add(hm.get(key).get(i).val);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }

    public void travel(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }

        if (!hm.containsKey(col)) {
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(row, root.val));
            hm.put(col, arr);
        } else {
            hm.get(col).add(new Pair(row, root.val));
        }

        travel(root.left, row+1, col-1);
        travel(root.right, row+1, col+1);

        return;
    }
}