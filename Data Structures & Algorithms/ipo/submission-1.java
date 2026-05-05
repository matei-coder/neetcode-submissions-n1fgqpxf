class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //PriorityQueue<Integer> capitalpq = new PriorityQueue<>((a,b)->capital[a]-capital[b]);
        int viz[] = new int [profits.length];
        PriorityQueue<Integer> profitpq = new PriorityQueue<>((a,b)->profits[b]-profits[a]);
        while(k>0){
            profitpq.clear();
            for(int i=0;i<profits.length;i++){
                if(capital[i]<=w&&viz[i]==0){
                    profitpq.add(i);
                }
            }
            if(profitpq.isEmpty()) return w;
            System.out.println(profitpq.peek()+" ");
            viz[profitpq.peek()]=1;
            w += profits[profitpq.peek()];
            k--;
            
        }

        return w;


    }
}