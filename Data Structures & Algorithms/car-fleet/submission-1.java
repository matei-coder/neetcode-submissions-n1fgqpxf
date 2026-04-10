class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;       
        Arrays.sort(idx, (a, b) -> position[b] - position[a]);

        Stack<Float> s = new Stack<>();

        for(int i: idx){
            float time =(float)(target-position[i])/(float)(speed[i]);
            if(s.isEmpty()||s.peek()<time){
                s.push(time);
            }
        }

        return s.size();



    }

   
}

