class Solution {
    public String triangleType(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(nums[0]);
        hs.add(nums[1]);
        hs.add(nums[2]);

        if (!check(nums)) {
            return "none";
        }

        if (hs.size() == 1) {
            return "equilateral";
        } else if (hs.size() == 2) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    public boolean check(int[] nums) {
        if (
            (nums[0] + nums[1] <= nums[2]) ||
            (nums[0] + nums[2] <= nums[1]) ||
            (nums[2] + nums[1] <= nums[0])
        ) {
            return false;
        }
        return true;
    }
}