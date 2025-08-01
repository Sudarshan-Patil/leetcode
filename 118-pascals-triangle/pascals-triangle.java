class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int n = numRows-1;
        for (int i=0; i<numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i) {
                    temp.add(1);
                } else {
                    int t = res.get(i-1).get(j-1) + res.get(i-1).get(j); 
                    temp.add(t);
                }
            }
            res.add(temp);
        }

        return res;
    }
}