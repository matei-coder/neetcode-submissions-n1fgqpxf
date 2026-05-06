class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        List<Integer> lista = new ArrayList<>();
        combinations(n , k , arr ,lista , 1);
        return ans;
    }
    public void combinations( int n , int k , int[] arr , List<Integer> lista , int start){
        if(lista.size()==k){
            ans.add(new ArrayList<Integer>(lista));
            return;
        }

        for(int i=start ; i<=n ; i++){
           
            lista.add(i);
            combinations(n , k ,arr , lista , i+1);
            lista.remove(lista.size()-1);
            
        }
    }
}