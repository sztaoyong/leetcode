public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head; // base case. no node or one node;
        
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = swapPairs(node2.next);
        node2.next = node1;
        node1.next = node3;
        return node2;
    }
}
