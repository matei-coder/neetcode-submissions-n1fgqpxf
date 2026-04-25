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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode ans = dummy;
        int count = nrOfPartitions(head , k);
        for(int i=0;i<count;i++){
            ListNode headnext = headafterk(head ,k);
            dummy.next = reversefrom(head , k);
            
            int c=0;
            while(c<k&&dummy!=null){
                dummy = dummy.next;
                c++;
            }
            head = headnext;
            
        }
        dummy.next = head;
        return ans.next;
       
        

    }


    public ListNode reversefrom(ListNode head , int k){
        ListNode curr = head;
        ListNode prev = null;
        for(int i=0;i<k&&curr!=null;i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode headafterk(ListNode head , int k){
        ListNode temp=head;
        for(int i=0;i<k&&temp!=null;i++){
            temp = temp.next;
        }
        return temp;
    }
    public int nrOfPartitions(ListNode head , int k){
        ListNode temp = head;
        int c=0;
        while(temp!=null){
            temp = temp.next;
            c++;
        }
        return c/k;
        
        
    }
}
