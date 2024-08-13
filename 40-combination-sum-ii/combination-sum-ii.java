class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        getAll(0, candidates, target, new ArrayList<Integer>());

        return ans;
    }

    public void getAll(int j, int[] c,int t, ArrayList<Integer> temp) {
        if (j > c.length || t<0) {
            return;
        }

        if (t == 0) {
            ans.add(new ArrayList<Integer>(temp));
        }

        for (int i=j; i<c.length; i++) {
            temp.add(c[i]);
            getAll(i+1, c, t-c[i], temp);
            temp.remove(temp.size()-1);
            while (i<c.length-1 && c[i] == c[i+1]) {
                i++;
            }
        }

        return;
    }
}