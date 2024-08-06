class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> hs = new HashSet<>();
        int[] arr = new int[n+1];

        for (int i=0; i<trust.length; i++) {
            arr[trust[i][1]]++;
            hs.add(trust[i][0]);
        }
        
        for (int i=1; i<=n; i++) {
            if (arr[i] == n-1 && !hs.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}