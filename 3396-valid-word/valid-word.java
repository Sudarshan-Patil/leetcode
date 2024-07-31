class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Set<Character> c = new HashSet<Character>(Arrays.asList('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'));
        Set<Character> v = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        Set<Character> n = new HashSet<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        boolean consonant = false;
        boolean vowel = false;
        boolean number = false;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (c.contains(ch)) {
                consonant = true;
            }

            if (v.contains(ch)) {
                vowel = true;
            }

            if (!c.contains(ch) && !v.contains(ch) && !n.contains(ch)) {
                return false;
            }
        }
        
        if (consonant && vowel) {
            return true;
        }

        return false;
    }
}