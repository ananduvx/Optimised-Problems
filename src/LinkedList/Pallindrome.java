package LinkedList;

import java.util.Stack;

/**
 * Method to check if a linked list is pallindrome or not.
 * using stack to check
 * T.c and S.c is O(n).
 * @author Anand
 *
 */
public class Pallindrome {
   public static class Node {
        int val;
        Node next;
        Node(int d)
        {
            this.val = d;
        }
    }

        static boolean isPalindrome(Node head)
        {
            Node slow = head;
            boolean ispalin = true;
            Stack<Integer> stack = new Stack<Integer>();
            while (slow != null) {
                stack.push(slow.val);
                slow = slow.next;
            }
            while (head != null) {
                int i = stack.pop();
                //will check if the from last is same as in the first then will return true.
                if (head.val == i) {
                    ispalin = true;
                }
                else {
                    ispalin = false;
                    break;
                }
                head = head.next;
            }
            return ispalin;
        }
        public static void main(String args[])
        {
            Node start = new Node(10);
            start.next = new Node(12);
            start.next.next = new Node(13);
            start.next.next.next = new Node(14);
            start.next.next.next.next = new Node(13);
            start.next.next.next.next.next = new Node(12);
            start.next.next.next.next.next.next = new Node(10);
            boolean condition = isPalindrome(start);
            System.out.println("isPalidrome :" + condition);            
        }
    }
