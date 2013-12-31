/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode running = head;
		while(running != null){
			if(running.next == null || running.val != running.next.val){ 
				running = running.next;
			}else{	// delete the next node if it is a repeated node;
				running.next = running.next.next;
			}
		}
		return head;
    }
}
