class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int ans = 1;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                } else if (nums[i] > nums[j] && dp[i] == 1 + dp[j]) {
                    count[i] += count[j];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        
        int nos = 0;
        for (int i=0; i<n; i++) {
            if (dp[i] == ans) {
                nos += count[i];
            }
        }
        
        return nos;
    }

    public void display(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }
}