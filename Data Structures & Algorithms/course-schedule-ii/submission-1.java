class Solution {
    class Node{
        List<Node> next;
        int val;
        Node(List<Node> next , int val){
            this.next = next;
            this.val = val;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for(int[] x:prerequisites){
            adj.get(x[1]).add(x[0]);
            indegree[x[0]]++;
        }
        

         int[] result = new int[numCourses];
         int idx = 0;


        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            result[idx++] = curr;
            for (int next : adj.get(curr)) {
                indegree[next]--;            
                if (indegree[next] == 0) q.add(next);
            }     
        }

        if(idx!=numCourses) return new int[0];
        return result;    

    }
}
