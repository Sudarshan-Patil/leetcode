class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i=0;
        int j = people.length-1;
        int ans = 0;
        int l = limit;
        while (i<=j) {
            l = limit;
            if (i!=j &&people[i]+people[j] <= l) {
                i++;
                j--;
                ans++;
            } else {
                int k=2;
                while (k>0 && i<=j && l-people[j]>=0) {
                    l = l-people[j];
                    k--;
                    j--;
                }
                ans++;
            }
        }

        return ans;
    }
}