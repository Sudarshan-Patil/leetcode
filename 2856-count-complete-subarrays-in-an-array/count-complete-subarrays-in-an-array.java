class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        int left = 0;
        int right = 0;
        int n = nums.length;

        HashSet<Integer> hs = new HashSet<>();

        for (int i=0; i<n; i++) {
            hs.add(nums[i]);
        }
        int res = 0;
        int size = hs.size();

        for (right=0; right<n; right++) {
            if (hm.containsKey(nums[right])) {
                hm.put(nums[right], hm.get(nums[right])+1);
            } else {
                hm.put(nums[right], 1);
            }

            while (hm.size() == size) {
                res += n-right;

                hm.put(nums[left], hm.get(nums[left])-1);
                if (hm.get(nums[left]) == 0) {
                    hm.remove(nums[left]);
                }
                left++;
            }
        }

        return res; 
    }
}