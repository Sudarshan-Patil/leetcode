class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<hand.length; i++) {
            if (hm.containsKey(hand[i])) {
                hm.put(hand[i], hm.get(hand[i])+1);
            } else {
                hm.put(hand[i], 1);
            }
        }

        for (int i=0; i<hand.length; i++) {
            if (hm.containsKey(hand[i])) {
                int cnt = 0;
                int t = hand[i];
                while (cnt < groupSize && hm.containsKey(t)) {
                    hm.put(t, hm.get(t)-1);
                    if (hm.get(t) == 0) {
                        hm.remove(t);
                    }
                    t = t+1;
                    cnt++;
                }

                if (cnt < groupSize) {
                    return false;
                }
            }
        }

        return true;
    }
}