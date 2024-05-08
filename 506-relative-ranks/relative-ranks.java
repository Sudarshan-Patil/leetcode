class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        String[] ranks = new String[3];

        ranks[0] = "Gold Medal";
        ranks[1] = "Silver Medal";
        ranks[2] = "Bronze Medal";

        TreeMap<Integer, String> tm = new TreeMap<>(Collections.reverseOrder());

        for (int i=0; i<score.length; i++) {
            tm.put(score[i], "");
        }

        int i=0;
        for (int key:tm.keySet()) {
            if (i<3) {
                tm.put(key, ranks[i]);
            } else {
                tm.put(key, i+1+"");
            }
            i++;
        }

        for (int j=0; j<score.length; j++) {
            ans[j] = tm.get(score[j]);
        }

        return ans;
    }
}