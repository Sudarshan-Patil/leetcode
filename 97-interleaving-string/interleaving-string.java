class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int k = s3.length();
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        for (int i=0; i<=s1.length(); i++) {
            Arrays.fill(dp[i], null);
        }
        return isValid(0, 0, 0, s1, s2, s3, dp);
    }

    public boolean isValid(int i, int j, int k, String s1, String s2, String s3, Boolean[][] dp) {
        if (i==s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }

        if (j==s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }

        if (k == s3.length()) {
            return false;
        }

        if (dp[i][j] == null) {
            boolean ans = false;

            if (s1.charAt(i) == s3.charAt(k)) {
                ans |= isValid(i+1, j, k+1, s1, s2, s3, dp);
            }

            if (s2.charAt(j) == s3.charAt(k)) {
                ans |= isValid(i, j+1, k+1, s1, s2, s3, dp);
            }
             dp[i][j] = ans;
        }

       
        return dp[i][j];
    }
}