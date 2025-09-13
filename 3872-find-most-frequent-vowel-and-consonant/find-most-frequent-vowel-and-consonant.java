class Solution {
    public int maxFreqSum(String s) {
        Set<Character> hs = Set.of('a', 'e', 'i', 'o', 'u');
        int[] arr = new int[26];
        int maxV = 0;
        int maxC = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch-'a']++;

            if (hs.contains(s.charAt(i))) {
                maxV = Math.max(maxV, arr[ch-'a']);
            } else {
                maxC = Math.max(maxC, arr[ch-'a']);
            }
        }

        return maxC+maxV;
    }
}