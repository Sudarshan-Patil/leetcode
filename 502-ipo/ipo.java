class Pair{
    int c;
    int p;
    Pair(int c, int p) {
        this.c = c;
        this.p = p;
    }

    public String toString() {
        return this.c + " : " + this.p;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> pqC = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.c-p2.c;
            }
        });

        PriorityQueue<Pair> pqP = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p2.p-p1.p;
            }
        });

        for (int i=0; i<profits.length; i++) {
            pqC.offer(new Pair(capital[i], profits[i]));
        }

        // while (!pq.isEmpty()) {
        //     System.out.println(pq.poll());
        // }

        int sum = w;
        for (int i=0; i<k; i++) {
            while (!pqC.isEmpty() && sum >= pqC.peek().c) {
                pqP.offer(pqC.poll());
            }

            if (pqP.isEmpty()) {
                break;
            }
            sum = sum + pqP.poll().p;
        }
        return sum;

    }
}