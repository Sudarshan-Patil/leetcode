class Solution {
    public int findComplement(int num) {
        int temp = num;
        int ans = 0;
        while (num > 0) {
            if (num%1 == 1) {
                ans = ans<<1;
            } else {
                ans = (ans<<1) | 1;
            }
            num = num>>1;
        }

        return Math.abs(ans-temp);
    }
}