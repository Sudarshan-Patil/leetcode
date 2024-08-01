class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (int i=0; i<details.length; i++) {
            String s = details[i];
            int n = (s.charAt(11)-'0')*10 + (s.charAt(12)-'0');
            if (n > 60) {
                count++;
            }
        }

        return count;
    }
}