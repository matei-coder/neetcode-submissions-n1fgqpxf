class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int i=0;
 



        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                return Integer.compare(a[1] , b[1]);
        });
        for(int[] inter : intervals){
            pq.add(inter);
        }
        int ans=0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            while(!pq.isEmpty()&& curr[1]>pq.peek()[0]){
                pq.poll();
                ans++;
            }
        }

        return ans;
    }
}
