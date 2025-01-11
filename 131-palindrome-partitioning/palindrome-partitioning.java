public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int gap = 0; gap<n; gap++) {
            for (int i=0, j=gap; j<n; i++,j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
                    dp[i][j] = true;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {
        // If we've reached the end of the string, add the current partition to the result list
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Explore all possible partitions
        for (int end = start; end < s.length(); end++) {
            // If the current substring is a palindrome, add it to the current path
            if (dp[start][end] == true) {
                path.add(s.substring(start, end+1));
                // Recur to find other partitions
                backtrack(s, end+1, path, result, dp);
                // Backtrack to explore other partitions
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        // Check if the substring s[left:right+1] is a palindrome
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}