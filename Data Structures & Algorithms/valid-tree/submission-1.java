class Solution {
    boolean ans = true;
    int nr =0;
    Set<Integer> viz = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x : edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);

        }
        dfs(adj , 0 , -1);
        System.out.println(nr + " "+ ans);
        if(ans==false||nr!=n) return false;
        return true;
    }
    public void dfs(List<List<Integer>> adj , int current , int parinte){
        
        if(ans == false) return;
        if(viz.contains(current)) {ans = false; return;}
        nr++;
        viz.add(current);
        for(int next : adj.get(current))  if(next!=parinte)   dfs(adj , next , current);
        

    }
}
