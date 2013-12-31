/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		// null case
		if(head == null) return null;
		// two pointers, slower and faster should be two nodes apart
		ListNode slower = head;
		ListNode faster = head;
		for(int i = 0; i < n; i++){
			if(faster.next == null){
				faster = head;
			}else{
				faster = faster.next;
			}
		}
		// move slower and faster together;
		while(faster.next != null){
			faster = faster.next;
			slower = slower.next;
		}
		// new head;
		if(slower.next == null) return head;
		ListNode newhead = slower.next;
		slower.next = null;
		faster.next = head;
		return newhead;
	}
}
