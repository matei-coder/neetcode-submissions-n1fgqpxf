class Solution {

    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();


        memo = new Integer[word1.length()][word2.length()];

        return dfs( 0 , 0 , word1 , word2 );
    }

    private int dfs(int ix , int ixT, String word1 , String word2 ){
        if(ix == word1.length()){
            return word2.length() - ixT;
        }
        if(ixT == word2.length()){
            return word1.length() - ix;
        }

        if(memo[ix][ixT] != null) return memo[ix][ixT];

        int luat = Integer.MAX_VALUE;
        if(word1.charAt(ix) == word2.charAt(ixT)){
            memo[ix][ixT] = dfs(ix+1 , ixT+1 , word1 , word2 );
        }
        else{
            int nou = Math.min(dfs(ix+1 , ixT , word1 , word2 ),
                dfs(ix , ixT+1 , word1 , word2 ));
            memo[ix][ixT] = 1+Math.min(Math.min(luat , nou), 
                dfs(ix+1, ixT+1,  word1 , word2));
        }

        

        return memo[ix][ixT];

        
    }
}
