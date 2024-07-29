class Solution {
    public int numTeams(int[] rating) {
        int minl = 0;
        int maxl = 0;
        int minr = 0;
        int maxr = 0;
        int ans = 0;
        for (int i=1; i<rating.length; i++) {
            minl = 0;
            maxl = 0;
            minr = 0;
            maxr = 0;

            for (int j=i-1; j>=0; j--) {
                if (rating[i] > rating[j]) {
                    minl++;
                }

                if (rating[i] < rating[j]) {
                    maxl++;
                }
            }
            for (int j=i+1; j<rating.length; j++) {
                if (rating[i] > rating[j]) {
                    minr++;
                }

                if (rating[i] < rating[j]) {
                    maxr++;
                }
            }

            ans += (maxl*minr) + (minl*maxr);
        }

        return ans;
    }
}