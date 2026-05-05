class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> lista = new ArrayList<>();
        backtrack(nums , lista , 0);
        return ans;

        
    }
    public void backtrack(int[] nums , List<Integer> lista , int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(lista));
            return;           
        }
      
        lista.add(nums[i]);
        backtrack(nums , lista , i+1);
        lista.remove((Integer)nums[i]);   
          backtrack(nums , lista , i+1);   
    }
}
