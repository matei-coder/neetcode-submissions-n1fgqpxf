class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a:asteroids){
            //System.out.println(stack);
            if(a<0){
                boolean destroyed=false;
                while((!stack.empty())&&stack.peek()>0){
                    if(stack.peek()<(-1)*a)
                        stack.pop();
                    else if(stack.peek()==(-1)*a){
                        stack.pop();
                        destroyed=true;
                        break;
                    }
                    else{
                        destroyed=true;
                        break;
                    }
                }
                if(!destroyed) stack.push(a);
            }
            else 
            {
                stack.push(a);
            }



        }
       int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;

    }
}