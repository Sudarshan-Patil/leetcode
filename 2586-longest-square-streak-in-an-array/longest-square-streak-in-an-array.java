class Solution {
    int[] dp;
    public int longestSquareStreak(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> setArr = new ArrayList<>(set);
        Collections.sort(setArr);
        
        for (int i = 0; i < setArr.size(); i++) {
            int curr = setArr.get(i);
            int count = 0;
            
            while (set.contains(curr)) {
                set.remove(curr);
                curr = curr * curr;
                count++;
            }
            
            max = Math.max(max, count);
        }
        
        return max > 1 ? max : -1;
    }

    public int longestSquareStreak1(int[] nums) {
        Arrays.sort(nums);
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        display(nums);
        return getMaxSubArray(nums, 0, nums.length, new ArrayList<Integer>());
    }

    public int getMaxSubArray(int[] nums, int i, int n, ArrayList<Integer> temp) {
        if (i >= n) {
            System.out.println(temp);
            if (temp.size() >= 2) {
                return temp.size();
            } else {
                return -1;
            }
        }

        if (dp[i] == -1) {
            dp[i] = getMaxSubArray(nums, i+1, n, temp);

            if (i==0 || (temp.size()>0 && (temp.get(temp.size()-1)*temp.get(temp.size()-1)) == nums[i])) {
                temp.add(nums[i]);
                dp[i] = Math.max(dp[i], getMaxSubArray(nums, i+1, n, temp));
            }
        }

        return dp[i];
    }

    public void display(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+ " ");
        }
        System.out.println();
        return;
    }
}