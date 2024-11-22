class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i=0; i<matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][0] == matrix[i][j]) {
                    sb.append('T');
                } else {
                    sb.append('F');
                }
            }
            addToHashMap(hm, sb);
        }
        int ans = 0;
        for (String key:hm.keySet()) {
            ans = Math.max(ans, hm.get(key));
        }

        return ans;
    }

    public void addToHashMap(HashMap<String, Integer> hm, StringBuilder sb) {
        String s = sb.toString();

        if (!hm.containsKey(s)) {
            hm.put(s, 1);
        } else {
            hm.put(s, hm.get(s)+1);
        }

        return;
    }
}