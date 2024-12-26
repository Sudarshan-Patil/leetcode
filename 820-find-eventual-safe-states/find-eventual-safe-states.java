class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int size = graph.length;

        int[] vis = new int[size];
        int[] pathvis = new int[size];

        for (int i=0; i<size; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, pathvis);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i=0; i<size; i++) {
            if (vis[i] == 1 && pathvis[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean dfs(int index, int[][] graph, int[] vis, int[] pathvis) {
        vis[index] = 1;
        pathvis[index] = 1;
        for (int i=0; i<graph[index].length; i++) {
            int start = graph[index][i];
            if (vis[start] == 0) {
                if (dfs(start, graph, vis, pathvis)) {
                    return true;
                }
            } else if (pathvis[start] == 1) {
                return true;
            }
        }
        pathvis[index] = 0;

        return false;
    }

    public void display(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}