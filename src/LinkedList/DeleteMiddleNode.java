package LinkedList;
/**
 * method to delete middle node of a linked list. 
 * @author Anand
 *
 */
public class DeleteMiddleNode {
    public static class Node{
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    public static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false; // Failure
        } 
        //IMPORTANRT.
        Node next = n.next; 
        n.val = next.val; 
        n.next = next.next; 
        return true;
    }
    static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(13);
        start.next.next.next = new Node(14);
        start.next.next.next.next = new Node(15);
        start.next.next.next.next.next = new Node(16);
        start.next.next.next.next.next.next = new Node(17);
        deleteNode(start.next.next.next.next); // delete node 4
        printList(start);
    }
}
