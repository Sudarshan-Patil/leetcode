class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int last = 0;
        int ans = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                ans = Math.max(ans, i-last);
                last = i;
            }
        }

        return ans;
    }
}