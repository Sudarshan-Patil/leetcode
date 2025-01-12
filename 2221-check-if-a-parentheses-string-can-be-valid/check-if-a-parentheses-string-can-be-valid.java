class Solution {
    public boolean canBeValid(String s, String locked) {
        int length = s.length();

        if (length%2 != 0) {
            return false;
        }

        Stack<Integer> common = new Stack<>();
        Stack<Integer> open = new Stack<>();

        for (int i=0; i<length; i++) {
            if (locked.charAt(i) == '0') {
                common.push(i);
            } else if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!common.isEmpty()) {
                    common.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty() && !common.isEmpty() && open.peek() < common.peek()) {
            open.pop();
            common.pop();
        }

        if (!open.isEmpty()) {
            return false;
        }

        return true;
    }
}