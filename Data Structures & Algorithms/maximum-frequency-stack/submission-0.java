class FreqStack {
    Map<Integer, Tuple> map = new HashMap<>();
    Map<Integer, Stack<Integer>> mapdepoz = new HashMap<>();
    TreeSet<Tuple> set = new TreeSet<>((a, b) -> {
        if(a.freq != b.freq)
            return a.freq - b.freq;  
        return mapdepoz.get(a.val).peek() - mapdepoz.get(b.val).peek();      
    });
    int poz;

    public FreqStack() {
        poz = 0;
    }
    
    public void push(int val) {
        mapdepoz.putIfAbsent(val, new Stack<>());
        if(map.containsKey(val)){
            int prez = map.get(val).freq;
            set.remove(new Tuple(val, prez));
            map.put(val, new Tuple(val, prez + 1));
            mapdepoz.get(val).push(poz++);
            set.add(new Tuple(val, prez + 1));
        } else {
            map.put(val, new Tuple(val, 1));
            mapdepoz.get(val).push(poz++);
            set.add(new Tuple(val, 1));
        }
    }
    
    public int pop() {
        Tuple deremove = set.pollLast();
        int prez = deremove.freq;
        mapdepoz.get(deremove.val).pop(); // ✅ restaurezi poziția anterioară
        if(prez == 1){
            map.remove(deremove.val);
        } else {
            map.put(deremove.val, new Tuple(deremove.val, prez - 1));
            set.add(new Tuple(deremove.val, prez - 1));
        }
        return deremove.val;
    }
}
class Tuple {
    int val;
    int freq;

    Tuple(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

