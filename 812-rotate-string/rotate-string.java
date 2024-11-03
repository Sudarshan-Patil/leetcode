class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] s2 = goal.toCharArray();

        for (int i=1; i<=s1.length; i++) {
            s1 = rotate(s1);

            if (isSameArray(s1, s2)) {
                return true;
            }
        }

        return false;
    }

    public char[] rotate(char[] s1) {
        char[] s = new char[s1.length];
        int n = s1.length-1;
        for (int i=1; i<=n; i++) {
            s[i-1] = s1[i];
        }
        s[n] = s1[0];

        return s;
    }

    public boolean isSameArray(char[] s1, char[] s2) {
        int i=0;
        while (i<s1.length) {
            if (s1[i] != s2[i]) {
                return false;
            }
            i++;
        }

        return true;
    }
}