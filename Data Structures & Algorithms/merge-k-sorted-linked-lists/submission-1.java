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
        if(lists==null||lists.length==0) return null;
        int c=1;
        ListNode listaactuala = lists[0];
        while(c<lists.length){
            listaactuala = mergeLists(listaactuala , lists[c]);
            c++;
        }
        return listaactuala;
    }


    public ListNode mergeLists(ListNode a , ListNode b){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(a!=null&&b!=null){
            if(a.val>b.val){
                curr.next = b;
                b=b.next;              
            }
            else{
                curr.next = a;
                a=a.next;
            }
            curr = curr.next;
        }
        while(a!=null){
            curr.next = a;
            a = a.next;
            curr = curr.next;
        }
        while(b!=null){
            curr.next = b;
            b = b.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
