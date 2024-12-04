class Solution {
    public boolean canMakeSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i<s1.length() && j<s2.length()) {
            if (s1.charAt(i) == s2.charAt(j) || valid(s1, s2, i, j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        
        if (j==s2.length()) {
            return true;
        }
        return false;
    }

    public boolean valid(String s1, String s2, int i, int j) {
        char nextChar = (char)(((s1.charAt(i)-'a'+1)%26)+'a');
        if (nextChar != s2.charAt(j)) {
            return false;
        }
        return true;
    }
}