class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        happiness = reverse(happiness);

        long sum = 0;
        int dec = 0;

        for (int i=0; i<k && i<happiness.length; i++) {
            if (happiness[i]-dec > 0) {
                sum += happiness[i]-dec;
            }
            dec++;
        }

        return sum;
    }

    public int[] reverse(int[] A) {
        int i=0;
        int j = A.length-1;

        while (i<j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }

        return A;
    }
}