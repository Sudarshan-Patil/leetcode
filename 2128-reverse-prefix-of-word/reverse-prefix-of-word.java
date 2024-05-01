class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();

        int i=0;
        while (i<word.length() && word.charAt(i) != ch) {
            i++;
        }

        if (i == word.length()) {
            return word;
        }

        for (int j=i; j>=0; j--) {
            sb.append(word.charAt(j));
        }

        for (int j=i+1; j<word.length(); j++) {
            sb.append(word.charAt(j));
        }

        return sb.toString();
    }
}