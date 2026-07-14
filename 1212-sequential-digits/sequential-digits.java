class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> ans = new ArrayList<Integer>();

        for (int i=2; i<=s.length(); i++) {
            recursion(ans, s, low, high, 0, i);
        }

        return ans;
    }

    public void recursion(List<Integer> ans, String s, int low, int high, int i, int j) {
        if (j > s.length()) {
            return;
        }

        int temp = Integer.parseInt(s.substring(i, j));

        if (temp >= low && temp <= high) {
            ans.add(temp);
        }

        recursion(ans, s, low, high, i+1, j+1);

        return;
    }
}