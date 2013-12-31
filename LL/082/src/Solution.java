/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.*/
		
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode ans = new ListNode(0); // ans will build the new linked list
		ListNode anscopy = ans; // anscopy.next points to the head of new linked list
		ListNode running = head;
		while(running != null){
			if(running.next == null || running.val != running.next.val){// if unique
				ans.next = running;
				ans = ans.next;
				running = running.next;
			}else{
				int repVal = running.val;	// skip all nodes with repeated value
				while(running != null && running.val == repVal){
					running = running.next;
				}
			}
		}
		ans.next = null;
		return anscopy.next;
    }
}
