class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[2];
        for (int i=0; i<nums.length; i++) {
            int sum = target-nums[i];
            if (hm.containsKey(sum)) {
                ans[0] = hm.get(sum);
                ans[1] = i;
                return ans;
            } else {
                hm.put(nums[i], i);
            }
        }

        return ans;
    }
}