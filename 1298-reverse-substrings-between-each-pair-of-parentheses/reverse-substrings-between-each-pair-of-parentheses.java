class Solution {
    int i=0;
    public String reverseParentheses(String s) {
        return solve(s);
    }

    public String solve(String s) {
        StringBuilder sb = new StringBuilder();

        while (i<s.length()) {
            if (s.charAt(i) == ')') {
                i++;
                return sb.reverse().toString();
            } else if (s.charAt(i) == '(') {
                i++;
                String str = solve(s);

                sb.append(str);
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}