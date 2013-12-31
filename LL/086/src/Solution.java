/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
		
*/

public class Solution {
    public ListNode partition(ListNode head, int x) {
    	// list1 stores all nodes with value smaller than x;
    	ListNode head1 = new ListNode(0);
    	ListNode tail1 = head1;
    	// list2 stores all nodes with value geq than x;
    	ListNode head2 = new ListNode(0);
    	ListNode tail2 = head2;
    	// loop through the original list and group nodes to 2 lists;
    	ListNode running = head;
    	while(running != null){
    		if(running.val < x){
    			tail1.next = running;
    			tail1 = tail1.next;
    		}else{
    			tail2.next = running;
    			tail2 = tail2.next;
    		}
    		running = running.next;
    	}
    	// clear tails;
    	tail2.next = null;
    	// combine two lists;
    	// if first list is empty;
    	if(head1.next == null) return head2.next;
    	tail1.next = head2.next;
    	return head1.next;
    }
}
