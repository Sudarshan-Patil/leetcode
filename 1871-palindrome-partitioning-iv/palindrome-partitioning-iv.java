// USING TWO PINTER TECHNIQUE
// LEFT, MID, RIGHT
class Solution {
    public boolean checkPartitioning(String s) {
        char[] ch = s.toCharArray();

        // making dp
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) { // back to front
            for (int j = i; j < s.length(); j++) { // (back-1) to end_of_string
                if (ch[i] == ch[j]) { // if equal
                    dp[i][j] = ((i + 1 <= j - 1) ? dp[i + 1][j - 1] : true);
                } else { // if not equal
                    dp[i][j] = false;
                }
            }
        }

        // finding the valid
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i; j < s.length() - 1; j++) {
                // LEFT, MID, RIGHT ==> 3-division of string (s)
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][s.length() - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}