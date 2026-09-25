class Solution {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0 , 0 ,0 , s1 , s2 , s3 , memo);
    }
    public boolean dfs(int i , int j , int k , String s1 , String s2 , String s3,Boolean[][] memo){
        if(k == s3.length()){
            return (i==s1.length())&&(j == s2.length());
        }

        if(memo[i][j]!= null){
            return memo[i][j];
        }

        boolean ans = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            ans = ans || dfs(i+1 , j , k+1 , s1 , s2 , s3 , memo);
        }
        if( j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            ans = ans || dfs(i , j+1 , k+1 , s1 , s2 , s3 , memo);
        }
        memo[i][j] = ans;

        return ans;

        
    }
}
