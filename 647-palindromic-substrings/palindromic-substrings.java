class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for (int gap = 0; gap<len; gap++) {
            for (int i=0, j=gap; j<len; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                    count++;
                } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                } else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}