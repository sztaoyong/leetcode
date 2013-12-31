/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

*/

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// null case or base case;
		if(head == null || m == n) return head;
		
		// use pseudohead  to simplify code
		ListNode pseudohead = new ListNode(0);
		pseudohead.next = head;
		// split the list into three parts; reverse the middle part; and combine them back together;
		ListNode tail1 = pseudohead; // tail of first part;
		ListNode tail2 = pseudohead; // head of third list;
		
		for(int i = 1; i < m; i++){
			tail1 = tail1.next;
		}
		for(int i = 0; i < n; i++){
			tail2 = tail2.next;
		}
		ListNode head2 = tail1.next; 
		ListNode head3 = tail2.next;
		tail1.next = null;
		tail2.next = null;
		// reverse the middle part;
		ListNode newhead2 = head3;
		while(head2 != null){
			ListNode head2next = head2.next;
			head2.next = newhead2;
			newhead2 = head2;
			head2 = head2next;
		}
		tail1.next = newhead2;
		return pseudohead.next;
    }
}
