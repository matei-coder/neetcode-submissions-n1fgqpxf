class Solution {
    public boolean canPartition(int[] nums) {
        int s =0;

        for(int x : nums) s+=x;
        if(s%2!=0) return false;
        s=s/2;
        boolean[] dp = new boolean[s+1];
        dp[0] =true;
        for(int t : nums){
        for(int i=s;i>=0;i--){
                if(i-t>=0) dp[i] = dp[i] || dp[i-t];
            }
        }

        return dp[s];
    }
}
