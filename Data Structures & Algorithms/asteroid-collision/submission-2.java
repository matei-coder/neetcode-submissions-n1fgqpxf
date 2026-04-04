class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a:asteroids){
            //System.out.println(stack);
            boolean destroyed = false;
while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
    if (Math.abs(stack.peek()) < Math.abs(a)) {
        stack.pop();
        continue; // Keep checking next in stack
    } else if (Math.abs(stack.peek()) == Math.abs(a)) {
        stack.pop();
    }
    destroyed = true;
    break;
}
if (!destroyed) stack.push(a);

        }
       int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;

    }
}