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
    public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    int c = 1;
    ListNode lefthead = head;
    while (c < left) {
        lefthead = lefthead.next;
        c++;
    }

    c = 1;
    ListNode righthead = head;
    while (c < right) {
        righthead = righthead.next;
        c++;
    }

    ListNode afterRight = righthead.next;
    ListNode curr = lefthead;
    ListNode prev = null;
    while (curr != afterRight) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    ListNode cop = dummy;
    while (cop.next != lefthead) {
        cop = cop.next;
    }
    cop.next = prev;
    lefthead.next = afterRight;

    return dummy.next;
}
}