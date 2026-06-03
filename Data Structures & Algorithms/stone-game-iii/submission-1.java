class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            dp[i] = Integer.MIN_VALUE;
            int suma = 0;
            for(int j=1;j<=3;j++){
                if(j+i>n) break;
                suma+= stoneValue[i+j-1];

                dp[i] = Math.max(dp[i] , suma - dp[i+j]);
            }


        }
        for(int x: dp) System.out.print(x+ " ");

        

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";


        

    }
}