class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] =1;
        
            for(int i=0;i<=target;i++){
                for(int num : nums){
                if(i-num>=0) dp[i] += dp[i-num];
            }
        }

        for(int x: dp) System.out.print(x+" ");
        return dp[target];

    }
}