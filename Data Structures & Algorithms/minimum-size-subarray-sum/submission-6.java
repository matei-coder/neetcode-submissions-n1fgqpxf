class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0, j= 0;
        int sum=0;
        int minimum = 100001;
        while(i<nums.length||j<i){
           
            
            if(sum<target&&i<nums.length){
                sum+=nums[i++];
            }
            else{
                sum-=nums[j++];
            }
            if(sum>=target)
            minimum = Math.min(minimum , i-j);
        }
        if(minimum!=100001)
        return minimum;
        else return 0;
    }
    
}