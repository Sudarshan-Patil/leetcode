class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int countMin = 0;
        int countMax = 0;
        for (int i=0; i<nums.length; i++) {
            if (min>nums[i]) {
                min = nums[i];
                countMin = 1;
            } else if (min == nums[i]) {
                countMin++;
            }

            if (max<nums[i]) {
                max = nums[i];
                countMax = 1;
            } else if (max == nums[i]) {
                countMax++;
            }
        }

        if (nums.length == countMax || nums.length == countMin) {
            return 0;
        }
        return nums.length-countMax-countMin;
        
    }
}