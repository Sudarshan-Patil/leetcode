class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];

        for (int i=0; i<roads.length; i++) {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }

        Integer[] cities = new Integer[n];

        for (int i=0; i<n; i++) {
            cities[i] = i;
        }

        Arrays.sort(cities, new Comparator<Integer>(){
            public int compare(Integer a1, Integer a2) {
                return degree[a2]-degree[a1];
            }
        });

        long ans = 0;
        for (int i=0; i<n; i++) {
            ans += (long)(n-i)*degree[cities[i]];
        }

        return ans;
    }
}