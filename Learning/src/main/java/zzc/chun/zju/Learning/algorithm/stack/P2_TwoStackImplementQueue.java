package zzc.chun.zju.Learning.algorithm.stack;

import java.util.Stack;

/**
 * Created by z81022404 on 2017/10/23.
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add,poll,peek）
 */
public class P2_TwoStackImplementQueue {
    public static class MyQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public MyQueue() {
            this.pushStack = new Stack<Integer>();
            this.popStack = new Stack<Integer>();
        }

        public void add(int val) {
            pushStack.push(val);
        }

        public int poll() {
            if (popStack.empty() && pushStack.empty()) {
                throw new RuntimeException("Queue is empty.");
            } else if (popStack.empty()) {
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        public int peek() {
            if (popStack.empty() && pushStack.empty()) {
                throw new RuntimeException("Queue is empty.");
            } else if (popStack.isEmpty()) {
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
