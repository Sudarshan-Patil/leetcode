class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i=n-1; i>=0; i--) {
            int min = Integer.MAX_VALUE;
            for (int ind=i; ind<s.length(); ind++) {
                if (isPalindrome(i, ind, s)) {
                    int step = 1 + dp[ind+1];
                    min = Math.min(min, step);
                }
            }

            dp[i] = min;
        }

        return dp[0]-1;
        // Arrays.fill(dp, -1);
        // return getMin(0, s, dp)-1;
    }

    public int getMin(int i, String s, int[] dp) {
        if (i==s.length()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int ind=i; ind<s.length(); ind++) {
            if (isPalindrome(i, ind, s)) {
                int step = 1 + getMin(ind+1, s, dp);
                min = Math.min(min, step);
            }
        }

        return dp[i] = min;
    }

    public boolean isPalindrome(int i, int j, String s) {
        while (i<j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}