class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        //boolean luat[] = new boolean[nums.length+1];
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0] , nums[1]);

        return Math.max(dp1(nums) , dp2(nums));
    }

    public int dp1(int[] nums){
        int dp[] = new int[nums.length];
        dp[nums.length-1]=0;
        dp[nums.length-2] = nums[nums.length-2];
        for(int i=dp.length-3;i>=0;i--){
            dp[i]=Math.max(dp[i+2]+nums[i] ,  dp[i+1]);
        }

        return dp[0];

    }


    public int dp2(int[] nums){
        int dp[] = new int[nums.length];
        dp[nums.length-1]=nums[nums.length-1];
        dp[nums.length-2] = Math.max(nums[nums.length-2] , dp[nums.length-1]);
        for(int i=dp.length-3;i>=0;i--){
            dp[i]=Math.max(dp[i+2]+nums[i] ,  dp[i+1]);
        }

        return dp[1];
    }
}
