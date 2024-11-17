class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");

        if (pattern.length() != s1.length) {
            return false;
        }

        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> hm1 = new HashMap<>();

        for (int i=0; i<pattern.length(); i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (!s1[i].equals(hm.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                hm.put(pattern.charAt(i), s1[i]);
            }

            if (hm1.containsKey(s1[i])) {
                if (pattern.charAt(i) != hm1.get(s1[i])) {
                    return false;
                }
            } else {
                hm1.put(s1[i], pattern.charAt(i));
            }

        }

        return true;
    }
}