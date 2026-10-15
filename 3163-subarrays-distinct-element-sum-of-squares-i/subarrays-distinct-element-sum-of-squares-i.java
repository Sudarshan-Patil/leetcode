class Solution {
    public int sumCounts(List<Integer> nums) {
        int len = nums.size();
        int ans = 0;
        for (int i=0; i<len; i++) {
            boolean[] bo = new boolean[101];
            int count = 0;
            for (int j=i; j<len; j++) {
                int val = nums.get(j);
                if (!bo[val]) {
                    bo[val] = true;
                    count++;
                }
                ans += count * count;
            }
        }

        return ans;
    }
}