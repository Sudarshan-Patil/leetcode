class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                st.push(s.charAt(i));
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}