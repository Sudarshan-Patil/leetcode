class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] prime = getPrime();

        // Start by storing the currValue as 1, and the initial index as 0.
        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            // Store the difference needed to make nums[i] equal to currValue.
            int difference = nums[i] - currValue;
            // If difference is less than 0, then nums[i] is already less than
            // currValue. Return false in this case.
            if (difference < 0) {
                return false;
            }

            // If the difference is prime or zero, then nums[i] can be made
            // equal to currValue.
            if (prime[difference] == true || difference == 0) {
                i++;
                currValue++;
            } else {
                // Otherwise, try for the next currValue.
                currValue++;
            }
        }
        return true;
    }

    public int getPrime(boolean[] prime, int i) {
        int start = 1;
        int end = i-1;
        int ans = -1;
        while (start <= end) {
            int mid = (start+end)/2;

            if (prime[mid]) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return ans;
    }

    public boolean[] getPrime() {
        boolean[] primes = new boolean[1001];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;
        primes[2] = true;

        for (int i=2; i<=1000; i++) {
            for (int j=i*i; j<=1000; j+=i) {
                primes[j] = false;
            }
        }

        return primes;
    }
}