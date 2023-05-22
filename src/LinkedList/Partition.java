package LinkedList;

/**
 * method to partition all the elements such that all the left elements are less than that 
 * and all right ones are grater than that.
 * @author Anand
 * 
 * Array shifts and swappings are expensive. 
 * this solution is not 100% 
 */
public class Partition {
    public static class Node{
    Node next;
    int val;
    public Node(int val) {
     this.val = val;   
    }
    }
    public static Node partition(Node node, int x) {
        Node head = node;
        Node tail = node;
        
        /* Partition list */
        while (node != null) {
            Node next = node.next;
            if (node.val < x) {
                /* Insert node at head. */
                node.next = head;
                head = node;
            } else {
                /* Insert node at tail. */
                tail.next = node;
                tail = node;
            }   
            node = next;
        }
        tail.next = null;
        
        return head;
    }
    static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        /* Start with the empty list */
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(50);
        int x = 4;
        head = partition(head, x);
        printList(head);
    }
    }            
