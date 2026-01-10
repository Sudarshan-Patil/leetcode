class Solution {
    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        dp = new int[n1+1][n2+1];
        for (int i=0; i<=n1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getString(0, 0, n1, n2, s1, s2);
    }

    public int getString(int i, int j, int n1, int n2, String s1, String s2) {
        if (i==n1 && j==n2) {
            return 0;
        }

        if (i==n1) {
            int temp = 0;
            for (int k=j; k<n2; k++) {
                temp += (int)s2.charAt(k);
            }
            return temp;
        }

        if (j==n2) {
            int temp = 0;
            for (int k=i; k<n1; k++) {
                temp += (int)s1.charAt(k);
            }
            return temp;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = getString(i+1, j+1, n1, n2, s1, s2);
        } else{
            int a = getString(i+1, j, n1, n2, s1, s2) + (int)s1.charAt(i);
            int b = getString(i, j+1, n1, n2, s1, s2) + (int)s2.charAt(j);
            dp[i][j] = Math.min(a, b);
        }

        return dp[i][j];
    }
}