class Solution {
    public long minimumSteps(String s) {
        long sum = 0;
        long temp = 0;

        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                temp++;
            } else {
                sum += temp;
            }
        }

        return sum;
    }
}