    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            List<Integer> lista = new ArrayList<>();
            backtrack(target , nums , lista , 0);

            return ans;
        }
        public void backtrack(int target, int[] nums , List<Integer> lista , int start){
            if(target==0){
                ans.add(new ArrayList<>(lista));
                return;
            }
            for(int i=start;i<nums.length;i++){
                lista.add(nums[i]);
                if(target-nums[i]>=0)
                backtrack(target-nums[i] , nums , lista , i);
                lista.remove(lista.size()-1);
            }
        }
    }
