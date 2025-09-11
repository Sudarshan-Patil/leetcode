class Solution {
    public String sortVowels(String s) {
        Set<Character> hs = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> ls = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                ls.add(s.charAt(i));
            }
        }

         Collections.sort(ls);

        int index = 0;
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (hs.contains(c))
                result.append(ls.get(index++));
            else
                result.append(c);
        }

        return result.toString();
    }
}