class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;     // negatives and zero are out
        while (n % 3 == 0) {          // while divisible by 3, reduce
            n /= 3;
        }
        return n == 1;                // only true if we reduced to 1
    }
}