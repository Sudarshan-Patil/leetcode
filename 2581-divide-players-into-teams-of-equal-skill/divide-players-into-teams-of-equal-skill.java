class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        Arrays.sort(skill);

        int i = 0;
        int j = n-1;

        long sum = skill[i]+skill[j];
        long prod = 0;

        while (i<j) {
            if (skill[i] + skill[j] != sum) {
                return -1;
            }

            prod += skill[i] * skill[j];
            i++;
            j--;
        }

        return prod;
    }
}