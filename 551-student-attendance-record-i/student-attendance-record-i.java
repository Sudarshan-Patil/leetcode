class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'A') {
                a++;
            } else if (s.charAt(i) == 'L') {
                if (i>0 && s.charAt(i-1) == 'L') {
                    l++;
                } else {
                    l = 1;
                }
            }

            if (a >= 2 || l >= 3) {
                return false;
            }
        }
        
        return true;
    }
}