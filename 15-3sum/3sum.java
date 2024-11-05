class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();

		Arrays.sort(nums);
		int n = nums.length;
		for (int i=0; i<n; i++) {
			int j = i+1;
			int k = n-1;

			while (j<k) {
				int sum = nums[i] + nums[j] + nums[k];
				
				if (sum == 0) {
List<Integer> temp = new ArrayList<>();
temp.add(nums[i]);
temp.add(nums[j]);
temp.add(nums[k]);
ans.add(new ArrayList<>(temp));
while (j<k && nums[j] == nums[j+1]) {
	j++;
}
j++;
k--;
} else if (sum < 0) {
	while (j<k && nums[j] == nums[j+1]) {
	j++;
}
j++;
} else {
	while(k>j && nums[k] == nums[k-1]) {
		k--;
}
k--;
}
}
while(i<n-1 && nums[i] == nums[i+1]) {
	i++;
}
}

return ans;
}
}
