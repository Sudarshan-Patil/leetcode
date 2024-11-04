class Solution {
    public int strStr(String haystack, String needle) {
        String s = needle + "$" + haystack;
        int n = s.length();
        int[] lps = new int[n];
        lps[0] = 0;
        for (int i=1; i<n; i++) {
            int x = lps[i-1];
            while (s.charAt(i) != s.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x-1];
            }

            lps[i] = x+1;

            if (lps[i] == needle.length()) {
                return i-needle.length()-needle.length();
            }
        }

        return -1;
    }
}