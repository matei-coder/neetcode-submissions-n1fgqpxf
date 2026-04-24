/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode ans = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val-b.val);
        boolean toatesnull = true;
        for(ListNode list: lists){
            queue.add(list);
        }
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            dummy.next =  node;
            dummy = dummy.next;
            
            if(node.next != null){
                node =node.next;
                queue.add(node);
            }
        }

        return ans.next;
    }
}
