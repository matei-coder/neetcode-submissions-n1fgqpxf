class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for(int[] x : trips) pq.add(x);
        PriorityQueue<Integer> cars = new PriorityQueue<>((a,b)->a-b);
        int x=pq.peek()[1];
        
        while(!pq.isEmpty()){
            while(!cars.isEmpty()&&cars.peek()==x){
                cars.poll();
            }
            while(!pq.isEmpty()&&pq.peek()[1]==x){
                if(pq.peek()[0]>capacity) {
                    return false;
                    }
                for(int i=0;i<pq.peek()[0];i++){
                    cars.add(pq.peek()[2]);
                }
                pq.poll();
            }
            if(cars.size()>capacity) return false;
            x++;
            
        }
        System.out.println(cars.size());
        return true;
    }
}