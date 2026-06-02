class Solution {
    public int numSquares(int n) {
        int[] nums = new int[101];
        for(int i=0;i<=100;i++){
            nums[i]=(i+1)*(i+1);
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int num : nums){
            for(int i=0;i<=n;i++){
                
                if(i-num>=0) dp[i] =Math.min(dp[i] , dp[i-num]+1);
            }
        }

       


        return dp[n];
    }
}