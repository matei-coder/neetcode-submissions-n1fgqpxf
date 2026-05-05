class MedianFinder {
    PriorityQueue<Integer> low;  // max-heap: jumătatea mică
    PriorityQueue<Integer> high; // min-heap: jumătatea mare

    public MedianFinder() {
        low = new PriorityQueue<>(Comparator.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Adaugă în low, apoi mută vârful în high pentru a menține ordinea
        low.add(num);
        high.add(low.poll());

        // Reechilibrează: low poate avea cel mult un element în plus față de high
        if (high.size() > low.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        }
        return (low.peek() + high.peek()) / 2.0;
    }
}