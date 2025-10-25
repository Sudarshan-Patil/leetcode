class Solution {
    public int totalMoney(int n) {
        int temp = 7;
        int count = 1;
        int inc = 1;
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum += count;
            count++;
            if (i%temp == 0) {
                temp+=7;
                inc++;
                count = inc;
            }
        }

        return sum;
    }
}