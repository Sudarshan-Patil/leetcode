class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<String>();
        int[] ch = new int[26];
        int[] ch1 = new int[26];
        String s = words[0];
        for (int i=0; i<s.length(); i++) {
            ch[s.charAt(i)-'a']++;
        }
       
        for (int j=1; j<words.length; j++) {
            s = words[j];
            ch1 = new int[26];
            for (int i=0; i<s.length(); i++) {
                ch1[s.charAt(i)-'a']++;
            }

            for (int i=0; i<26; i++) {
                ch[i] = Math.min(ch[i], ch1[i]);
            }
        }
        int n = words.length;

        for (int i=0; i<26; i++) {
            if (ch[i] > 0) {
                while (ch[i] > 0) {
                    ch[i]--;
                    char c = (char)(i+'a');
                    ans.add(c + "");
                }
            }
        }

        return ans;
    }
}