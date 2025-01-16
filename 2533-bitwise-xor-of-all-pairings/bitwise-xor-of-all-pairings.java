class Solution {
    public int xorAllNums(int[] num1, int[] num2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n1 = num1.length;
        int n2 = num2.length;
        for (int i=0; i<n1; i++) {
            if (!hm.containsKey(num1[i])) {
                hm.put(num1[i], n2);
            } else {
                hm.put(num1[i], hm.get(num1[i])+n2);
            }
        }

        for (int i=0; i<n2; i++) {
            if (!hm.containsKey(num2[i])) {
                hm.put(num2[i], n1);
            } else {
                hm.put(num2[i], hm.get(num2[i])+n1);
            }
        }
        int ans = 0;
        for (int key:hm.keySet()) {
            if (hm.get(key)%2 == 1) {
                ans ^= key;
            }
        }

        return ans;
    }
}