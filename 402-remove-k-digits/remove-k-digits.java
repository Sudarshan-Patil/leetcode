class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        Stack<Integer> st = new Stack<Integer>();

        for (int i=0; i<num.length(); i++) {
            int t = num.charAt(i)-'0';

            while (!st.isEmpty() && t < st.peek() && k > 0) {
                st.pop();
                k--;
            }
            st.push(t);
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        int i=0;
        while (i< sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        return i>= sb.length() ? "0" : sb.toString().substring(i);
    }

    
}