class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return getCount(0, 0, s, t, dp);
    }

    public int getCount(int i, int j, String s1, String s2, int[][] dp) {
        if (j==s2.length()) {
            return 1;
        }

        if (i == s1.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = getCount(i+1, j+1, s1, s2, dp);
        }
        ans += getCount(i+1, j, s1, s2, dp);
        dp[i][j] = ans;
        return dp[i][j];
    }
}