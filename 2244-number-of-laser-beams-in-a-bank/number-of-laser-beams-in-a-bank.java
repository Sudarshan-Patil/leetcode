class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int[] sum = new int[n];
        int col = bank[0].length();
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<col; j++) {
                sum[i] += bank[i].charAt(j)-'0';
            }
        }

        int prev = 0;
        for (int i=1; i<n; i++) {
            if (sum[i] == 0) {
                continue;
            }
            
            if (sum[prev] != 0) {
                System.out.println(prev + " : " + sum[prev] + " : " + i + " : " + sum[i]);
                ans += (sum[prev] * sum[i]);
            }
            prev = i;
        }

        return ans;
    }
}