class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] small = new int[26];
        int[] cap = new int[26];
        int count = 0;

        for (int i=0; i<jewels.length(); i++) {
            char ch = jewels.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                small[ch-'a']++;
            } else {
                cap[ch-'A']++;
            }
        }

        for (int i=0; i<stones.length(); i++) {
            char ch = stones.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (small[ch-'a'] >= 1) {
                    count++;
                }
            } else {
                if (cap[ch-'A'] >= 1) {
                    count++;
                }
            }
        }

        return count;
    }
}