class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;

        Arrays.sort(hand);

        for (int i=0; i<hand.length; i++) {
            if (hand[i] >= 0) {
                if (!valid(hand, i, groupSize)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean valid(int[] hand, int i, int g) {
        int cnt = 1;
        int temp = hand[i]+1;
        while (cnt < g && i < hand.length) {
            if (hand[i] == temp) {
                temp = hand[i]+1;
                hand[i] = -1;
                cnt++;
            }
            i++;
        }

        if (cnt == g) {
            return true;
        } else {
            return false;
        }
    }
}