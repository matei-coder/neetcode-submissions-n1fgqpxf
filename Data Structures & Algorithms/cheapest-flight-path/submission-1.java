class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n*(k+2);i++) adj.add(new ArrayList<>());
        for(int[] flight:flights){
            for(int i=0;i<k+1;i++){
                adj.get(i*n+flight[0]).add(new int[]{(i+1)*n+flight[1] , flight[2]});
            }
        }




        //Djikstra
        int[] dist = new int[n*(k+2)];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return dist[a]-dist[b];
        });

        Arrays.fill(dist , Integer.MAX_VALUE/4);
        dist[src]=0;  
        pq.add(src); 
        boolean viz[] = new boolean[n*(k+2)];   

        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(viz[curr]==true) continue;
            viz[curr] =true;

            for(int[] edge :adj.get(curr)){
                int next = edge[0];
                int val = edge[1];
               

                dist[next] = Math.min(dist[next] , dist[curr]+val);
                pq.add(next);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<k+2;i++){
            min = Math.min(min , dist[i*n+dst]);
        }


        
        return (min==Integer.MAX_VALUE/4)? -1 : min;





    }
}
