class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        long sum = 0;
        long ans = 0;

        for (int i=0; i<k && i<n; i++) {
            addToHashMap(hm, nums[i], 1);
            sum += nums[i];
        }

        if (hm.size() == k) {
            ans = sum;
        }

        for (int i=k; i<n; i++) {
            addToHashMap(hm, nums[i-k], -1);
            addToHashMap(hm, nums[i], 1);
            sum = sum - nums[i-k] + nums[i];
            if (hm.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    public void addToHashMap(HashMap<Integer, Integer> hm, int num, int inc) {
        if (!hm.containsKey(num)) {
            hm.put(num, 1);
        } else {
            hm.put(num, hm.get(num)+inc);
        }
        if (hm.get(num) == 0) {
            hm.remove(num);
        }
        return;
    }
}