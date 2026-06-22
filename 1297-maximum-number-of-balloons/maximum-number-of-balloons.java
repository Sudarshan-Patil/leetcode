class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] t1 = new int[26];
        int[] t2 = new int[26];
        int ans = Integer.MAX_VALUE;

        String s = "balloon";

        for (int i=0; i<s.length(); i++) {
            t1[s.charAt(i)-'a']++;
        }

        for (int i=0; i<text.length(); i++) {
            t2[text.charAt(i)-'a']++;
        }

        for (int i=0; i<26; i++) {
            if (t1[i] > 0) {
                int t = t2[i]/t1[i];
                ans = Math.min(ans, t);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}