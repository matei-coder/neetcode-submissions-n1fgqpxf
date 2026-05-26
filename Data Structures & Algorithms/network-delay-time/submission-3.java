class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = Integer.MAX_VALUE/4;
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dist[i] , inf);
        for(int i=0;i<times.length;i++){
                dist[times[i][0]-1][times[i][1]-1] = times[i][2];
        }
        k--;

        int[] dur = new int[n];
        Arrays.fill(dur , inf);
        dur[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1] - b[1];
        });
        pq.add(new int[]{ k , 0});
        boolean[] viz = new boolean[n];
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            
            dur[node] = Math.min(time , dur[node]);
            if(viz[node]) continue;
            viz[node] = true;
            for(int i=0;i<n;i++){
                if(dist[node][i]!=inf){
                    pq.add(new int[]{i , time + dist[node][i]});
                }
            }
            
        }

     
        
        int rasp = 0;
        for(int x: dur){
            if(x==inf) return -1;
            rasp = Math.max(rasp , x);
        }


        return rasp;
    }
}
