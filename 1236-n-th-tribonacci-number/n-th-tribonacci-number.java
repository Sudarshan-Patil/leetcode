class Solution {
    public int tribonacci(int n) {
        int num = n+3;
        long[] t = new long[num+1];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;

        for (int i=3; i<=num; i++) {
            t[i] = t[i-1] + t[i-2] + t[i-3];
        }

        return (int)(t[n]);
    }
}