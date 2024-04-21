class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        boolean[] vis = new boolean[n];

        for (int i=0; i<edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            if (!hm.containsKey(start)) {
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(end);
                hm.put(start, t1);
            } else {
                hm.get(start).add(end);
            }

            if (!hm.containsKey(end)) {
                ArrayList<Integer> t2 = new ArrayList<>();
                t2.add(start);
                hm.put(end, t2);
            } else {
                hm.get(end).add(start);
            }
        }

        vis[source] = true;
        dfs(source, hm, vis);

        return vis[destination];
    }

    public void dfs(int s, HashMap<Integer, ArrayList<Integer>> hm, boolean[] vis) {
        if (!hm.containsKey(s)) {
            return;
        }

        for (int i=0; i<hm.get(s).size(); i++) {
            int d = hm.get(s).get(i);
            if (vis[d]) {
                continue;
            }

            vis[d] = true;
            dfs(d, hm, vis);
        }

        return;
    }
}