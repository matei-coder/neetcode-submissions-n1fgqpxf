class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a);
    int k;
    ArrayList<Integer> temp;
    public KthLargest(int k, int[] nums) {
        for(int x :nums) pq.add(x);
        this.k =k;
        temp = new ArrayList<>();
        
    }
    
    public int add(int val) {
        pq.add(val);
        for(int i=0;i<k-1;i++){
            temp.add(pq.poll());
        }
        int ans =pq.peek();
        for(int i=0;i<k-1;i++){
            pq.add(temp.get(i));
        }
        temp.clear();
        return ans;
        

    }
}
