public class Solution {
    public boolean isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        if (m + n != C.length()) return false;
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) continue;
                char c = C.charAt(i + j - 1);

                if (i > 0 && c == A.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j > 0 && c == B.charAt(j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

