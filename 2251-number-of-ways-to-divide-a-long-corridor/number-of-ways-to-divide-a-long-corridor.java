class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1000000007;
        long ans = 1;
        int gap = 0;
        int chairs = 0;

        // Count total seats
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') chairs++;
        }

        // Edge cases
        if (chairs == 0) return 0;
        if (chairs % 2 == 1) return 0;
        if (chairs == 2) return 1;

        // Reset counters for main traversal
        chairs = 0;

        for (int i = 0; i < corridor.length(); i++) {
            char ch = corridor.charAt(i);

            if (ch == 'S' && chairs < 2) {
                chairs++;
            } 
            else if (ch == 'S' && chairs == 2) {
                ans = (ans * (gap + 1)) % mod;
                chairs = 1;
                gap = 0;
            } 
            else if (ch == 'P' && chairs == 2) {
                gap++;
            }
        }

        return (int) ans;
    }
}