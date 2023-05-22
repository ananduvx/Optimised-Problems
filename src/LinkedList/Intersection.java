package LinkedList;

public class Intersection {
    // Defining two node head1 and head2 as static variable.
    static Node head1, head2;

//creating Node class for singly linked list.
    // 2nd approach is by using hashset
    public static class Node {
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    public int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;
        if (c1 > c2) {
            d = c1 - c2;
            return _getIntesectionNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return _getIntesectionNode(d, head2, head1);
        }
    }
    private int _getIntesectionNode(int d, Node head12, Node head22) {
        Node current1 = head12;
        Node current2 = head22;
        for (int i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.val == current2.val) {
                return current1.val;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return -1;
    }

    private int getCount(Node head12) {
        Node current = head12;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int getIntersectionNode(int d, Node n1, Node n2) {

        return 0;

    }

    public static void main(String[] args) {
        Intersection list = new Intersection();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);
        System.out.println("The node of intersection is " + list.getNode());
    }
}
