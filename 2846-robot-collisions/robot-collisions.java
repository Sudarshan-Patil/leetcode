class Pair{
    int p;
    int h;
    char d;
    int i;
    Pair(int p, int h, char d, int i) {
        this.p = p;
        this.h = h;
        this.d = d;
        this.i = i;
    }

    public String toString() {
        return this.p+":"+this.h+":"+this.d+":"+this.i;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Pair> arr = new ArrayList<Pair>();
        List<Pair> res = new ArrayList<Pair>();
        List<Integer> ans = new ArrayList<Integer>();
        int n = positions.length;
        for (int i=0; i<n; i++) {
            arr.add(new Pair(positions[i], healths[i], directions.charAt(i), i));
        }

        Collections.sort(arr, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.p-p2.p;
            }
        });

        for (int i=0; i<n; i++) {
            System.out.print(arr.get(i));
        }
        System.out.println();

        Stack<Pair> st = new Stack<>();

        for (int i=0; i<n; i++) {
            if (st.isEmpty()) {
                st.push(arr.get(i));
                continue;
            }

            if (arr.get(i).d == 'L') {
                Pair t = arr.get(i);
                while (!st.isEmpty() && t!=null && t.d == 'L' && st.peek().d == 'R') {
                    Pair p = st.pop();
                    if (t.h > p.h) {
                        t.h = t.h-1;
                    } else if (t.h < p.h) {
                        t.h = p.h-1;
                        t.d = p.d;
                        t.p = p.p;
                        t.i = p.i;
                    } else {
                        t = null;
                    }
                }

                if (t!=null) {
                    st.push(t);
                }
            } else {
                st.push(arr.get(i));
            }
        }

        while (!st.isEmpty()) {
            res.add(st.pop());
        }

        Collections.sort(res, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.i-p2.i;
            }
        });

        for (int i=0; i<res.size(); i++) {
            ans.add(res.get(i).h);
        }

        return ans;
    }
}