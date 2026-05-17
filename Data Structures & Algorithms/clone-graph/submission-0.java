/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node , Node> map = new HashMap<>(); 
        Set<Node> viz1 = new HashSet<>();
        Set<Node> viz2 = new HashSet<>();

        dfs(node , viz1 , map);
        copy(node , viz2 , map);

        return map.get(node);  



        
    }
    public void dfs(Node node , Set<Node> viz , Map<Node , Node> map){
        if(viz.contains(node)) return ;
        viz.add(node);
        map.put(node , new Node( node.val));
        for(Node next : node.neighbors){
            dfs(next , viz , map);
        }
    }

    public void copy(Node node , Set<Node> viz , Map<Node , Node> map){
        if(viz.contains(node)) return;
        viz.add(node);
        Node copie = map.get(node);
        for(Node vecin: node.neighbors)
            copie.neighbors.add(map.get(vecin));
        
        for(Node next : node.neighbors){
            copy(next , viz , map);
        }
    }

}