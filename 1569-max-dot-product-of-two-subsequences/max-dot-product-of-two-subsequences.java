class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        // Calculate maximum and minimum values for nums1
        for (int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }
        // Calculate maximum and minimum values for nums2
        for (int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        // Check special cases where all elements are negative
        if ((firstMax < 0 && secondMin > 0) || (firstMin > 0 && secondMax < 0)) {
            return Math.max(firstMax * secondMin, firstMin * secondMax);
        }


        int[][] dp = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return getMax(0, 0, n, m, nums1, nums2, dp);
    }

    public int getMax(int i, int j, int n, int m, int[] nums1, int[] nums2, int[][] dp) {
        if (i>=n || j>=m) {
            return 0;
        }

    

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int temp = nums1[i]*nums2[j]; 

        int a = temp + getMax(i+1, j+1, n, m, nums1, nums2, dp);
        int b = getMax(i+1, j, n, m, nums1, nums2, dp);
        int c = getMax(i, j+1, n, m, nums1, nums2, dp);

        dp[i][j] = Math.max(Math.max(a, b), c);

        return dp[i][j];
    }
}