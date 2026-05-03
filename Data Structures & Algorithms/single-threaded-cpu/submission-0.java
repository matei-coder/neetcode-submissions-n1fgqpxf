class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        int index=0;
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; 
               
            } else {
                 return a[2] - b[2];
                
            }
        });
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1]; 
            }
        });


       
        for(int i=0;i<tasks.length;i++){
            p.add(new int[]{tasks[i][0] , tasks[i][1] , i});
        }
        int timp = p.peek()[0];

        while(!p.isEmpty() || !pq.isEmpty()){
            while(!p.isEmpty()&&p.peek()[0]<=timp){
                pq.add(p.poll());
            }
            int processtime=-1;
            if(!pq.isEmpty()){
                int[] elem = pq.poll();
                ans[index++] = elem[2];
                processtime=elem[1];
            }
            if(processtime==-1)
            timp++;
            else{
                timp+=processtime;
            }
        }

        return ans;
        
    }
}