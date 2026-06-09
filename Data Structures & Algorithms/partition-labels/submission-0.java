class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] maxminoflett = new int[27][2];
        for(int[] lett : maxminoflett){
            lett[0] = Integer.MAX_VALUE;
            lett[1] = Integer.MIN_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0]-b[0];
        });
        for(int i=0;i<s.length();i++){
            int ix = s.charAt(i)-'a';
            maxminoflett[ix][0] = Math.min(maxminoflett[ix][0] , i);
            maxminoflett[ix][1] = Math.max(maxminoflett[ix][1] , i);
        }

        for(int[] x : maxminoflett){
            //System.out.println(x[0]+" "+x[1]);
            if(x[0]!=Integer.MAX_VALUE)
            pq.add(x);
        }

        // while(!pq.isEmpty()){

        //     System.out.println(pq.peek()[0] + " "+ pq.poll()[1]);
        // }

        
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int furthest = pq.poll()[1];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0]<furthest){
                furthest = Math.max(furthest , curr[1]);
            }
            else{
                ans.add(furthest - start +1);
                start = curr[0];
                furthest = curr[1];
            }
        }
        ans.add(furthest-start+1);


        return ans;

        
    }
}
