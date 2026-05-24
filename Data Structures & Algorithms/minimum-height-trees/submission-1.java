class Solution {
    

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());


        List<List<Integer>> ans = new ArrayList<>();


        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            Set<Integer> viz = new HashSet<>();
            int rasp = dfs( i , viz , adj);
            while(rasp>=ans.size()) ans.add(new ArrayList<>());
            ans.get(rasp).add(i);
        }
        int k=0;
        while(ans.get(k).size()==0){
            k++;
        }
        return ans.get(k);
        
    }
    public int dfs(int curr , Set<Integer> viz ,  List<List<Integer>> adj){
        viz.add(curr);

        int maxim =0;
        for(int neigh : adj.get(curr)){
            if(!viz.contains(neigh)) {
                maxim = Math.max(dfs(neigh , viz , adj) , maxim);
            }
        }
        return maxim+1;

    }
}