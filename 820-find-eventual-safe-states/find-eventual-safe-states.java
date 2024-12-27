class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int size = graph.length;
        int[] indegree = new int[size];
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<Integer>();

        for (int i=0; i<graph.length; i++) {
            int end = i;
            for (int j=0; j<graph[i].length; j++) {
                int start = graph[i][j];
                if (!hm.containsKey(start)) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(end);
                    hm.put(start, arr);
                } else {
                    hm.get(start).add(end);
                }
            }
            indegree[i] = graph[i].length;
        }

        for (int i=0; i<size; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            ans.add(temp);

            if (!hm.containsKey(temp)) {
                continue;
            }

            for (int i=0; i<hm.get(temp).size(); i++) {
                indegree[hm.get(temp).get(i)]--;
                if (indegree[hm.get(temp).get(i)] == 0) {
                    q.offer(hm.get(temp).get(i));
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}