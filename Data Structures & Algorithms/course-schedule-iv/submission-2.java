class Solution {
    boolean rasp = false;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] edge : prerequisites) adj.get(edge[0]).add(edge[1]);
        
        List<Set<Integer>>ajungela = new ArrayList<>();
        for(int i=0;i<numCourses;i++) ajungela.add(new HashSet<>());
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            dfs(adj , i , ajungela.get(i));
        }
        
        for(int[] query : queries){
           
            if(ajungela.get(query[0]).contains(query[1]))
            ans.add(true);
            else ans.add(false);
        }

        return ans;
    }
    public void dfs(List<List<Integer>> adj , int start  , Set<Integer> ajunge){
       
        for(int next:adj.get(start)) if (ajunge.add(next)) dfs(adj , next , ajunge);
    }
}