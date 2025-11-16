class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        int n = s.length();
        long count = 0;
        long ans = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                if (count > 0) {
                    ans += (count * (count+1))/2;
                    ans %= mod;
                    count=0;
                }
            }
        }

        if (count > 0) {
            ans += (count * (count+1))/2;
            ans %= mod;
        }

        return (int)ans;
    }
}