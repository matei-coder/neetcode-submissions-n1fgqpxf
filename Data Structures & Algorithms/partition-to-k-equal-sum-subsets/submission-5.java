class Solution {
    boolean ans= false;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] baskets = new int[k];
        int s=0;
        for(int x:nums){
            s+=x;
        }
        if(s%k!=0) return false;
        s=s/k;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;}

        backtrack(nums , baskets , 0 , s);

        return ans;
    }

    public void backtrack(int[] nums , int[] baskets , int start , int s){
        if(ans) return;
        if(start == nums.length){


            boolean all=true;
            for(int i=0;i<baskets.length;i++){
                if(baskets[i]!=s) {all=false; break;}
            }
            if(all) ans = true;
            return;
        }



        for(int i=0;i<baskets.length;i++){
            if(baskets[i]+nums[start]<=s){
                baskets[i] = baskets[i]+nums[start];
                backtrack(nums , baskets , start+1 , s);
                baskets[i] = baskets[i]-nums[start];
            }
        }

    }
}