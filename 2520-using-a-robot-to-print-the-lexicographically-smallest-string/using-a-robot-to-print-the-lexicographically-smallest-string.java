class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] suffixMin = new char[n];
        suffixMin[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = s.charAt(i) < suffixMin[i + 1] ? s.charAt(i) : suffixMin[i + 1];
        }

        var ans = new StringBuilder();
        var stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= suffixMin[i]) {
                ans.append(stack.pop());
            }
            if (s.charAt(i) == suffixMin[i]) {
                ans.append(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}