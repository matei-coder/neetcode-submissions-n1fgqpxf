class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int x : nums) add(x);
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll(); // scoate minimul dacă depășim k elemente
        return pq.peek();             // minimul din heap = al k-lea cel mai mare
    }
}