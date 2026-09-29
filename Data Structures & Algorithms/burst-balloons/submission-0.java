class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n+2];
        int[][] dp = new int[n+2][n+2];

        a[0] = 1;
        a[n+1] =1;

        for(int i=0;i<n;i++){
            a[i+1]=nums[i];
        }
        

        for(int len=2 ; len<=n+1 ; len++){
            for(int l =0 ; l+len<=n+1 ; l++){
                int r = l+len;
                for(int k=l+1;k<r;k++){
                    dp[l][r] = Math.max(dp[l][r] , 
                    dp[l][k] +  dp[k][r] + a[l]*a[k]*a[r]);
                }
            }
        }
        for(int i=0;i<=n+1;i++){
            for(int j=0;j<=n+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }


        return dp[0][n+1];
    }
}
