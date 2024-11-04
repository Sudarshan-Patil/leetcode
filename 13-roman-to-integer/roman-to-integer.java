class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0;
        int n = s.length();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if (i<n-1 && hm.get(ch) < hm.get(s.charAt(i+1))) {
                ans -= hm.get(ch);
            } else {
                ans += hm.get(ch);
            }
        }

        return ans;
    }
}
