class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i=0; i<str1.length; i++) {
            String s = str1[i];
            if (!hm.containsKey(s)) {
                hm.put(s, 1);
            } else {
                hm.put(s, hm.get(s)+1);
            }
        }

        for (int i=0; i<str2.length; i++) {
            String s = str2[i];
            if (!hm.containsKey(s)) {
                hm.put(s, 1);
            } else {
                hm.put(s, hm.get(s)+1);
            }
        }

        HashSet<String> hs = new HashSet<>();

        for (String key: hm.keySet()) {
            if (hm.get(key) == 1) {
                hs.add(key);
            }
        }

        String[] ans = new String[hs.size()];
        int idx = 0;
        for (String key:hs) {
            ans[idx++] = key;
        }

        return ans;
    }
}