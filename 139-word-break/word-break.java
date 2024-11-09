class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        hs.addAll(wordDict);
        dp = new Boolean[s.length()];

        return canBreak(s, 0, hs);
    }

    public boolean canBreak(String s, int start, HashSet<String> hs) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start]!=null) {
            return dp[start];
        }

        boolean res = false;
        for (int i=start+1; i<=s.length(); i++) {
            String curr = s.substring(start, i);

            if (!hs.contains(curr)) {
                continue;
            }

            if (canBreak(s, i, hs)) {
                res = true;
                break;
            }
        }
        dp[start] = res;
        return dp[start];
    }
}