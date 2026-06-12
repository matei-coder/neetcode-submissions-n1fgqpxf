class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0] - b[0];
        });

        List<int[]> ans = new ArrayList<>();

        for(int[] inte : intervals){
            pq.add(inte);
        }

        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int maxim = curr[1];
            

            
            while(!pq.isEmpty()&&maxim>=pq.peek()[0]){
                maxim = Math.max(maxim , pq.poll()[1]);
            }
            ans.add(new int[]{curr[0] , maxim });
        }

        return ans.toArray(new int[0][]);



    }
}
