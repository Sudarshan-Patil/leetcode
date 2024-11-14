class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }        
        int n = points.length;
        int ans = 1;

        for (int i=0; i<points.length; i++) {
            Map<String, Integer> hm = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j=i+1; j<points.length; j++) {
                int x = points[j][0]-points[i][0];
                int y = points[j][1]-points[i][1];

                if (x==0 && y==0) {
                    duplicate++;
                    continue;
                }

                int g = gcd(x, y);

                int dx = x/g;
                int dy = y/g;

                String s = dx + "/" + dy;

                if (!hm.containsKey(s)) {
                    hm.put(s, 1);
                } else {
                    hm.put(s, hm.get(s)+1);
                }

                max = Math.max(max, hm.get(s));
            }
            ans = Math.max(max+duplicate+1, ans);
        }

        return ans;
    }

    public int gcd(int a, int b) {
        if (b==0) {
            return a;
        }

        return gcd(b, a%b);
    }
}