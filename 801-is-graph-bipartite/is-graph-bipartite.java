class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] color = new int[n];
        for (int i=0; i<n; i++) {
            if (!vis[i]) {
                if (!dfs(i, graph, vis, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int[][] graph, boolean[] vis, int[] color) {
        vis[node] = true;
        for (int i=0; i<graph[node].length; i++) {
            int end = graph[node][i];
            if (!vis[end]) {
                color[end] = 1-color[node];
                if (!dfs(end, graph, vis, color)) {
                    return false;
                }
            } else {
                if (color[end] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    } 
}