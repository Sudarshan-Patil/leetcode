class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";

        while (n > 1) {
            s = s + "1" + reverse(s);
            n--;
        }

        return s.charAt(k-1);
    }

    public String reverse(String s) {
        StringBuilder str = invert(s);
        int i=0;
        int j=s.length()-1;

        while (i<j) {
            char ch = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, ch);
            i++;
            j--;
        }

        return str.toString();
    }

    public StringBuilder invert(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<s.length(); i++) {
            char ch = sb.charAt(i) == '0' ? '1' : '0';
            sb.setCharAt(i, ch);
        }
        

        return sb;
    }
}