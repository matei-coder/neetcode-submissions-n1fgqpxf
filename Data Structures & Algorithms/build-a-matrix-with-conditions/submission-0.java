class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> graforizontal = buildGraph(rowConditions , k);
        List<List<Integer>> grafvertical = buildGraph(colConditions , k);

        int[] ordorizontal = kahn(graforizontal);
        int[] ordvertical = kahn(grafvertical);

        if(ordorizontal==null||ordvertical==null) return new int[0][];

        Map<Integer , Integer> undeekpeorizontala = new HashMap<>();
        Map<Integer , Integer> undeekpeverticala = new HashMap<>();


        for(int i=0;i<ordorizontal.length;i++){
            undeekpeorizontala.put( ordorizontal[i] , i-1);
            undeekpeverticala.put( ordvertical[i] , i-1);
        }

        int[][] ans = new int[k][k];
            for(int num=1;num<=k;num++){
                int v =  undeekpeverticala.get(num);
                int o =  undeekpeorizontala.get(num);
                ans[o][v] = num;
            }
            
        

        return ans;

    }


    public List<List<Integer>> buildGraph(int[][] conditions , int k){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=k;i++) adj.add(new ArrayList<>());
        for(int[] condition : conditions){
            adj.get(condition[0]).add(condition[1]);
        }
        return adj;
    }


    public int[] kahn(List<List<Integer>> g){
        int j=0;
        int[] rasp = new int[g.size()];
        int[] intrari = new int[g.size()];
        for(List<Integer> lista : g){
            for(int vec : lista){
                intrari[vec]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<intrari.length;i++){
            if(intrari[i]==0) q.add(i);
        }
        
      
        while(!q.isEmpty()){
            int curr = q.poll();
            
            rasp[j++] = curr;
            for(int next : g.get(curr)){
                intrari[next]--;
                if(intrari[next]==0) q.add(next);
            }
        }

        if(j==g.size()){
            return rasp;
        }
        else return null;


    }
}