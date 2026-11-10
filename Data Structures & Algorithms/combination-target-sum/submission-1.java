class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> currSum = new ArrayList<>();
        backtrack(nums , 0 , target , 0 , currSum);
        return ans;
    }

    private void backtrack(int[] nums , int ix , int target , int currSum , List<Integer> currList){
        if(ix == nums.length){
            if(currSum == target){
                ans.add(new ArrayList<>(currList));
            }
            return;
        }
        //if(currSum > target) return;

        backtrack(nums , ix+1 , target , currSum , currList);

        int times=0;
        while(currSum+times*nums[ix]<=target){
            times++;
            currList.add(nums[ix]);
            backtrack(nums , ix+1 , target , currSum+times*nums[ix] , currList);
            
        }
        while(times>0){
            currList.remove(currList.size()-1);
            times--;
        }
    }
}
