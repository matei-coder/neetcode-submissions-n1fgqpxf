class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char x: s.toCharArray()){
            if(x=='['||x=='{'||x=='(') stack.push(x);
            else if(x==']'&&!stack.empty()&&stack.peek()=='[') stack.pop();
            else if(x=='}'&&!stack.empty()&&stack.peek()=='{') stack.pop();
            else if(x==')'&&!stack.empty()&&stack.peek()=='(') stack.pop();
            else{
                return false;
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}
