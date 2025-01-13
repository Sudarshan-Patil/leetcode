class Solution {
    public int minimumLength(String s) {
        int[] arr = new int[26];
        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }

        int ans = 0;
        for (int i=0; i<26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (arr[i]%2 == 0) {
                ans += 2;
            } else {
                ans += 1;
            }
        }
        
        return ans;
    }

    public void display(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        return;
    }

    public void display1(char[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        return;
    }
}