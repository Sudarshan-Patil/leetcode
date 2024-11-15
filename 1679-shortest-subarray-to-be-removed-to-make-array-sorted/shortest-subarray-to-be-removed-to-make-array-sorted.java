class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int right = n-1;
        int left = 0;

        while (right > 0 && arr[right] >= arr[right-1]) {
            right--;
        }
        int ans = right;
        while (left < right && (left == 0 || arr[left] >= arr[left-1])) {
            while (right < n && arr[left] > arr[right]) {
                right++;
            }
            ans = Math.min(ans, right-left-1);
            left++;
        } 

        return ans;
    }
}