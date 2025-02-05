class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] s1arr = getArray(s1);
        int[] s2arr = getArray(s2);

        if (!compareArr(s1arr, s2arr)) {
            return false;
        }

        int count = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }

            if (count > 2) {
                return false;
            }
        }

        return true;
    }

    public int[] getArray(String s) {
        int[] arr = new int[26];
        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }

        return arr;
    }

    public boolean compareArr(int[] a1, int[] a2) {
        for (int i=0; i<26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }
}