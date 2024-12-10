class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> hm = new HashMap<>();


        int len = s.length();
        String str = "";
 
        for (int i=0; i<len; i++) {
            for (int j=i; j<len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    str = s.substring(i, j+1);
                    if (hm.containsKey(str)) {
                        hm.put(str, hm.get(str)+1);
                    } else {
                        hm.put(str, 1);
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(hm);
        
        int ans = -1;
        for (String key:hm.keySet()) {
            if (hm.get(key) >= 3) {
                ans = Math.max(ans, key.length());
            }
        }

        return ans;
    }
}