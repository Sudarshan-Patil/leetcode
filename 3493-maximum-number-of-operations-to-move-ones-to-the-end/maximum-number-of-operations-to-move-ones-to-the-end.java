class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int zeros = 0;
        int ans = 0;
        char prev = '\0';
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0' && prev != '0') {
                zeros++;
            } else if (s.charAt(i) == '1') {
                ans += zeros;
            }
            prev = s.charAt(i);
        }

        return ans;
    }
}