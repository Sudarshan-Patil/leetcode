class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for (int i=0; i<n1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMax(0, 0, text1, text2, dp);
    }

    public int getMax(int i, int j, String s1, String s2, int[][] dp) {
        if (i==s1.length() || j==s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            a = getMax(i+1, j+1, s1, s2, dp) + 1;
        } else {
            a = Math.max(
                getMax(i+1, j, s1, s2, dp),
                getMax(i, j+1, s1, s2, dp)
            );
        }

        return dp[i][j] = a;
    }
}