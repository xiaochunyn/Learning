package zzc.chun.zju.Learning.algorithm.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Captain on 2017/10/15.
 * 分别用递归和非递归的方式实现二叉树先序、中序、后序遍历
 * eg:
 *                    5
 *
 *
 */
public class Tree {
    public static class Node {
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
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序递归
    public void inOrderRecur(Node head) {
        if (head != null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    // 后序递归
    public void postOrderRecur(Node head) {
        if (head != null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
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
                System.out.print(head.value + " ");
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
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    /**
     * Breadth First Search 广度优先搜索，从根节点开始沿着树的宽度搜索遍历
     * 广度优先利用队列先进先去的特点，左子树先入队，然后右子树入队
     */
    public void breadFirstSearch(Node head) {
        if (head == null) {
            return;
        }

        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node tree = queue.poll();
            System.out.print(tree.value + " ");
            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
        }
    }

    /**
     * Depth First Search 深度优先搜索，沿着树的深度遍历树的节点，经可能深的搜索树
     * 的分支.　深度优先搜索二叉树是先访问根节点，然后遍历左子树接着遍历右子树．因此，
     * 可以利用栈的先进后出的特点，先将右子树入栈，然后将左子树入栈，这样左子数就位于栈顶，
     * 可以保证左子树先于右子树遍历．
     */
    public void depthFirstSearch(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.value + " ");
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("====================recursive=======================");
        System.out.println("pre-order: ");
        new Tree().preOrderRecur(head);
        new Tree().preOrderUnRecur(head);
        System.out.println();

        System.out.println("in-order: ");
        new Tree().inOrderRecur(head);
        new Tree().inOrderUnRecur(head);
        System.out.println();

        System.out.println("pos-order: ");
        new Tree().postOrderRecur(head);
        System.out.println();

        System.out.println("Breadth First Search: ");
        new Tree().breadFirstSearch(head);
        System.out.println();

        System.out.println("Depth First Search: ");
        new Tree().depthFirstSearch(head);

        System.out.println();
    }
}
