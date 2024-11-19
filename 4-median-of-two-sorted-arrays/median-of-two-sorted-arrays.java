class Solution {
    int p1 = 0;
    int p2 = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m+n)%2 == 0) {
            for (int i=0; i<((m+n)/2)-1; ++i) {
                getMedian(nums1, nums2);
            }
            return (double)(getMedian(nums1, nums2) + getMedian(nums1, nums2))/2;
        } else {
            for (int i=0; i<((m+n)/2); ++i) {
                getMedian(nums1, nums2);
            }
            return (double)getMedian(nums1, nums2);
        }
    }

    public double getMedian(int[] nums1, int[] nums2) {
        if (p1<nums1.length && p2<nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1<nums1.length) {
            return nums1[p1++];
        } else {
            return nums2[p2++];
        }
    }
}