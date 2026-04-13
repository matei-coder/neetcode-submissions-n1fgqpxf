class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Tuple> stack = new Stack<>();
        int maxArea = 0;
        stack.push(new Tuple(0, heights[0]));

        for (int i = 1; i < heights.length; i++) {
            Tuple removed = new Tuple(i, heights[i]);
            while (!stack.isEmpty() && heights[i] <= stack.peek().height) {
                removed = stack.pop();
                maxArea = Math.max(maxArea, removed.height * (i - removed.poz));
            }
            stack.push(new Tuple(removed.poz, heights[i]));
        }

        // procesează ce a rămas în stack
        while (!stack.isEmpty()) {
            Tuple t = stack.pop();
            maxArea = Math.max(maxArea, t.height * (heights.length - t.poz));
        }

        return maxArea;
    }
}

class Tuple{
    int poz , height;
    Tuple(int poz , int height){
        this.height = height;
        this.poz = poz;
    }


}
