class StockSpanner {
    

    Stack<Integer> stackdepret;
    Stack<Integer> stackdezile;
    boolean farapop;

    public StockSpanner() {
        stackdepret = new Stack<Integer>();
        stackdezile = new Stack<Integer>();

    }
    
    public int next(int price) {
        farapop=false;
        int sumadestack=1;
        while(!stackdepret.isEmpty()&&price>=stackdepret.peek()){
            stackdepret.pop();
            sumadestack+=stackdezile.pop();
            farapop=true;

        }
        stackdepret.push(price);
        if(!farapop) stackdezile.push(1);
        else stackdezile.push(sumadestack);
        return stackdezile.peek();

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */