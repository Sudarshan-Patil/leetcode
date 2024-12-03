class Solution {
    public String addSpaces(String s, int[] spaces) {
        int idx = 0;
        int j = 0;
        int i = 0;
        char[] ch = new char[s.length()+spaces.length];
        while (i<s.length()) {
            if (idx < spaces.length && spaces[idx] == i) {
                ch[j++] = ' ';
                idx++;
            } else {
                ch[j++] = s.charAt(i);
                i++;
            }
        }

        return String.valueOf(ch);
    }
}