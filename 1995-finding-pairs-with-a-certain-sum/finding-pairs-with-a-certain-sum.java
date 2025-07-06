class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;
        nums2[index] = newVal;

        map.put(oldVal, map.get(oldVal) - 1);
        if (map.get(oldVal) == 0) {
            map.remove(oldVal);
        }

        map.put(newVal, map.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num1 : nums1) {
            count += map.getOrDefault(tot - num1, 0);
        }
        return count;
    }
}