class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        for (int i=n-1; i>=0; i--) {
            int maxValue = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int ind=i; ind<i+k && ind<n; ind++) {
                max = Math.max(max, arr[ind]);
                int step = dp[ind+1] + (max * (ind-i+1));
                maxValue = Math.max(maxValue, step);
            }
            dp[i] = maxValue;
        }

        return dp[0];
        // Arrays.fill(dp, -1);
        // return getMax(0, arr, k, n, dp);
    }

    public int getMax(int i, int[] arr, int k, int n, int[] dp) {
        if (i>=n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int maxValue = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int ind=i; ind<i+k && ind<n; ind++) {
            max = Math.max(max, arr[ind]);
            int step = getMax(ind+1, arr, k, n, dp) + (max * (ind-i+1));
            maxValue = Math.max(maxValue, step);
        }

        return dp[i] = maxValue;
    }
}