class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> lista = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates , lista , target , 0);
        return ans;
    }
    public void backtrack(int[] candidates , List<Integer> lista , int target , int start){
        if(target==0&&!ans.contains(lista)){
            ans.add(new ArrayList<>(lista));
            return;
        }
        //while(start+1<candidates.length&&candidates[start+1]==candidates[start]) start++;

        for(int i=start; i<candidates.length;i++){
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if(target-candidates[i]<0) break;
            lista.add(candidates[i]);
            backtrack(candidates , lista , target - candidates[i] , i+1);
            lista.remove(lista.size()-1);
           
        }
    }
}
