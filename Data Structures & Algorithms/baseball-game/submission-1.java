class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int tine;
        s.push(Integer.parseInt(operations[0]));
        for(int i=1;i<operations.length;i++){
            if(operations[i].equals("C")) {
                s.pop();
                if(!s2.isEmpty())s2.pop();
                }
            else if(operations[i].equals("D")){
                
                s2.push(s.peek());
                s.push(2*s.peek());
            }
            else if(operations[i].equals("+")){
                int a = s2.peek();
                s2.push(s.peek());
                s.push(a+s.peek());
            }
            else {
                //int a = s.top();
                if(!s.empty())s2.push(s.peek());
                s.push(Integer.parseInt(operations[i]));
            }
            
        }
        int sum=0;
        while(!s.empty()){
            sum+=s.pop();
        }

        return sum;

    }
}