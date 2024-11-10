class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k==0) {
            return 1;
        }
        int left = 0;
        int right = nums.length;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;

            if (isValid(mid, nums, k)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int len, int[] nums, int k) {
        int[] bitArray = new int[32];
        for (int i=0; i<nums.length; i++) {
            bitArray = updateNumInArray(nums[i], bitArray, 1);

            if (i>=len) {
                bitArray = updateNumInArray(nums[i-len], bitArray, -1);
            }

            if (i>= len-1 && generateNum(bitArray) >= k) {
                return true;
            }
        }

        return false;
    }

    public int[] updateNumInArray(int num,int[] bitArray, int inc) {
        for (int i=0; i<32; i++) {
            if ((num&(1<<i)) > 0) {
               bitArray[i] += inc; 
            }
        }

        return bitArray;
    }

    public int generateNum(int[] bitArray) {
        int ans = 0;
        for (int i=0; i<32; i++) {
            if (bitArray[i] > 0) {
                ans |= (1<<i);
            }
        }

        return ans;
    }
}