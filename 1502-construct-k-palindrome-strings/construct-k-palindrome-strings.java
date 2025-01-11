class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] a = new int[26];
        for (int i=0; i<s.length(); i++) {
            a[s.charAt(i)-'a']++;
        }

        int count = 0;
        for (int i=0; i<26; i++) {
            if (a[i]%2 != 0) {
                count++;
            }

            if (count > k) {
                return false;
            }
        }

        return true;
    }
}