class Solution {

    boolean ans = true;
    class Node{
        List<Node> vecini = new ArrayList<>();
        int val;

        Node(int val){
            this.val = val;
        }
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer , Node > harta = new HashMap<>();
        for(int[] course: prerequisites){
            int a = course[0];
            int b = course[1];
            if(!harta.containsKey(a)) harta.put(a , new Node(a));
            if(!harta.containsKey(b)) harta.put(b , new Node(b));
            harta.get(a).vecini.add(harta.get(b));
        }
        for(int x : harta.keySet()){
            Set<Node> viz = new HashSet<>();
            dfs(harta.get(x) , viz);
            if(!ans) return ans;
            viz.clear();         
        }



        return ans;



    }




    public void dfs(Node start , Set<Node> viz){    
        if(viz.contains(start)) ans = false;
        if(!ans) return;
        viz.add(start);

        for(Node vecin : start.vecini){
            dfs(vecin , viz);
        }

        viz.remove(start);

    }
}
