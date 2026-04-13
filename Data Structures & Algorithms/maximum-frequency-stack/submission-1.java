class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> map;
    int maxFreq = 0;

    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int frequency = freq.get(val);

        if (frequency > maxFreq) {
            maxFreq = frequency;
        }

        // Creează stack-ul dacă nu există pentru acest nivel de frecvență
        map.computeIfAbsent(frequency, k -> new Stack<>()).push(val);
    }

    public int pop() {
        int popped = map.get(maxFreq).pop();
        freq.put(popped, freq.get(popped) - 1);  // ⚠️ update freq la pop
        if (map.get(maxFreq).isEmpty()) maxFreq--;
        return popped;
    }
}