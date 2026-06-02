class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        String maxChar = s.substring(0,1);

        for(int i=0;i<n;i++){
            dp[i][i] = 1;
            if(i<n-1) 
            maxChar = s.substring(i , i+1);
        }
        for(int i=0;i<n-1;i++){
           if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                maxChar = s.substring(i ,i+2);

           }

        }
       
        
        for(int i=3;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k = j+i-1;
                if(dp[j+1][k-1]==1 && (s.charAt(j)==s.charAt(k))){
                    dp[j][k] =1;
                    String neu = s.substring(j , k+1);

                    if(neu.length()>maxChar.length())maxChar = neu;
                }
            }
        }


        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println("");
        // }


        return maxChar;
    }
}
