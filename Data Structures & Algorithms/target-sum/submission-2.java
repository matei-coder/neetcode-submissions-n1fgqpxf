class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //dp[i][j] = nr of ways to arrive at j using until nums[i]

        int[][] dp = new int[nums.length][2001];

        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for(int i=1;i<nums.length;i++){
             for (int s = -1000; s <= 1000; s++) {

                int index = s + 1000;

                // punem + nums[i]
                if (s - nums[i] >= -1000 && s - nums[i] <= 1000) {
                    dp[i][index] += dp[i - 1][s - nums[i] + 1000];
                }

                // punem - nums[i]
                if (s + nums[i] >= -1000 && s + nums[i] <= 1000) {
                    dp[i][index] += dp[i - 1][s + nums[i] + 1000];
                }
            }
        }
        return dp[nums.length-1][target+1000];
        
        
       }
}
