class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peek()!='(') {
                    sb.append(st.pop());
                }
                st.pop();
                for (int j=0; j<sb.length(); j++) {
                    st.push(sb.charAt(j));
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        if (!st.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }

            return sb.reverse().toString();
        }
        return "";
    }
}