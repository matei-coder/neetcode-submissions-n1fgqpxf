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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sum = new ListNode( 0 );
        ListNode x = sum;
        int temp = 0;
        while(l1!=null&&l2!=null){
            if(l1.val+l2.val+temp<=9){
                sum.val = l1.val+l2.val+temp;
                temp=0;
            }
            else{
                sum.val = (l1.val+l2.val+temp)%10;
                temp = (l1.val+l2.val+temp)/10;
            }
            if((l1.next!=null||l2.next!=null)){
                sum.next = new ListNode(0);
            }else{
                if(temp!=0) sum.next = new ListNode(temp);
            }
            sum = sum.next;
            l1 = l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            if(l1.val+temp<=9){
                sum.val = l1.val+temp;
                temp=0;
            }
            else{
                sum.val = (l1.val+temp)%10;
                temp = (l1.val+temp)/10;
            }if(l1.next!=null){
                sum.next = new ListNode(0);
            }else{
                if(temp!=0) sum.next = new ListNode(temp);
            }
            sum = sum.next;
            l1 = l1.next;
        }
        while(l2!=null){
            if(l2.val+temp<=9){
                sum.val = l2.val+temp;
                temp=0;

            }
            else{
                sum.val = (l2.val+temp)%10;
                temp = (l2.val+temp)/10;
            }if(l2.next!=null){
                sum.next = new ListNode(0);
            }else{
                if(temp!=0) sum.next = new ListNode(temp);
            }
            sum = sum.next;
            l2 = l2.next;
        }

        return x;
    }
}
