import java.util.ArrayList;

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // solution1: iterative;
        ListNode pseudohead = new ListNode(-1);
        ListNode running = pseudohead;
        
        while(true){
            // go through the list of nodes find the minimum one;
            ListNode minNode = null;
            int min = Integer.MAX_VALUE;
            for(ListNode head: lists){
                if(head != null && head.val < min){
                    minNode = head;
                    min = head.val;
                }
            }
            if(minNode == null) break; // have run through all heads;
            lists.set(lists.indexOf(minNode), minNode.next);
            running.next = minNode;
            running = running.next;
        }
        return pseudohead.next;
    }
    
    public ListNode mergeKListsRecur(ArrayList<ListNode> lists){
    	// solution1: recursion;        
        // go through the list of nodes find the minimum one;
        ListNode minNode = null;
        int min = Integer.MAX_VALUE;
        for(ListNode head: lists){
            if(head != null && head.val < min){
                minNode = head;
                min = head.val;
            }
        }
        // base case;
        if(minNode == null) return null;
        // recursion;
        lists.set(lists.indexOf(minNode), minNode.next);
        minNode.next = mergeKListsRecur(lists);
        return minNode;
    }
    
    public static void main(String[] args){
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	n1.next  = n2;
    	ListNode n3 = new ListNode(1);
    	ArrayList<ListNode> lists = new ArrayList<ListNode>();
    	lists.add(n1); lists.add(n3); lists.add(null);
    	ListNode result = new Solution().mergeKListsRecur(lists);
    	while(result != null) {
    		System.out.print(result.val + " -> ");
    		result = result.next;
    	}
    }
}