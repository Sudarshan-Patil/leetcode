class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (int i=0; i<word.length(); i++) {
            arr[word.charAt(i)-'a']++;
        }
        Arrays.sort(arr);
        int ans = 0;
        
        for (int i=25; i>=0; i--) {
            if (arr[i] == 0) {
                break;
            }
            ans += ((25-i)/8+1)*arr[i];
        }

        return ans;
    }
}