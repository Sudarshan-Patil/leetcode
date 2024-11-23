class Solution {
    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();

        String[] dateArr = date.split("-");

        int year = Integer.valueOf(dateArr[0]);
        int month = Integer.valueOf(dateArr[1]);
        int day = Integer.valueOf(dateArr[2]);
        sb.append(getBinary(year)).append("-").append(getBinary(month)).append("-").append(getBinary(day));

        return sb.toString();
    }

    public String getBinary(int num) {
        int[] arr = new int[32];
        int idx = 31;
        for (int i=0; i<32; i++) {
            arr[idx--] = (num&(1<<i)) > 0 ? 1 : 0;
        }

        int i=0;
        while (arr[i] == 0) {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (i<32) {
            sb.append(arr[i]);
            i++;
        }

        return sb.toString();
    }
}