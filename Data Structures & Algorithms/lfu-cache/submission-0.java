

class LFUCache {
    class Node {
        int key, val, freq;
        Node next, prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1; // Brand new nodes always start with frequency 1
        }
    }

    class SentinelBucket {
        Node first;      
        Node last;
        int size; // Tracking size makes it easy to know when a bucket is empty

        SentinelBucket() {
            first = new Node(0, 0);  
            last = new Node(0, 0);
            first.next = last;
            last.prev = first;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = first.next;
            node.prev = first;
            first.next.prev = node;
            first.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, SentinelBucket> maptosentinel = new HashMap<>(); 
    int capacity;
    int minFreq = 0; 

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        touch(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return; // Edge case: zero capacity caches store nothing

        if (map.containsKey(key)) {
            // 1. Key exists: Update value and touch it
            Node node = map.get(key);
            node.val = value;
            touch(node);
        } else {
            // 2. Capacity reached: Evict the LFU node
            if (map.size() == capacity) {
                removeLast();
            }

            // 3. Insert brand new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            
            minFreq = 1; // A new item resets the minimum frequency to 1
            
            // Ensure bucket 1 exists, then add the new node
            maptosentinel.putIfAbsent(1, new SentinelBucket());
            maptosentinel.get(1).addFirst(newNode);
        }
    }

    public void touch(Node node) {
        int currentFreq = node.freq;
        SentinelBucket bucket = maptosentinel.get(currentFreq);
        
        // Remove from current frequency bucket
        bucket.remove(node);

        // If we just emptied the bucket representing the minimum frequency, increment minFreq
        if (currentFreq == minFreq && bucket.size == 0) {
            minFreq++;
        }

        // Increase node's frequency and move it to the new bucket
        node.freq++;
        maptosentinel.putIfAbsent(node.freq, new SentinelBucket());
        maptosentinel.get(node.freq).addFirst(node);
    }
    
    public void removeLast() {
        SentinelBucket minBucket = maptosentinel.get(minFreq);
        Node nodeToRemove = minBucket.last.prev;
        
        // Remove from the doubly linked list
        minBucket.remove(nodeToRemove);
        
        // CRITICAL: Remove from the primary cache map so it is fully evicted
        map.remove(nodeToRemove.key); 
    }
}