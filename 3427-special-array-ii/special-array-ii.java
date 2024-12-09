class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int n = nums.length;
        int[] pf = new int[n];

        pf[0] = -1;

        for (int i=1; i<n; i++) {
            if (nums[i-1]%2 != nums[i]%2) {
                pf[i] = pf[i-1];
            } else {
                pf[i] = i;
            }
        }

        for (int i=0; i<queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (pf[end] == -1 || pf[end] <= start ) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }

        return ans;
    }
}