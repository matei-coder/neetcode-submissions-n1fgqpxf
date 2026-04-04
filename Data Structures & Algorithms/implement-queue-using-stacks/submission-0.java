class MyQueue {
    Stack<Integer> normal;
    Stack<Integer> out;

    public MyQueue() {
        normal = new Stack<>();
        out = new Stack<>();

    }
    
    public void push(int x) {
        normal.push(x);
    }
    
    public int pop() {
        if(!out.empty()){
            return out.pop();
        }
        else{
            while(!normal.empty())
                out.push(normal.pop());
            return out.pop();
        }
        
    }
    
    public int peek() {
        if(!out.empty()){
            return out.peek();
        }
        else{
            while(!normal.empty())
                out.push(normal.pop());
           return out.peek();
        }
    }
    
    public boolean empty() {
        return normal.empty()&&out.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */