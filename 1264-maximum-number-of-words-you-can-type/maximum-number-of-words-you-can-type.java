class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        HashSet<Character> hs = new HashSet<>();
        int count = 0;

        for (int i=0; i<brokenLetters.length(); i++) {
            hs.add(brokenLetters.charAt(i));
        }

        for (int i=0; i<words.length; i++) {
            if (isComplete(words[i], hs)) {
                count++;
            }
        }

        return count;
    }

    public boolean isComplete(String s, HashSet<Character> hs) {
        for (int i=0; i<s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}