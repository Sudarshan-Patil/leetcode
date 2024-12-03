class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b) ->{
            return a[0] - b[0];
        });

        int count = 0;

        int start = meetings[0][0];
        int end = meetings[0][1];

        if(start != 1){
            count += (start-1);
        }

        for(int i = 1 ; i < meetings.length ; i++){
            if(end < meetings[i][0]){
                count += (meetings[i][0] - end - 1);
                start = meetings[i][0];
                end = meetings[i][1];
            }
            else {
                start = Math.min(start,meetings[i][0]);
                end = Math.max(end,meetings[i][1]);
            }
        }

        if(end < days){
            count += days - end;
        }

        return count;
    }
}