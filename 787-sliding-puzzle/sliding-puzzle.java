class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] directory = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {4, 2}
        };

        String target = "123450";
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }

        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(sb.toString());
        vis.add(sb.toString());
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String temp = q.poll();

                if (temp.equals(target)) {
                    return steps;
                }

                int index = temp.indexOf('0');
                for (int i=0; i<directory[index].length; i++) {
                    String t = swap(temp, index, directory[index][i]);

                    if (vis.contains(t)) {
                        continue;
                    }

                    q.offer(t);
                    vis.add(t);
                }
            }
            steps++;
        }

        return -1;
    }

    public String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char t = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, t);

        return sb.toString();
    }
}