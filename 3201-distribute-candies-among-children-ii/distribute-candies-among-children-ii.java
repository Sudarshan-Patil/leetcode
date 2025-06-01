public class Solution {
    public long distributeCandies(int choco, int l) {
        long ans = 0;

        for (long x = Math.max(0, choco - 2L * l); x <= Math.min(choco, l); x++) {
            long y_st = Math.max(0, choco - l - x);
            long y_en = Math.min(choco - x, l);

            if (y_st <= y_en) {
                ans += (y_en - y_st + 1);
            }
        }

        return ans;
    }
}