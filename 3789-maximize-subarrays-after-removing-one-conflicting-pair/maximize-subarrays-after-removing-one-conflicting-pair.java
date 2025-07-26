import java.util.*;

public class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<List<Integer>> conf = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            conf.add(new ArrayList<>());
        }

        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            int r = Math.max(a, b);
            int l = Math.min(a, b);
            conf.get(r).add(l);
        }

        int maxLeft = 0, secondMax = 0;
        long total = 0;
        long[] gain = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int l : conf.get(i)) {
                if (l > maxLeft) {
                    secondMax = maxLeft;
                    maxLeft = l;
                } else if (l > secondMax) {
                    secondMax = l;
                }
            }

            total += i - maxLeft;

            if (maxLeft > 0)
                gain[maxLeft] += maxLeft - secondMax;
        }

        long bestBonus = 0;
        for (long g : gain) {
            bestBonus = Math.max(bestBonus, g);
        }

        return total + bestBonus;
    }

}