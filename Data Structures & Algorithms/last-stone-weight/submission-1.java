class Solution {
   
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int x: stones) pq.add(x);
        while(pq.size()>1){
            int curr=pq.poll();
            if(curr==pq.peek()) pq.poll();
            else{
                int dif = pq.poll();
                pq.add(curr-dif);
            }
        }
        if(!pq.isEmpty())
        return pq.poll();
        else return 0;
    }
}
