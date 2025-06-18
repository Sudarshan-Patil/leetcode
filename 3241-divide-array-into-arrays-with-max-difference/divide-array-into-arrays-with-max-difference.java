class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n%3!=0) {
            return new int[0][0];
        }
        int[][] ans = new int[n/3][3];
        int idx = 0;
        for (int i=0; i<nums.length; i+=3) {
            for (int j=i; j<i+3; j++) {
                if (j==i) {
                    ans[idx][j-i] = nums[j];
                } else {
                    if (nums[j]-nums[i] > k) {
                        return new int[0][0];
                    } else {
                        ans[idx][j-i] = nums[j];
                    }
                }
            }
            idx++;
        }

        return ans;
    }
}