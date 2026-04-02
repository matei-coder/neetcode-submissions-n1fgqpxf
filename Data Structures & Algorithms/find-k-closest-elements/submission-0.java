class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> rasp = new ArrayList<>();
        int primu = binarysearch(arr , 0 , arr.length , x);
        int left=primu , right= primu+1;
       while (k-- > 0) {
            if (left < 0) right++;
            else if (right >= arr.length) left--;
            else if (x - arr[left] <= arr[right] - x) left--;
            else right++;
       }

       for(int i=left+1;i<right;i++){
            rasp.add(arr[i]);
       }

        return rasp;
}
        

       
    

    public static int binarysearch(int[] arr , int l , int r , int k){
       
       
        while(l<r){
            
            int m=(l+r)/2;
            
            if(arr[m]<=k){
                l=m+1;
            }
            else{
                r=m;
            }

        }
        return l > 0 ? l - 1 : 0;
        
        
        
    }
    
}