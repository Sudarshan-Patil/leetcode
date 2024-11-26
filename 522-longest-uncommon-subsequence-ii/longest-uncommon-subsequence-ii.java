class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int res = -1;
        for (int i=0; i<n; i++) {
            int j = 0;
            while (j<n) {
                if (i!=j && isSubSequence(strs[i], strs[j])) {
                    break;
                }
                j++;
            }

            if (j==n) {
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }

    public boolean isSubSequence(String s1, String s2) {
        int i=0;
        int j=0;
        int n = s1.length();
        while (j<s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            if (i==n) {
                return true;
            }
            j++;
        }

        return false;
    }
}