class Pair{
    String s;
    double val;
    Pair(String s, double val) {
        this.s = s;
        this.val = val;
    }

    public String toString() {
        return this.s + " : " + this.val;
    }
}
class Solution {
    double[] ans;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Pair>> hm = new HashMap<>();
        ans = new double[queries.size()];
        Arrays.fill(ans, -1);
        Arrays.fill(ans, -1.0);
        for (int i=0; i<equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);

            if (!hm.containsKey(start)) {
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(end, values[i]));
                hm.put(start, temp);
            } else {
                hm.get(start).add(new Pair(end, values[i]));
            }

            if (!hm.containsKey(end)) {
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(start, 1/values[i]));
                hm.put(end, temp);
            } else {
                hm.get(end).add(new Pair(start, 1/values[i]));
            }
        }

        // HashMap<String, Boolean> vis = new HashMap<>();
        HashSet<String> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        
        for (int i=0; i<queries.size(); i++) {
            q = new LinkedList<>();
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);

            vis.clear();
            // dfs(s1, s2, hm, vis, 1.0, i);

            q.offer(new Pair(s1, 1.0));
            while (!q.isEmpty()) {
                Pair p = q.poll();

                if (!hm.containsKey(p.s)) {
                    continue;
                }

                if (p.s.equals(s2)) {
                    ans[i] = p.val;
                    break;
                }

                for (int k=0; k<hm.get(p.s).size(); k++) {
                    Pair temp = hm.get(p.s).get(k);

                    if (!vis.contains(temp.s)) {
                        vis.add(temp.s);
                        q.offer(new Pair(temp.s, temp.val * p.val));
                    }
                }
            }

        }
        
        return ans;
    }

    public boolean dfs(String src, String end, HashMap<String, ArrayList<Pair>> hm, HashMap<String, Boolean> vis, double val, int index) {
        if (!hm.containsKey(src) || vis.containsKey(src)) {
            return false;
        }

        vis.put(src, true);

        if (src.equals(end)) {
            ans[index] = val;
            return true;
        }

        for (int i=0; i<hm.get(src).size(); i++) {
            Pair p = hm.get(src).get(i);
            if (dfs(p.s, end, hm, vis, val*p.val, index)) {
                return true;
            }
        }

        return false;
    }
}