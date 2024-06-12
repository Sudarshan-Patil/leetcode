class Solution {
    public int strStr(String haystack, String needle) {
        String s = needle + "$" + haystack;

        int[] lps = new int[s.length()];
        lps[0] = 0;

        for (int i=1; i<s.length(); i++) {
            int x = lps[i-1];

            while (s.charAt(x) != s.charAt(i)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x-1];
            }

            lps[i] = x+1;

            if (lps[i] == needle.length()) {
                return i - 2 * needle.length();
            }
        }
        return -1;
    }
}