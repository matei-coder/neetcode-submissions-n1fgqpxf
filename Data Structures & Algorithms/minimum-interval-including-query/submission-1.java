class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals , (a,b)-> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            return (a[1]-a[0])-(b[1]-b[0]);
        });

        int[][] nq = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            nq[i][0] = queries[i];
            nq[i][1] = i;
        }
        Arrays.sort(nq , (a,b)-> a[0]-b[0]);


        int[] ans = new int[queries.length];
        int dela =0;
        int panala=0;
        Set<int[]> sterse = new HashSet<>();
        for(int i = 0; i<queries.length;i++){
            
                while(panala<intervals.length&& nq[i][0]>=intervals[panala][0]){
                    pq.add(intervals[panala]);
                    sterse.add(intervals[panala]);
                    panala++;
                }
                while(dela<intervals.length&&intervals[dela][1]<nq[i][0]){
                    sterse.remove(intervals[dela]);
                    dela++;
                }
                while (!pq.isEmpty() && pq.peek()[1] < nq[i][0]) {
                    pq.poll();
                }
                ans[nq[i][1]] = pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
            

        }

        return ans;
    }
}
