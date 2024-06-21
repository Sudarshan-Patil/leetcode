class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for (int i=0; i<customers.length; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
        }

        for (int i=0; i<minutes; i++) {
            if (grumpy[i] == 1) {
                ans += customers[i];
            }
        }
        int res = ans;

        for (int i=minutes; i<customers.length; i++) {
            if (grumpy[i-minutes] == 1) {
                ans -= customers[i-minutes];
            }
            if (grumpy[i] == 1) {
                ans += customers[i];
            }
            res = Math.max(res, ans);
        }


        return res;
    }
}