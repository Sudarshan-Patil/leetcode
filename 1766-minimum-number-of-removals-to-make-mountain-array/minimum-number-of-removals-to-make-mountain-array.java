class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] pf = getLIS(nums);
        reverse(nums);
        int[] sf = getLIS(nums);
        reverse(sf);
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (pf[i] > 1 && sf[i] > 1) {
                ans = Math.min(
                    ans,
                    n-pf[i]-sf[i]+1
                );
            }
        }

        return ans;
    }

    public void display(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

    public int[] getLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }

        return dp;
    }

    public void reverse(int[] arr) {
        int i=0;
        int j=arr.length-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return;
    }
}