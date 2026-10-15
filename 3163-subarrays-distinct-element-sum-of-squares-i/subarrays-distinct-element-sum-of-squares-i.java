class Solution {
    public int sumCounts(List<Integer> nums) {
        int len = nums.size();
        int ans = 0;
        for (int i=0; i<len; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j=i; j<len; j++) {
                if (!hs.contains(nums.get(j))) {
                    hs.add(nums.get(j));
                }
                ans = ans + (hs.size() * hs.size());
            }
        }

        return ans;
    }
}