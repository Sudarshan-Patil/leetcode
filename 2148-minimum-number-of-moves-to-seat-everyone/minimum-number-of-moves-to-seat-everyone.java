class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int i=0;
        int sum = 0;

        while (i<seats.length) {
            if (seats[i] != students[i]) {
                sum += Math.abs(seats[i] - students[i]);
            }
            i++;
        }

        return sum;
    }
}