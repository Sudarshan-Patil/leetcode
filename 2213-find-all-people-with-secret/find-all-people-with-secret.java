class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] parent = new int[n];         
        for (int i = 0; i < n; i++) {
            parent[i] = i;                  
        }
        parent[firstPerson] = 0;            

        List<int[]>[] meetingsByTime = new List[100001];
        for (int[] m : meetings) {
            int t = m[2];
            if (meetingsByTime[t] == null) {
                meetingsByTime[t] = new ArrayList<>();
            }
            meetingsByTime[t].add(new int[]{m[0], m[1]});
        }

        for (int time = 0; time < meetingsByTime.length; time++) {
            if (meetingsByTime[time] == null) continue;

            List<int[]> currentMeetings = meetingsByTime[time];

            for (int[] meet : currentMeetings) {
                union(meet[0], meet[1], parent);
            }

            for (int[] meet : currentMeetings) {
                int a = meet[0], b = meet[1];
                if (find(a, parent) != 0) {    
                    parent[a] = a;              
                }
                if (find(b, parent) != 0) {
                    parent[b] = b;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (find(i, parent) == 0) {
                result.add(i);
            }
        }
        return result;
    }

    private void union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px != py) {
            if (px < py) parent[py] = px;
            else parent[px] = py;
        }
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}