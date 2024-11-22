class Solution {
    int[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int[s.length()][p.length()];
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return check(s.length()-1, p.length()-1, s, p) == 1 ? true : false;
    }

    public int check(int i, int j, String s, String p) {
        if (i == -1 && j== -1) {
           return 1;
        }

        if (i == -1) {
            while (j>=0) {
                if (p.charAt(j) != '*') {
                    return 0;
                } 
                j-=2;
            }
            return 1;
        }

        if (j == -1) {
            return 0;
        }

        if (dp[i][j] == -1) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                dp[i][j] = check(i-1, j-1, s, p);
            } else if (p.charAt(j) == '*') {
                dp[i][j] = check(i, j-2, s, p);
                if (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i][j] | check(i-1, j, s, p);
                }
            } else {
                dp[i][j] = 0;
            }
        }

        return dp[i][j];
    }
}