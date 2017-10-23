package zzc.chun.zju.Learning.algorithm.stack;

import java.util.Stack;

/**
 * Created by z81022404 on 2017/10/23.
 * 设计一个有getMin功能的栈
 *
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * pop, push, getMin操作的时间复杂度都是O(1);
 * 设计的栈类型可以使用现成的栈结构;
 */
public class P1_GetMinStack {
    public static class Mystack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public Mystack() {
            this.dataStack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }

        public void push(int num) {
            if (minStack.isEmpty()) {
                minStack.push(num);
            } else if (num < this.getMin()){
                minStack.push(num);
            }
            dataStack.push(num);
        }

        public int pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            int val = dataStack.pop();
            if (val == this.getMin()) {
                this.minStack.pop();
            }
            return val;
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Min stack is empty");
            }
            return this.minStack.peek();
        }
    }

    public static void main(String[] args) {
        Mystack stack = new Mystack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
