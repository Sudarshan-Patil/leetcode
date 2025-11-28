class Solution {
    int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (edges.length == 0) {
            for (int i=0; i<n; i++) {
                if ((values[i]%k) == 0) {
                    ans++;
                }
            }

            return ans;
        }
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i=0; i<edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            if (!hm.containsKey(start)) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(end);
                hm.put(start, arr);
            } else {
                hm.get(start).add(end);
            }

            start = edges[i][1];
            end = edges[i][0];
            if (!hm.containsKey(start)) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(end);
                hm.put(start, arr);
            } else {
                hm.get(start).add(end);
            }
        }

        dfs(0, -1, hm, values, k);

        return ans;
    }

    public int dfs(int current, int parent, HashMap<Integer, ArrayList<Integer>> hm, int[] values, int k) {
        if (!hm.containsKey(current)) {
            return 0;
        }
        int sum = values[current];
        sum %= k;
        for (int i=0; i<hm.get(current).size(); i++) {
            int temp = hm.get(current).get(i);
            if (temp != parent) {
                sum += dfs(temp, current, hm, values, k);
                sum %= k;
            }
        }

        if (sum == 0) {
            ans++;
        }

        return sum;
    }
}