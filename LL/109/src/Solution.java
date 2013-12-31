/*
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.
*/

public class Solution {
//	analysis: major difference between this problem and 'convert sorted array to BST' is that
//	linked list has O(n) complexity for accessing a random list node. 
//	if we use the similar way as 'converted sorted array to BST', it will give an O(n^2) complexity
//	solution: build the BST dynamically, from left to right
	
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	int index = 0;
    	ListNode running = head;
    	while(running.next != null){ // find the index of the last node
    		running = running.next;
    		index++;
    	}
    	return sortedListToBST(head, 0, index);
    }
    
    public TreeNode sortedListToBST(ListNode head, int st, int en){
    	// base case and null case
    	if(st > en) return null;
    	if(st == en){
    		int val = head.val;
    		// delete current node;
    		if(head.next != null){
	    		head.val = head.next.val;
	    		head.next = head.next.next;
    		}
    		return new TreeNode(val);
    	}
    	
    	// recursion;
    	int mid = st + (en - st)/2;
    	TreeNode left = sortedListToBST(head, st, mid-1);
    	TreeNode root = new TreeNode(head.val);
    	// delete current node;
		if(head.next != null){
    		head.val = head.next.val;
    		head.next = head.next.next;
		}
		// right side;
    	TreeNode right = sortedListToBST(head, mid+1, en);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}