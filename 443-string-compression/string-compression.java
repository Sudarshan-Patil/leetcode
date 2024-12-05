class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        int i = 1;
        while (i<chars.length) {
            if (chars[i-1] == chars[i]) {
                i++;
            } else {
                if (i-prev > 1) {
                    sb.append(chars[i-1]).append(i-prev);
                } else {
                    sb.append(chars[i-1]);
                }
                prev = i;
                i++;
            }
        }

        if (prev != chars.length) {
            if (i-prev > 1) {
                sb.append(chars[i-1]).append(i-prev);
                prev = i+1;
            } else {
                sb.append(chars[i-1]);
            }
        }

        for (int j=0; j<sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }

        return sb.length();
    }
}