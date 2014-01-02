public class Solution {
    	public ListNode reverseKGroup(ListNode head, int k) {
	    
	        // reverse first k elements;
	        ListNode tail = findNode(head,k);
	        // base case: if there are less than kth elements;
	        if(tail == null) return head;
	        // recursion
	        ListNode nextList = reverseKGroup(tail.next,k);
	        // reverse first k elements;
	        ListNode newHead = nextList;
	        ListNode running = head;
	        tail.next  = null;
	        while(running != null){
	        	ListNode runningNext = running.next;
	        	running.next = newHead;
	        	newHead = running;
	        	running = runningNext;
	        }
	        return newHead;
	    }
	    
	    public ListNode findNode(ListNode head, int k){
	        int i = 1;
	        while(i < k){
	            if(head == null) return null;
	            head = head.next;
	            i++;
	        }
	        return head;
	    }
}