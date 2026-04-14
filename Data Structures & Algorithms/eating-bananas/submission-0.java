class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1 , r=1000000000-1;
        int minimumhours = r;
        while(l<=r){
            int mid=(r-l)/2+l;
            int timetaken =eatbanana(piles , mid);
            if(timetaken<=h){
                minimumhours =Math.min(minimumhours , mid);
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return minimumhours;

        
        
        
    }

    public int eatbanana(int[] piles , int bananaeaten){
        int c=0;
        for(int i=0;i<piles.length;i++){
            c=c+piles[i]/bananaeaten;
            if(piles[i]%bananaeaten>0) c++;
        }

        return c;
    }
}
