class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i=0; i<words.length; i++) {
            int[] arr = getCharArray(words[i]);
            if (arr[x-'a'] > 0) {
                ans.add(i);
                continue;
            }
        }

        return ans;
    }

    public int[] getCharArray(String s) {
        int[] t = new int[26];

        for (int i=0; i<s.length(); i++) {
            t[s.charAt(i)-'a']++;
        }

        return t;
    }
}