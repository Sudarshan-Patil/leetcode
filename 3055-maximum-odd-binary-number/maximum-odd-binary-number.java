class Solution {
    public String maximumOddBinaryNumber(String s) {
        int i=0;
        int j=0;
        int n = s.length();
        int last = s.charAt(n-1) == '1' ? n-1 : n;

        while (j<last) {
            if (s.charAt(j) == '1') {
                if (last == n) {
                    s = swap(s, j, last-1);
                    last--;
                } else {
                    s = swap(s, j, i);
                    i++;
                }
            }
            j++;
        }

        return s;
    }

    public String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);

        char t = sb.charAt(j);
        sb.setCharAt(j, sb.charAt(i));
        sb.setCharAt(i, t);

        return sb.toString();
    }
}