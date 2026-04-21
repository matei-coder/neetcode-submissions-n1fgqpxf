/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Map<Node , Node> map = new HashMap<>();
        Node nou = new Node(head.val);
        Node copienou = nou;
        Node rasp =nou;
        Node copy = head;

        while(head!=null){
            map.put(head , nou);
            head=head.next;           
            if(head!=null){
            nou.next = new Node(head.val);
            nou=nou.next;
            }
            else{
                nou.next=null;
            }
        } 
        while(copy!=null){
            copienou.random = map.get(copy.random);
            copienou = copienou.next;
            copy = copy.next;
        }

        return rasp;
        
    }
}
