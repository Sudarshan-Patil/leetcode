class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int[] path = new int[n];
        Arrays.fill(path, 1);

        for (int i=0; i<n; i++) {
            if (!vis[i]) {
                dfs(i, edges, vis, path);
            }
        }

        return ans;
    }

    public void dfs(int node, int[] edges, boolean[] vis, int[] path) {
        // display(path);
        if (edges[node] == -1) {
            return;
        }

        int adj = edges[node];
        if (!vis[adj]) {
            vis[adj] = true;
            path[adj] = path[node] + 1;
            dfs(adj, edges, vis, path);
            path[adj] = 1;
        } else if (path[adj] > 1) {
            ans = Math.max(ans, path[node]-path[adj] + 1);
            return;
        }

        return;
    }

    public void display(int[] p) {
        int n = p.length;
        for (int i=0; i<n; i++){
            System.out.print(p[i] + " ");
        }
        System.out.println();
        return;
    }
}