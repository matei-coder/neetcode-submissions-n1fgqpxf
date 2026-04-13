class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int rasp=nums.length;
        while(l<=r){
            int m = (r-l)/2+l;
            if(nums[m]==target) return m;
            else if(nums[m]<target) {
                
                l=m+1;
                }
            else {
                rasp=m;
                r=m-1;}
            
        }
        return rasp;
    }
}
