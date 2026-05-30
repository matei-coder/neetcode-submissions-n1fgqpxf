class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount ==0) return 0;
        int dp[] = new int[amount+1];
        Arrays.fill(dp , Integer.MAX_VALUE/4);
        for(int x: coins){
            if(x<=amount) dp[x]=1;
        }
        for(int i=1;i<amount+1;i++){
            for(int x: coins)
            if(i-x>0) dp[i] = Math.min(dp[i] , dp[i-x]+1);
        }

        for(int x: dp){
            System.out.print(x+" ");
        }

        return (dp[amount]==Integer.MAX_VALUE/4) ? -1 : dp[amount];
    }
}
