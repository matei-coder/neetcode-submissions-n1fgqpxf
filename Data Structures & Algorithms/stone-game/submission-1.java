class Solution {
    public boolean stoneGame(int[] piles) {
       return dfs(0 , piles.length -1 , piles , 1 , 0 , 0);
    }
    private boolean dfs(int l , int r , int[] piles , int rand , int ana , int bob){
        if(l>=r){
            if(ana > bob) return true;
            return false;
        }
        
        if(rand ==1){    
            rand = rand*(-1);       
            return 
            dfs(l+1 , r , piles , rand , ana+piles[l] , bob) || 
            dfs(l , r-1 , piles , rand , ana+piles[r] , bob);
        }else{
            rand = rand*(-1);
            return 
            dfs(l+1 , r , piles , rand , ana , bob+piles[l]) ||
            dfs(l , r-1 , piles , rand , ana , bob+piles[r]);
        }
    }
}