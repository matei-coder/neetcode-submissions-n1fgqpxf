            class MyCircularQueue {
                int[] queue ;
                int first, last;
                int k;
                public MyCircularQueue(int k) {
                    queue = new int[k];
                    for(int i=0;i<k;i++) queue[i] = -1;
                    first=0;
                    last=0;
                    this.k = k;
                }
                
                public boolean enQueue(int value) {
                    
                    if(queue[(last)%k] == -1){
                        queue[last] = value;
                        last = (last + 1) % k;          
                        
                        return true;
                    }
                    else{
                        return false;


                }

            
                }
                
                public boolean deQueue() {
                    
                    if( queue[first%k] != -1){
                        queue[first] = -1;
                        first = (first+1)%k;
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                
                public int Front() {
                    return queue[first%k];
                }
                
                public int Rear() {
                    return queue[(last - 1 +k) % k];
                }
                
                public boolean isEmpty() {
                    return queue[first] == -1;
                }
                
                public boolean isFull() {
                    return queue[last] != -1; 
                }
            }


            /**
            * Your MyCircularQueue object will be instantiated and called as such:
            * MyCircularQueue obj = new MyCircularQueue(k);
            * boolean param_1 = obj.enQueue(value);
            * boolean param_2 = obj.deQueue();
            * int param_3 = obj.Front();
            * int param_4 = obj.Rear();
            * boolean param_5 = obj.isEmpty();
            * boolean param_6 = obj.isFull();
            */