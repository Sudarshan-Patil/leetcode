class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        HashSet<Integer> hs = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            hs.add(nums[i]);
        }

        int idx = nums.length-1;
        while (idx >=0 && nums[idx] > 0) {
            if (hs.contains(0-nums[idx])) {
                return nums[idx];
            }
            idx--;
        }
        
            
        return -1;
    }
}