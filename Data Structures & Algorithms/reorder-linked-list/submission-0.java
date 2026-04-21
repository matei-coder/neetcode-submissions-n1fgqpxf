class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        int c = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            c++;
        }

        // inverseaza de la slow
        ListNode inverted = null;
        while (slow != null) {
            ListNode temp = slow.next;  // ✅ fix
            slow.next = inverted;
            inverted = slow;
            slow = temp;
        }

        ListNode copy = head;
        for (int i = 0; i < c; i++) {
            ListNode nextInv = inverted.next;
            ListNode nextCopy = copy.next;

            head.next = inverted;
            inverted.next = nextCopy;

            if (nextCopy == null) break;

            head = nextCopy;
            inverted = nextInv;
            copy = nextCopy;
        }

        if (head != null) head.next = null;
    }
}