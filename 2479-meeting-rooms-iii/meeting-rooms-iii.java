class Solution {

    public  int getRoom(int[] rooms) {
        int mxIdx = 0;

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[mxIdx] < rooms[i]) {
                mxIdx = i;
            }
        }
        return mxIdx;

    }

    public  int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        int[] rooms = new int[n];
        long[] finish = new long[n];

        for (int i = 0; i < meetings.length; i++) {
            long meetingStart = meetings[i][0];
            long meetingFinish = meetings[i][1];
            boolean foundRoom = false;
            for (int j = 0; j < n; j++) {
                if (finish[j] <= meetingStart) {
                    // room is empty
                    foundRoom = true;
                    rooms[j]++;
                    finish[j] = meetingFinish;
                    break;
                }
            }

            if (!foundRoom) {
                // delayed
                int minIdx = 0;
                for (int j = 0; j < n; j++) {
                    if (finish[j] - meetingStart < finish[minIdx] - meetingStart) {
                        minIdx = j;
                    }
                }

                // set the meeting to the earliest finish
                rooms[minIdx]++;
                finish[minIdx] += meetingFinish - meetingStart;
            }

        }

        return getRoom(rooms);
    }
}