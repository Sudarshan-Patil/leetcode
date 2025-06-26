class Solution {
    public int longestSubsequence(String s, int k) {
        int zero = 0;
        for(char ch : s.toCharArray())
            if(ch == '0')
                zero++;

        int power = 0;
        int countOne = 0;
        long val = 0;

        for(int i = s.length() - 1; i >= 0 && power < 32; i--) {
            if(s.charAt(i) == '1') {
                val += 1L << power;
                if(val > k)
                    break;
                countOne++;
                power++;
            } else {
                power++;
            }
        }

        return countOne + zero;
    }
}