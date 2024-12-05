class Solution {
    public boolean canChange(String start, String target) {
        int i=0;
        int j=0;
        char[] s1 = start.toCharArray();
        char[] s2 = target.toCharArray();

        while (i<s1.length || j<s2.length) {
            while (i<s1.length && s1[i] == '_') {
                i++;
            }

            while (j<s2.length && s2[j] == '_') {
                j++;
            }
            
            if (i==s1.length || j==s2.length) {
                return i == s1.length && j == s2.length;
            }

            if (
                s1[i] != s2[j] ||
                (s1[i] == 'L' && i<j) ||
                (s1[i] == 'R' && i>j)
            ) {
                return false;        
            }
            i++;
            j++;
        }

        return true;
    }
}