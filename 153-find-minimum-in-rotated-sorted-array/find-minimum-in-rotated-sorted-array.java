class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int n = nums.length;
        int mid=0;

        if (nums[0] <= nums[n-1]) {
            return nums[0];
        }

        while (low <= high) {
            mid = (low+high)/2;

            if (mid>0 && nums[mid]<nums[mid-1] && (mid < n-1 && nums[mid]<nums[mid+1])) {
                return nums[mid];
            }

            if (nums[mid] < nums[0]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return nums[mid];
    }
}