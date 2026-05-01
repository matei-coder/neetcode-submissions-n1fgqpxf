class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> b.nrDeElem - a.nrDeElem);
        Queue<Tuple> q = new LinkedList<>();
        for(char x : tasks){
            freq[x - 'A']++;
        }
        for(int x:freq){
            if(x>0) pq.add(new Tuple(x , 0));
        }
        int c=0;
        while(!pq.isEmpty()||!q.isEmpty()){

            while(!q.isEmpty()&&q.peek().candmaiarevoie<=c){
                pq.add(q.poll());
            }
            if(!pq.isEmpty()){
                if(pq.peek().nrDeElem-1>0)
                    q.add(new Tuple(pq.poll().nrDeElem-1 , c+n+1));
                else{
                    pq.poll();
                }
                
            }
            c++;
            

        }

        return c;

    }

    class Tuple{
        int nrDeElem;
        int candmaiarevoie;
        

        Tuple(int nrDeElem , int candmaiarevoie){
            this.nrDeElem = nrDeElem;
            this.candmaiarevoie = candmaiarevoie;
        }
    }
}
