package zzc.chun.zju.Learning.algorithm.list.linkedlist;

/**
 * Created by chun on 17-10-30.
 * 单向链表和双向链表删除倒数第K个节点
 */
public class LastK {
    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            lastKth--;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void printNode(Node head) {
        System.out.print("Linked list: ");
        while (head!=null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode node = head;
        while (node != null) {
            node = node.next;
            lastKth--;
        }
        if (lastKth == 0) {
            head.next.last = null;
            head = head.next;
        }
        if (lastKth < 0) {
            node = head;
            while (++lastKth != 0) {
                node = node.next;
            }
            DoubleNode newNext = head.next.next;
            head.next = newNext;
            if (newNext != null) {
                newNext.last = head;
            }
        }
        return head;
    }

    public static void printDoubleList(DoubleNode head) {
        System.out.print("Double Linked list: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print(" | ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] main) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        printNode(head);
        //Node n = new LastK().removeLastKthNode(head, 7);
        Node n = new LastK().removeLastKthNode(head, 3);
        // Node n = new LastK().removeLastKthNode(head, 9);
        printNode(n);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        head2.next.next.next.next = new DoubleNode(5);
        head2.next.next.next.next.last = head2.next.next.next;
        head2.next.next.next.next.next = new DoubleNode(6);
        head2.next.next.next.next.next.last = head2.next.next.next.next;
        printDoubleList(head2);
        //head2 = new LastK().removeLastKthNode(head2, 3);
        // head2 = new LastK().removeLastKthNode(head2, 6);
        head2 = new LastK().removeLastKthNode(head2, 7);
        printDoubleList(head2);
    }
}
