class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");

        return ans;
    }

    public void generate(int open, int closed, int n, String str) {
        if (open==n && closed==n) {
            ans.add(str);
            return;
        }

        if (open<n) {
            str += "(";
            generate(open+1, closed, n, str);
            str = str.substring(0, str.length()-1);
        }
        if (closed<open) {
            str += ")";
            generate(open, closed+1, n, str);
            str = str.substring(0, str.length()-1);
        }
        
        return;
    }
}