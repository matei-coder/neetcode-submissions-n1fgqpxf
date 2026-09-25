class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Integer[][] memo = new Integer[nums.length][2000+1];
        return dfs(nums , target , 0 , 0 , memo);
    }
    public int dfs(int[] nums , int target , int sum , int ix , Integer[][] memo){
        if(ix == nums.length){
            if(sum == target)return 1;
            return 0;

        }
        if(memo[ix][sum+1000]!= null) return memo[ix][sum+1000];

        int ans = 0;

        if (sum - nums[ix] >= -1000) {
            ans += dfs(nums, target, sum - nums[ix], ix + 1, memo);
        }

        if (sum + nums[ix] <= 1000) {
            ans += dfs(nums, target, sum + nums[ix], ix + 1, memo);
        }

        memo[ix][sum + 1000] = ans;

        return ans;
        
    }
}
