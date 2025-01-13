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
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left != null) {
                q.offer(temp.left);
                addToHashMap(temp.val, temp.left.val, hm);
            }

            if (temp.right != null) {
                q.offer(temp.right);
                addToHashMap(temp.val, temp.right.val, hm);
            }
        }

        // System.out.println(hm);

        Queue<Integer> que = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();

        que.offer(start);
        hs.add(start);
        int step = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            // System.out.println(que);
            while (size-- > 0) {
                int t = que.poll();
                if (!hm.containsKey(t)) {
                    continue;
                }
                for (int i=0; i<hm.get(t).size(); i++) {
                    if (!hs.contains(hm.get(t).get(i))) {
                        hs.add(hm.get(t).get(i));
                        que.offer(hm.get(t).get(i));
                    }
                }
            }

            step++;
        }

        return step-1;
    }

    public void addToHashMap(int i, int j, HashMap<Integer, ArrayList<Integer>> hm) {
        if (!hm.containsKey(i)) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(j);
            hm.put(i, temp);
        } else {
            hm.get(i).add(j);
        }

        if (!hm.containsKey(j)) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            hm.put(j, temp);
        } else {
            hm.get(j).add(i);
        }

        return;
    }
}