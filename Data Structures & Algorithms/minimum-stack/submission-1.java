class MinStack {
    Stack<Integer> stack = new Stack<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, Integer> deleted = new HashMap<>();

    public void push(int val) {
        stack.push(val);
        pq.offer(val);
    }

    public void pop() {
        int val = stack.pop();
        // incrementăm contorul pentru val
        deleted.put(val, deleted.getOrDefault(val, 0) + 1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        // curățăm vârful heap-ului de elemente "marcate ca șterse"
        while (deleted.getOrDefault(pq.peek(), 0) > 0) {
            int val = pq.poll();
            deleted.put(val, deleted.get(val) - 1); // consumăm o ștergere
        }
        return pq.peek();
    }
}