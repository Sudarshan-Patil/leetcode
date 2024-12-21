class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int res = -1;
        for (int i=0; i<n; i++) {
            int j = 0;
            while (j<strs.length) {
                if (i!=j) {
                    if (isSubSequence(strs[i], strs[j])) {
                        break;
                    }
                }
                j++;
            }

            if (j == strs.length) {
                System.out.println(strs[i]);
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }

    public boolean isSubSequence(String A, String B) {
        int i=0;
        int j=0;

        while (j<B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
            }

            if (i == A.length()) {
                return true;
            }
            j++;
        }

        return false;
    }
}