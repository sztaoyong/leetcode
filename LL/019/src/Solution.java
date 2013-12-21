public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // pseudo-head, in case we need to remove the first node;
        ListNode pseudohead = new ListNode(-1);
        pseudohead.next = head;
        // two pointers n spots away from each other
        ListNode slow = pseudohead;
        ListNode fast = pseudohead;
        int i = 0;
        while(i < n){
            fast = fast.next;
            i++;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return pseudohead.next;
    }
}