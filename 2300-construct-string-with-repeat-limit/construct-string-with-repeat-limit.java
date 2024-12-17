class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }

        int right = 25;
        while (right >= 0) {
            int i = 0;
            while (arr[right] > 0 && i < arr[right]) {
                char ch = (char)('a' + right);
                sb.append(ch);
                i++;
                if (i!=arr[right] && i%repeatLimit == 0) {
                    int index = right-1;
                    while (index>=0 && arr[index] == 0) {
                        index--;
                    }
                    if (index>=0) {
                        sb.append((char)('a'+index));
                        --arr[index];
                    } else {
                        break;
                    }
                }
            }
            right--;
        }

        return sb.toString();
    }
}