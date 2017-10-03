package zzc.chun.zju.Learning.algorithm.list.linkedlist;


import org.w3c.dom.NodeList;

/**
 * Created by Captain on 2017/10/3.
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        super();
        this.val = val;
    }

    public static ListNode Reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        // head 置为null
        ListNode p, q, r;
        p = head;
        q = head.next;
        head.next = null;
        // r = head.next;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p; // 最后q必然指向NULL，所以返回P作为新的头指针
        return head;
    }

    public static ListNode Reverse1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmpNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmpNext;
        }
        return pre;
    }

    public static void main(String []args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        ListNode list = Reverse1(head);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
