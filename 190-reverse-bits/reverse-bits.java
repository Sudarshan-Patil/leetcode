public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int sum = n&1;
        n = n>>1;
        for (int i=1; i<32; i++) {
            sum = (sum<<1) | (n&1);
            n = n>>1;
        }

        return sum;
    }
}