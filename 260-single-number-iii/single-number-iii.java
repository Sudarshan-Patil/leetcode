class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = nums[0];

        for (int i=1; i<nums.length; i++) {
            sum ^= nums[i];
        }
        int xor = sum;
        int carry = 0;
        while ((sum&1) != 1) {
            carry++;
            sum = sum>>1;
        }

        int check = 1<<carry;
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<nums.length; i++) {
            if ((nums[i]&check) >= 1) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }

        return new int[]{num1, num2};
    }
}