class Solution {
    public int minOperations(String s) {
        int st0 = 0;
        int st1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    st1++;
                } else {
                    st0++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    st1++;
                } else {
                    st0++;
                }
            }
        }
        
        return Math.min(st0, st1);
    }
}