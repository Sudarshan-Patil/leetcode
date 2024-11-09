class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        int n = s.length();

        for (int i=0; i<wordDict.size(); i++) {
            hs.add(wordDict.get(i));
        }

        Boolean[] dp = new Boolean[s.length()];

        return isValid(0, n, s, hs, dp);
    }

    public boolean isValid(int start, int n, String s, HashSet<String> hs, Boolean[] dp) {
        if (start == n) {
            return true;
        }

        if (dp[start]!=null) {
            return dp[start];
        }

        boolean res =false;
        for (int i=start+1; i<=n; i++) {
            String sb = s.substring(start, i);

            if (!hs.contains(sb)) {
                continue;
            }

            if (isValid(i, n, s, hs, dp)) {
                res = true;
                break;
            }
        }

        dp[start] = res;
        return dp[start];
    }
}