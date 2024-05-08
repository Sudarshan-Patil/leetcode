class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');

        Stack<Character> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                if (st.isEmpty() || st.pop() != hm.get(s.charAt(i))) {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        return (!st.isEmpty()) ? false : true;
    }
}