class Solution {
    boolean ans=false;
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int x:matchsticks) sum+=x;
        sum/=4;
        backtrack(matchsticks , 0 , 0 , 0 , 0, 0 , sum);
        return ans;
    }

    public void backtrack(int[] matchsticks , int start , 
    int sum1 , int sum2 , int sum3 , int sum4 , int prag){
        if(ans==true) return;
        if(start==matchsticks.length){
            if(sum1==prag&&sum2==prag&&sum3==prag&&sum4==prag)
            ans=true;
            return;
        }
        if(sum1>prag||sum2>prag||sum3>prag||sum4>prag) return;
        int x = matchsticks[start];
        backtrack(matchsticks , start+1 , sum1+x , sum2 , sum3 , sum4 , prag );
        backtrack(matchsticks , start+1 , sum1 , sum2+x , sum3 , sum4 , prag);
        backtrack(matchsticks , start+1 , sum1 , sum2 , sum3+x , sum4 , prag);
        backtrack(matchsticks , start+1 , sum1 , sum2 , sum3 , sum4+x , prag);

    }
}