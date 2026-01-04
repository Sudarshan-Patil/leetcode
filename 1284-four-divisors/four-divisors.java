class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += getDivisors(nums[i]);
        }

        return sum;
    }

    public int getDivisors(int num) {
        int count = 0;
        int sum = 0;
        
        for (int i=1; i*i<=num; i++) {
            if (num%i == 0) {
                if (i == num/i) {
                    count++;
                    sum += i;
                } else {
                    count+=2;
                    sum += i + (num/i);
                }
            }

            if (count > 4) {
                return 0;
            }
        }

        if (count != 4) {
            return 0;
        }

        return sum;
    }
}