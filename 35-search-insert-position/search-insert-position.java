class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        if (nums[s] == target) {
            return s;
        }

        if (nums[e] == target) {
            return e;
        }

        int ans = e+1;

        while (s<=e) {
            int mid = (s+e)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                ans = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }

        return ans;
    }
    
}