class Solution {
    public int strStr(String haystack, String needle) {
        for (int i=0; i<haystack.length(); i++) {
            if (compare(haystack.substring(i), needle)) {
                return i;
            }
        }

        return -1;
    }

    public boolean compare(String s1, String s2) {
        int i=0;
        while (i<s1.length() && i<s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
            i++;
        }
        if (i==s2.length()) {
            return true;
        }
        return false;
    }
}