    class LRUCache {
        
        class ListNode{
            ListNode prev , next;
            int val , key;

            ListNode( int val , int key){
                this.val = val;
                this.key = key;
            }

        }

        ListNode first , last;
        Map<Integer , ListNode> map;
        int capacity;
        int nrOfElements=0;


        public LRUCache(int capacity) {
            first = new ListNode(0 , 0);
            last = new ListNode(0 , 0);
            first.next = last;
            first.prev = null;
            last.next=null;
            last.prev = first;
            map = new HashMap<>();
            this.capacity = capacity;
        }
        
        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            else{
                ListNode node = map.get(key);
                this.remove(node);
                insertLast(node);
                return node.val;
            }
        }
        
        public void put(int key, int value) {
            if(!map.containsKey(key)){
                ListNode node =new ListNode(value , key);
                map.put(key , node);
                if(nrOfElements<capacity){
                    insertLast(node);
                    nrOfElements++;
                }
                else{
                    map.remove(first.next.key);
                    remove(first.next);
                    insertLast(node);
                }
            }
            else{
                ListNode node = map.get(key);
                node.val = value;
                this.remove(node);
                insertLast(node);

            }
                
                
            
            
        }

        public void remove(ListNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void insertLast(ListNode node){
            last.prev.next = node;
            node.prev = last.prev;
            last.prev = node;
            node.next = last;
            
        }
    }
