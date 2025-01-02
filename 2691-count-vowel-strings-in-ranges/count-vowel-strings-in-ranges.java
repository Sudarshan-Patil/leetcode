class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pf = new int[n];
        if (isVowel(words[0])) {
            pf[0] = 1;
        }

        for (int i=1; i<n; i++) {
            if (isVowel(words[i])) {
                pf[i] = pf[i-1] + 1;
            } else {
                pf[i] = pf[i-1];
            }
        }
        int size = queries.length;
        int[] ans = new int[size];

        for (int i=0; i<size; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (start == 0) {
                ans[i] = pf[end];
            } else {
                ans[i] = pf[end]-pf[start-1];
            }
        }

        return ans;
    }

    public boolean isVowel(String s) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        
        if (!hs.contains(s.charAt(0)) || !hs.contains(s.charAt(s.length()-1))) {
            return false;
        }

        return true;
    }
}