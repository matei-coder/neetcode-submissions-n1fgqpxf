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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ans = head;
        while(head.next!=null){
            insertAfter(head , gcd(head.val , head.next.val));
            head =  head.next.next;
        }
        return ans;

    }


    public void insertAfter(ListNode head , int val){
        ListNode next = head.next;
        head.next = new ListNode(val , next);
    }


    public int gcd(int a , int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return Math.abs(a);
    }
}