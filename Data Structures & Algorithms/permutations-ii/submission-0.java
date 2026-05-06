class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>>set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] viz = new boolean[nums.length];
        List<Integer> lista = new ArrayList<>();
        backtrack(nums , viz , lista);


        return ans;
    }
    public void backtrack(int[] nums , boolean[] viz , List<Integer> lista){
        if(lista.size() == nums.length){
            if(!set.contains(lista)){
                ans.add(new ArrayList<>(lista));
                set.add(lista);
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(viz[i]==false){
            lista.add(nums[i]);
            viz[i] = true;
            
            backtrack(nums , viz , lista);
            viz[i] = false;
            lista.remove(lista.size()-1);
            }
        }
    }
}