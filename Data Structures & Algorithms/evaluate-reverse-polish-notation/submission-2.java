class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String c:tokens){
            if(c.equals("+")) s.push(s.pop()+s.pop());
            else if(c.equals("-")) s.push((-1)*(s.pop()-s.pop()));
            else if(c.equals("*")) s.push(s.pop()*s.pop());
            else if(c.equals("/")) {
                int a = s.pop();
                s.push((s.pop()/a));
                }
            else s.push(Integer.parseInt(c));



        }
        return s.pop();
    }
}
