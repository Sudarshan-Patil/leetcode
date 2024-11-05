class Solution {
    public int minChanges(String s) {
        int count = 0;
        int n = s.length();
        for (int i=0; i<n; i+=2) {
            int onecount = 0;
            int zerocount = 0;
            for (int j=i; j<i+2; j++) {
                if (s.charAt(j) == '0') {
                    zerocount++;
                } else {
                    onecount++;
                }
            }

            count += Math.min(zerocount, onecount);
        }

        return count;
    }
}