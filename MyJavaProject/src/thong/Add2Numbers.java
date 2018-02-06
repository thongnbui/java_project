package thong;

/** 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

https://leetcode.com/problems/add-two-numbers/description/

 * @author thongbui
 *
 */


public class Add2Numbers {

	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode n1 = l1;
        ListNode n2 = l2;
        int carryNumber = 0;
        ListNode current = null;
        while (n1 != null || n2 != null) {
            int sum = (n1 == null ? 0 : n1.val) + (n2 == null ? 0 : n2.val) + carryNumber;
            
            if (sum >= 10) {
                carryNumber = sum/10;
            }
            else {
                carryNumber = 0;
            }
                
            if (result == null) {
                result = new ListNode(sum % 10);
                current = result;
            }
            else {
                current.next = new ListNode(sum %10);
                current = current.next;
            }
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        
        if (carryNumber > 0) {
            current.next = new ListNode(carryNumber);
        }
        
        return result;
   }
   
   public static final void main(String[] args) {
	   ListNode l1 = new ListNode(2);
	   l1.appendListNode(new ListNode(4));
	   l1.appendListNode(new ListNode(3));
	   l1.printListNode();
	   ListNode l2 = new ListNode(5);
	   l2.appendListNode(new ListNode(6));
	   l2.appendListNode(new ListNode(4));
	   l2.printListNode();
	   
	   ListNode l3 = new ListNode(2);
	   l3.appendListNode(new ListNode(4));
	   l3.printListNode();

	   ListNode l4 = new ListNode(9);
	   l4.printListNode();



	   ListNode result = addTwoNumbers(l1, l2);
	   result.printListNode();
	   
	   addTwoNumbers(l3, l2).printListNode();

	   addTwoNumbers(l3, l4).printListNode();

   }


}
