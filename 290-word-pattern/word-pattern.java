class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");

        if (pattern.length() != str.length) {
            return false;
        }

        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> hm1 = new HashMap<>();

        for (int i=0; i<pattern.length(); i++) {
            if (!hm.containsKey(pattern.charAt(i))) {
                hm.put(pattern.charAt(i), str[i]);
            } else {
                if (!hm.get(pattern.charAt(i)).equals(str[i])) {
                    return false;
                }
            }

            if (!hm1.containsKey(str[i])) {
                hm1.put(str[i], pattern.charAt(i));
            } else {
                if (!hm1.get(str[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}