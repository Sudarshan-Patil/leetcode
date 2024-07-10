class Solution {
    public int minOperations(String[] logs) {
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<logs.length; i++) {
            if (logs[i].equals("../")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (logs[i].equals("./")) {
                //do nothing
            } else {
                st.push(1);
            }
        }

        return st.size();
    }
}