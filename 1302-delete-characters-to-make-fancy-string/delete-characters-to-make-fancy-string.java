class Solution {
    public String makeFancyString(String s) {
        Stack<Character> stack= new Stack<>();

        Stack<Integer> num = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (stack.empty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
                num.push(1);
            } else if (stack.peek() == s.charAt(i)) {
                stack.push(s.charAt(i));
                num.push(num.peek()+1);
            }
            if (num.peek() == 3) {
                num.pop();
                stack.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}