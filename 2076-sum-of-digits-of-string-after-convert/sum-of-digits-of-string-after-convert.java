class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i=0; i<s.length(); i++) {
            int t = (s.charAt(i)-'a'+1);
            if (t > 9) {
                t = getSum(t);
            }
            sum += t;
        }
        k--;
        while (k>0) {
            sum = getSum(sum);
            k--;
        }

        return sum;
    }

    public int getSum(int sum) {
        if (sum == 0) {
            return sum;
        }

        return (sum%10) + getSum(sum/10);
    }
}