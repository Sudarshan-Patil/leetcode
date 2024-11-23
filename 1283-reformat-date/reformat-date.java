class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();

        String[] dateArr = date.split(" ");

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Jan", 1);
        hm.put("Feb", 2);
        hm.put("Mar", 3);
        hm.put("Apr", 4);
        hm.put("May", 5);
        hm.put("Jun", 6);
        hm.put("Jul", 7);
        hm.put("Aug", 8);
        hm.put("Sep", 9);
        hm.put("Oct", 10);
        hm.put("Nov", 11);
        hm.put("Dec", 12);

        sb.append(dateArr[2]).append("-");
        if (hm.get(dateArr[1]) < 10) {
            sb.append("0").append(hm.get(dateArr[1])).append("-");
        } else {
            sb.append(hm.get(dateArr[1])).append("-");
        }

        if (dateArr[0].charAt(1) >= '0' && dateArr[0].charAt(1) <= '9') {
            sb.append(dateArr[0].substring(0,2));
        } else {
            sb.append("0").append(dateArr[0].substring(0,1));
        }
        
        return sb.toString();
    }
}