class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i=0; i<n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int[][] graph, int[] color) {
        for (int i=0; i<graph[node].length; i++) {
            int end = graph[node][i];
            if (color[end] == -1) {
                color[end] = 1-color[node];
                if (!dfs(end, graph, color)) {
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