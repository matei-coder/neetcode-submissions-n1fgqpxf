class Solution {
    public String decodeString(String s) {
            StringBuilder stb = new StringBuilder();
            Stack<String> stack = new Stack<>();
            Stack<Integer> stackdeInt = new Stack<>();
            //stackdeInt.push(1);
            String current="";
            int num=0;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                
                
                if(Character.isDigit(c)){
                    num=num*10+(int)(c-'0');
                }
                
                else if(c=='[') {  
                    stackdeInt.push(num);                   
                    stack.push(current);
                    num=0;
                    current="";
                }

                else if(c==']'){
                    String raspp = stack.pop();
                    int lim = stackdeInt.pop();
                    current = raspp + current.repeat(lim);
                }

                else{
                    current += s.charAt(i);
                }
                System.out.println(stack);
                
            }

            return current;
        
    }
}