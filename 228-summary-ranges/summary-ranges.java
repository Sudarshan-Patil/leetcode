class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        int j=0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]+1) {
                if (i-1==j) {
                    ans.add(nums[j]+"");
                } else {
                    ans.add(nums[j] +"->"+nums[i-1]);
                }
                j=i;
            }
        }

        if (j == nums.length-1) {
            ans.add(nums[j]+"");
        } else {
            ans.add(nums[j] +"->"+nums[nums.length-1]);
        }
        
        return ans;
    }
}