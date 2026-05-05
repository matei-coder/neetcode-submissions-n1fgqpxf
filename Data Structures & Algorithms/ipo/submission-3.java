class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> capitalpq = new PriorityQueue<>((a,b)->capital[a]-capital[b]);
        for(int i=0;i<capital.length;i++) capitalpq.add(i);
        //int viz[] = new int [profits.length];
        PriorityQueue<Integer> profitpq = new PriorityQueue<>((a,b)->profits[b]-profits[a]);
        while(k>0){
            while(!capitalpq.isEmpty()&&capital[capitalpq.peek()]<=w){
                profitpq.add(capitalpq.poll());
            }
            //System.out.println(profitpq);
            
            
            if(profitpq.isEmpty()) return w;
            //System.out.println(profitpq.peek());
            w += profits[profitpq.poll()];
            k--;
            
        }

        return w;


    }
}