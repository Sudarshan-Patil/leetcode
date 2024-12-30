class Solution {
    int counter = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i=0; i<connections.size(); i++) {
            int start = connections.get(i).get(0);
            int end = connections.get(i).get(1);
            if (!hm.containsKey(start)) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(end);
                hm.put(start, arr);
            } else {
                hm.get(start).add(end);
            }

            start = connections.get(i).get(1);
            end = connections.get(i).get(0);
            if (!hm.containsKey(start)) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(end);
                hm.put(start, arr);
            } else {
                hm.get(start).add(end);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, vis, tin, low, hm, ans);
        
        return ans;
    }

    public void display(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return;
    }

    public void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, HashMap<Integer, ArrayList<Integer>> hm, List<List<Integer>> ans) {
        vis[node] = true;
        tin[node] = low[node] = counter;
        counter++;

        if (!hm.containsKey(node)) {
            return;
        }

        for (int i=0; i<hm.get(node).size(); i++) {
            int adjNode = hm.get(node).get(i);
            if (adjNode == parent) {
                continue;
            }
            if (!vis[adjNode]) {
                dfs(adjNode, node, vis, tin, low, hm, ans);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > tin[node]) {
                    ans.add(Arrays.asList(node, adjNode));
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }

        return;
    }
}