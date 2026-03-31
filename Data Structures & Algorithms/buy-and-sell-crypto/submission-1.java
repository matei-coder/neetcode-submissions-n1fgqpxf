class Solution {
    public int maxProfit(int[] prices) {
        int minim = 101;
        int maxim = 0;
        int best=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minim){
                minim=prices[i];
            }
            else{
                best=Math.max(best , prices[i]-minim);
            }
        }
        return best;

    }
}
