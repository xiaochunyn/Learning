package zzc.chun.zju.Learning.algorithm.tree;

import java.util.Stack;

/**
 * Created by Captain on 2017/10/15.
 * 分别用递归和非递归的方式实现二叉树先序、中序、后序遍历
 * eg:
 *                    5
 *
 *
 */
public class Tree {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    // 先序递归
    public void preOrderRecur(Node head) {
        if (head != null) {
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序递归
    public void inOrderRecur(Node head) {
        if (head != null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    // 后序递归
    public void postOrderRecur(Node head) {
        if (head != null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    /**
    用递归方法解决的问题，都能用非递归的方式来实现。这时因为递归方法无非就是
    利用函数栈来保存信息，如果自己申请的数据结构来代替函数栈，也可以实现同样的功能。

     用非递归方式实现二叉树的先序遍历，具体过程如下：
     1. 申请一个新的栈stack,然后将head压入栈
     2. 从stack中弹出栈顶元素，记为cur,然后打印cur节点的值，再将cur的右孩子
        （不空的话）先压入栈，最后将cur的左孩子（不空的话）压入栈
     3. 重复步骤2，直到stack为空，全部过程结束
    */
    public void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) {
                    stack.add(head.right);
                }
                if (head.left != null) {
                    stack.add(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归中序遍历
     * 1. 申请一个栈stack，初始时，另变量cur=head
     * 2. 先把cur压入栈，对以cur节点为头的整棵子树来说，依次把左边界压入栈中，
     *    即不停的另cur=cur.left,然后重复步骤2
     * 3. 不断重复步骤2，直到发现cur为空，此时从stack中弹出一个节点，记为node，
     *    打印node的值，并且让cur=node.right,然后重复步骤2
     *
     * Note: 如果cur不空，cur=cur.left
     *       如果cur为空，出栈，输出，cur=cur.right
     */
    public void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value + " ");
                head = head.right;
            }
        }
    }

}
