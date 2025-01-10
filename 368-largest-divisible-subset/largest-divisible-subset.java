class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for (int i=0; i<n; i++) {
            hash[i] = i;
        }
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int max = 0;
        int maxi = 0;

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i]%nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
                if (dp[i] > max) {
                    max = dp[i];
                    maxi = i;
                }
            }
        }

        int i = maxi;
        while (hash[i] != i) {
            ans.add(nums[i]);
            i = hash[i];
        }
        ans.add(nums[i]);
        Collections.reverse(ans);
        return ans;
    }

    public void display(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }
}