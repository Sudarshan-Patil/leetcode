class Solution {
    int[][] dp;
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        dp = new int[n+1][n/2+1];
        
        return 1 + getMin(1, 1, n);
    }

    public int getMin(int copy, int paste, int n) {
        if (copy == n) {
            return 0;
        }

        if (copy > n) {
            return 1000;
        }

        if (dp[copy][paste] == 0) {
            int a = 1 + getMin(copy+paste, paste, n);

            a = Math.min(a, 2 + getMin(2*copy, copy, n));
            dp[copy][paste] = a;
        }
        
        return dp[copy][paste];
    }
}