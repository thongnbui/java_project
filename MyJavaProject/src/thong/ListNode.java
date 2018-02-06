package thong;


public class ListNode {
    int val;
    ListNode next = null;
   public ListNode(int x) { val = x; }
   
   void appendListNode(ListNode ln) {
       ListNode current = this;
       while (current.next != null) {
           current = current.next;
       }
       current.next = ln;
   }
   void printListNode() {
       ListNode current = this;
       System.out.print(current.val + " ");
/**       if (current.next != null) {
    	   current.next.printListNode();
       }
*/
       while (current.next != null) {
           current = current.next;
           System.out.print(current.val + " ");
       }
       System.out.println();
    
   }
}
