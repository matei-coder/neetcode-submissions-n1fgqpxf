class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxday=0;
        for(int x:weights){
            maxday=Math.max(maxday , x);
        }
        int answer=5000000;
        int l=maxday , r = 50001 ; 
        while(l<=r){
            int mid=(r-l)/2+l;
            if(timeforload(weights , mid)<=days){
                answer = mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }




        return answer;
        
    }

    public int timeforload(int[] weights , int loadcapacity ){
        int c=0;
        int cur = loadcapacity;
        for(int i=0;i<weights.length;i++){
            if(cur<weights[i]){
                c++;
                cur = loadcapacity;
                cur=cur-weights[i];

            }
            else{
            cur=cur-weights[i];
            }
        }
        return c+1;
    }
}