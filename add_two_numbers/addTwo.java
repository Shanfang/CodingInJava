/*
Add Two Numbers
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.
*/


 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode (int x) {
        val = x;
          next = null;      
      }
 }
 
public class AddTwo {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
		 ListNode result = new ListNode(0);
		 int carrier = 0;
		 ListNode dummyNode = result;

		 while ((l1 != null) || (l2 != null)) {
		   	if (l1 != null) {
		 		carrier += l1.val;
		 		l1 = l1.next;
		 	}
		 	if (l2 != null) {
		 		carrier += l2.val;
		 		l2 = l2.next;
		 	}

		 	//deal with the summation
		 	result.next = new ListNode(carrier % 10);
		 	carrier = carrier / 10;
		 	result = result.next;
		 }

		 // check if there is a carrier for the last summation of two nodes
		 if (carrier == 1) {
		 	result.next = new ListNode(1);
		 }
		 return dummyNode.next;
    }

    public static void main(String args[]) {
    	ListNode list1 = new ListNode(1);
    	ListNode list2 = new ListNode(2);
    	AddTwo addTwo = new AddTwo();
    	System.out.println("Hello World!\nThe summation of the two list is: " + addTwo.addLists(list1, list2).val);
    }
}
