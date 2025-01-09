class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMax(0, n-1, s, dp);
    }

    public int getMax(int i, int j, String s, int[][] dp) {
        if (i>j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = Integer.MAX_VALUE;
        if (s.charAt(i) == s.charAt(j)) {
            a = getMax(i+1, j-1, s, dp);
        } else {
            a = Math.min(getMax(i+1, j, s, dp), getMax(i, j-1, s, dp)) + 1;
        }

        return dp[i][j] = a;
    }
}