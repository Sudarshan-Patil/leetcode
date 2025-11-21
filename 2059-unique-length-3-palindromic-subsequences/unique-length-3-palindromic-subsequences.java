class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (!hm.containsKey(ch)) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                hm.put(ch, arr);
            } else {
                hm.get(ch).add(1, i);
            }
        }
        int count = 0;
        for (char ch:hm.keySet()) {
            if (hm.get(ch).size() < 2) {
                continue;
            }
            int start = hm.get(ch).get(0);
            int end = hm.get(ch).get(1);
            HashSet<Character> hs = new HashSet<>();
            for (int i=start+1; i<end; i++) {
                hs.add(s.charAt(i));
            }
            count += hs.size();
        }

        return count;
    }
}