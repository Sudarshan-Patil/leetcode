class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], 1);
            } else {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
        }
        int count = 0;
        for (int key:hm.keySet()) {
            if (k > 0 && hm.containsKey(k+key)) {
                count++;
            } else if (k == 0 && hm.get(key) > 1) {
                count++;
            }
        }

        return count;
    }
}