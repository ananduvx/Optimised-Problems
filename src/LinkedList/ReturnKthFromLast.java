package LinkedList;



/**
 * Method to return kth from last in singly linked list. 
 * two pointer approach p1 and p2. 
 * will let iterate p1 till k if it reaches k p will be p.next.
 * then will iterate p2 from head until p1 is not equals to null by using while loop. 
 * 
 * T.c == O(n) ... Space O(1).
 * @author Anand
 *
 */
public class ReturnKthFromLast {
    static class node {
        int val;
        node next;
        public node(int val) { this.val = val; }
    }
    public static node nthToLast(node head, int k) {
        node p1 = head;
        node p2 = head;
        
        /* Move p1 k nodes into the list.*/
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }
        
        /* Move them at the same pace. When p1 hits the end, 
         * p2 will be at the right element. */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
    static void printList(node head)
    {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
        node start = new node(10);
        start.next = new node(12);
        start.next.next = new node(13);
        start.next.next.next = new node(14);
        start.next.next.next.next = new node(15);
        start.next.next.next.next.next = new node(16);
        start.next.next.next.next.next.next = new node(17);
            node node = nthToLast(start, 3);
            printList(node);
            
    }
}
