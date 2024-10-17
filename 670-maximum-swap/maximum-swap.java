class Solution {
    public int maximumSwap(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int n = ch.length;
        int[] arr = new int[10];

        for (int i=0; i<n; i++) {
            arr[ch[i]-'0'] = i;
        }

        for (int i=0; i<n; i++) {
            for (int j=9; j>ch[i]-'0'; j--) {
                if (arr[j] > i) {
                    char temp = ch[i];
                    ch[i] = ch[arr[j]];
                    ch[arr[j]] = temp;
                    return Integer.parseInt(new String(ch));
                }
            }
        }
        
        return num;
    }
}