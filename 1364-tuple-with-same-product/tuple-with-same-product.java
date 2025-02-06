class Solution {

    public int tupleSameProduct(int[] nums) {
        int numsLength = nums.length;

        List<Integer> pairProducts = new ArrayList<>();

        int totalNumberOfTuples = 0;

        for (int firstIndex = 0; firstIndex < numsLength; firstIndex++) {
            for (
                int secondIndex = firstIndex + 1;
                secondIndex < numsLength;
                secondIndex++
            ) {
                pairProducts.add(nums[firstIndex] * nums[secondIndex]);
            }
        }

        Collections.sort(pairProducts);

        int lastProductSeen = -1;
        int sameProductCount = 0;

        for (
            int productIndex = 0;
            productIndex < pairProducts.size();
            productIndex++
        ) {
            if (pairProducts.get(productIndex) == lastProductSeen) {
                sameProductCount++;
            } else {
                int pairsOfEqualProduct =
                    ((sameProductCount - 1) * sameProductCount) / 2;

                totalNumberOfTuples += 8 * pairsOfEqualProduct;

                lastProductSeen = pairProducts.get(productIndex);
                sameProductCount = 1;
            }
        }

        int pairsOfEqualProduct =
            ((sameProductCount - 1) * sameProductCount) / 2;
        totalNumberOfTuples += 8 * pairsOfEqualProduct;

        return totalNumberOfTuples;
    }
}