class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        build(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    public void build(int[] nums, int j, ArrayList<Integer> temp) {
        if (j==nums.length) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(nums[j]);
        build(nums, j+1, temp);
        temp.remove(temp.size()-1);
        build(nums, j+1, temp);

        return;
    }
}