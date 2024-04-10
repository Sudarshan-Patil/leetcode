class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> q = new LinkedList<Integer>();

        int n = deck.length;
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            q.offer(i);
        }

        int i=0;
        while (!q.isEmpty()) {
            ans[q.poll()] = deck[i++];
            if (q.isEmpty()) {
                break;
            }
            q.offer(q.poll());
        }

        return ans;
    }
}