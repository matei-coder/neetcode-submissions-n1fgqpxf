class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0 , r=nums.length-1;
        int pos = 0;
        while(l<=r){
            int m = (r-l)/2+l;
            if(nums[m] < target){
                pos = m+1;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }

        return pos;
    }
}