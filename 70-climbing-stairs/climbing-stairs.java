class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;

        if (n<=2) {
            return n;
        }

        int c = 0;
        while (n>2) {
            c = a+b;
            a = b;
            b = c;
            n--;
        }

        return c;
    }
}