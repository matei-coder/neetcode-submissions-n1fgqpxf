class Solution {
    
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }
        int[] viz = new int[n];
        int comp = 0;
        for(int i=0;i<n;i++){
            if(viz[i] == 0){
                comp++;
                dfs(adj , i , viz);
            }
        }

        return comp;

        



    }

    public void dfs( List<List<Integer>> adj , int curr , int[] viz){
        if(viz[curr]!=0) return;
        viz[curr] = 1;
        for(int next : adj.get(curr)) dfs(adj , next , viz);

    }
}
