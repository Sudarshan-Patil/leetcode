class Solution {
    public double averageWaitingTime(int[][] customers) {
        int len = customers.length;
        if (len == 0) {
            return 0;
        }

        long ans = customers[0][1];
        long prev_finish = customers[0][1] + customers[0][0];
        for (int i=1; i<len; i++) {
            prev_finish = Math.max(prev_finish, customers[i][0]);
            
            prev_finish += customers[i][1];
            
            ans += (prev_finish-customers[i][0]);
            
        }

        return (double)ans/len;
    }
}