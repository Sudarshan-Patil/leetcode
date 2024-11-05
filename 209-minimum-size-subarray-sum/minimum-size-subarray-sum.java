class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int i = 0;
int j = 0;
int n = nums.length;
		int sum = 0;
		int len = n+1;
		while (j<n) {
			sum += nums[j];
while (sum >= target) {
len = Math.min(len, j-i+1);
				sum -= nums[i];
				i++;
}
j++;
}

return len == n+1 ? 0 : len;
}
}
