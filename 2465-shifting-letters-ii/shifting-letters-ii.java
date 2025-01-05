class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n];

        for (int i=0; i<shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];

            if (direction == 1) {
                arr[start]++;
                if (end<n-1) {
                    arr[end+1]--;
                }
            } else {
                arr[start]--;
                if (end<n-1) {
                    arr[end+1]++;
                }
            }
        }

        for (int i=1; i<n; i++) {
            arr[i] = arr[i-1] + arr[i];
        }

        char[] st = s.toCharArray();
        display(arr);
        for (int i=0; i<n; i++) {
            if (arr[i] != 0) {
                int temp = (st[i]-'a' + arr[i])%26;
                if (temp < 0) {
                    temp = 26+temp;
                }
                st[i] = (char)('a' + temp);
            }
        }

        return new String(st);
    }

    public void display(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return ;
    }
}

