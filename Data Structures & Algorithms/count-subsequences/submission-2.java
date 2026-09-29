class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        Integer[][] memo = new Integer[n+1][m+1];
        return dfs(0 , 0 , s ,t , memo);
    }
    private int dfs(int ix , int ixT , String s, String t , Integer[][] memo){
        if(ixT == t.length()) return 1; 

        if(memo[ix][ixT]!=null) return memo[ix][ixT];

        char c = t.charAt(ixT);
        int ans = 0;
        for(int i = ix ; i < s.length();i++){
            if(s.charAt(i) == c){
                ans+=dfs( i+1 , ixT+1 , s , t , memo);
            }
        }

        memo[ix][ixT] = ans;

        return ans;
    }
}
