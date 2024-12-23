class Solution {
    String ans = "";
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        
        for (int i=0; i<dictionary.size(); i++) {
            dfs(0, 0, s, dictionary.get(i));
        }

        return ans;
    }

    public void dfs(int i, int j, String s, String target) {
        if (j == target.length()) {
            if (target.length() > ans.length()) {
                ans = target;
            }
            return;
        }

        if (i == s.length()) {
            return;
        }

        if (s.charAt(i) == target.charAt(j)) {
            dfs(i+1, j+1, s, target);
        } else {
            dfs(i+1, j, s, target);
        }

        return ;
    }
}