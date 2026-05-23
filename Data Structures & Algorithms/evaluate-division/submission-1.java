class Solution {
     Map<String , Node> map = new HashMap<>();
    class Edge{
        double val;
        String start;
        String end;
        Edge(String start , String end , double val){
            this.start = start ;
            this.end = end;
            this.val = val;
        }
    }
    class Node{
        List<Edge> edges;
        String val;
        Node(String val){
            this.val = val;
            this.edges = new ArrayList<>();
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       
        int idx =0;
        for(List<String> equation: equations){
            String a = equation.get(0);
            String b = equation.get(1);
            if(!map.containsKey(a)) map.put(a , new Node(a));
            if(!map.containsKey(b)) map.put(b , new Node(b));
            map.get(a).edges.add(new Edge(a , b , values[idx]));
            map.get(b).edges.add(new Edge(b , a , 1/values[idx++]));

        }




        int id =0;
        double[] ans = new double[queries.size()];
        for(List<String> query : queries){
            Node from = map.get(query.get(0));
            Node to = map.get(query.get(1));
            if(!map.containsKey(query.get(0))||!map.containsKey(query.get(1))) {
                ans[id++] = -1;
                continue;
            }
            ans[id++] = dfs(from , 1.0 , to , new HashSet<>());

        }

        return ans;
    }



    public double dfs(Node curr , double val , Node to , Set<Node> viz){
        viz.add(curr);
        if(curr == to) return val;
        for (Edge edge : curr.edges) {
    Node next = map.get(edge.end);
    if (!viz.contains(next)) {
        double res = dfs(next, val * edge.val, to, viz);
        if (res != -1.0) return res;   // doar dacă am găsit drum
    }
}
return -1.0;

        //return -1.0;
    }
}