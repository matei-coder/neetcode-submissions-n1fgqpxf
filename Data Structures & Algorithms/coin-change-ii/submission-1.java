class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        // dp[i][j] = number of ways to make j
        // using coins[0..i]
        int[][] dp = new int[n][amount + 1];

        // There is exactly one way to make amount 0:
        // choose no coins.
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

       
            for (int j = 1; j <= amount; j++) {
                 for (int i = 0; i < n; i++) {

                // Don't use coins[i]
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                // Use coins[i]
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }



        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=amount;j++){
        //         System.out.print(dp[i][j]+ " ");
        //     }
        //     System.out.println("");
        // }

        return dp[n - 1][amount];
    }
}