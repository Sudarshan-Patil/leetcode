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
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Queue<TreeNode>  q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode t = q.poll();
                temp.add(t.val);

                if (t.left != null) {
                    q.offer(t.left);
                }

                if (t.right != null) {
                    q.offer(t.right);
                }
            }

            ans += checkOrder(temp);
        }

        return ans;
    }

    public int checkOrder(ArrayList<Integer> arr) {
        int steps = 0;
        ArrayList<Integer> target = (ArrayList)arr.clone();

        Collections.sort(arr);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<arr.size(); i++) {
            hm.put(arr.get(i), i);
        }

        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i) != target.get(i)) {
                steps++;

                int curr_pos = hm.get(target.get(i));
                hm.put(arr.get(i), curr_pos);
                arr.set(curr_pos, arr.get(i));
            }
        }

        return steps;
    }

    public void swap(ArrayList<Integer> arr, int left, int right) {
        int temp = arr.get(left);
        arr.set(left, arr.get(right));
        arr.set(right, temp);

        return;
    }
}