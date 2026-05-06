class Solution {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> lista = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums , lista , 0);
        return ans;
    }
    public void backtrack(int[] nums  , List<Integer> lista , int i){
        
        if(!set.contains(lista)) {
            ans.add(new ArrayList<>(lista));
            set.add(lista);
        }
        if(i==nums.length) return;
        lista.add(nums[i]);
        backtrack(nums , lista , i+1);
        lista.remove(lista.size()-1);
        backtrack(nums , lista , i+1);


    }
}
