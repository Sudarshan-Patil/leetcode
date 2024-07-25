class Solution {
    public int[] sortArray(int[] nums) {
        partition(0, nums.length-1, nums);

        return nums;
    }

    public void partition(int s, int e, int[] nums) {
        if (s>=e) {
            return;
        }

        int mid = s + (e-s)/2;
        partition(s, mid, nums);
        partition(mid+1, e, nums);

        merge(s, mid, e, nums);
    }

    public void merge(int s, int m, int e, int[] nums) {
        int i=s;
        int j=m+1;
        int idx = 0;
        int[] ans = new int[e-s+1];
        while (i<=m && j<=e) {
            if (nums[i] <= nums[j]) {
                ans[idx++] = nums[i++];
            } else {
                ans[idx++] = nums[j++];
            }
        }

        while (i<=m) {
            ans[idx++] = nums[i++];
        }

        while (j<=e) {
            ans[idx++] = nums[j++];
        }
        idx = 0;
        for (int k=s; k<=e; k++) {
            nums[k] = ans[idx++];
        }

        return;
    }
}