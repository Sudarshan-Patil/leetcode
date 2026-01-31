class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[0] > target) {
            return letters[0];
        }

        int s = 0;
        int e = letters.length-1;
        int ans = 0;

        while (s<=e) {
            int mid = (s+e)/2;

            if (letters[mid]<= target) {
                s = mid+1;
            } else {
                ans = mid;
                e = mid-1;
            }
        }

        return letters[ans];
    }
}