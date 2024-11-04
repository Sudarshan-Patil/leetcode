class Solution {
    public String compressedString(String word) {
        StringBuffer sb = new StringBuffer();
        int count = 1;
        int i=1;

        while (i<word.length()) {
            if (word.charAt(i-1) == word.charAt(i) && count < 9) {
                count++;
            } else {
                sb.append(count).append(word.charAt(i-1));
                count = 1;
            }
            i++;
        }

        sb.append(count).append(word.charAt(i-1));

        return sb.toString();
    }
}