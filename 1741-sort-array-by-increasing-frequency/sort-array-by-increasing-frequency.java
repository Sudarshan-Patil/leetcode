class Pair{
    int num;
    int f;
    Pair(int num, int f) {
        this.num = num;
        this.f = f;
    }

    public String toString() {
        return this.num + ":" + this.f;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i])+1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        Pair[] arr = new Pair[hm.size()];
        int j=0;
        for (int key:hm.keySet()) {
            arr[j++] = new Pair(key, hm.get(key));
        }
        
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.f == p2.f) {
                    return p2.num-p1.num;
                }
                return p1.f-p2.f;
            }
        });
        j=0;
        for (int i=0; i<arr.length; i++) {
            int n = arr[i].f;
            while (n>0) {
                n--;
                ans[j++] = arr[i].num;
            }
        }

        return ans;
    }
}