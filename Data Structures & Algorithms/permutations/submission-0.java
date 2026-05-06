class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] viz = new boolean[n];
        List<Integer> lista = new ArrayList<>();
        backtrack(nums , viz , lista);
        return ans;
    }
    public void backtrack(int[] nums , boolean[] viz , List<Integer> lista){
        if(lista.size() == nums.length){
            ans.add(new ArrayList<>(lista));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(viz[i]==false){
                lista.add(nums[i]);
                viz[i]=true;
                backtrack(nums , viz , lista);
                viz[i]=false;
                lista.remove(lista.size()-1);
            }
        }

    }
}
