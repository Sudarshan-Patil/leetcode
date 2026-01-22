class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<Integer>();
        int count = 0;
        for (int num:nums) {
            arr.add(num);
        }

        while (arr.size() > 0) {
            boolean isSorted = true;
            int minSum = Integer.MAX_VALUE;
            int targetIndex = -1;

            for (int i=0; i<arr.size()-1; i++) {
                int sum = arr.get(i) + arr.get(i+1);

                if (sum < minSum) {
                    minSum = sum;
                    targetIndex = i;
                }

                if (arr.get(i) > arr.get(i+1)) {
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }

            count++;
            arr.set(targetIndex, minSum);
            arr.remove(targetIndex+1);
        }

        return count;
    }
}