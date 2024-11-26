class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (int i=0; i<edges.length; i++) {
            indegree[edges[i][1]]++;
        }
        int count = 0;
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) {
                count++;
                ans = i;
            }
        }

        return count > 1 ? -1 : ans;
    }
}