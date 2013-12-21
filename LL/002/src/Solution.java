public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        return addTwoNumbers(l1,l2,0);
	    }
	    
        // recursion
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry){
	    	// base case;
	        if(l1 == null && l2 == null && carry == 0) return null;
	        
	        // recursion;
	        int sum = carry;
	        if(l1 != null) sum += l1.val;
	        if(l2 != null) sum += l2.val;
	        ListNode thisDigit = new ListNode(sum%10);
	        
	        // compute next digit
	        int newCarry = sum/10;
	        ListNode newl1 = (l1 == null)?null:l1.next;
	        ListNode newl2 = (l2 == null)?null:l2.next;
	        ListNode nextDigit = addTwoNumbers(newl1, newl2, newCarry);
	        
	        // concatenate next digit
	        thisDigit.next = nextDigit;
	        return thisDigit;
	    }
}