package leetcode;

import java.util.LinkedList;

/**
 * @No          155
 * @problem     Min Stack
 * @level       Easy
 * @desc        最小栈
 * @author      liyazhou
 * @date        2017/08
 *
 * <pre>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * </pre>
 */
public class _0155_MinStack {


    /**
     * Note
     *
     * Thought
     *      方法一，暴力法
     *      方法二，双栈
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {
        class MinStack {

            LinkedList<Integer> stack = null;
            LinkedList<Integer> minStack = null;

            /** initialize your data structure here. */
            public MinStack() {
                stack = new LinkedList<>();
                minStack = new LinkedList<>();
            }

            public void push(int x) {
                stack.push(x);
                if (minStack.isEmpty()) {
                    minStack.push(x);
                } else {
                    int min = minStack.peek();
                    if (min > x) {
                        min = x;
                    }
                    minStack.push(min);
                }
            }

            public void pop() {
                if (stack.isEmpty()) {
                    throw new RuntimeException("stack is empty, pop is illegal.");
                }
                minStack.pop();
                stack.pop();
            }

            public int top() {
                if (stack.isEmpty()) {
                    throw new RuntimeException("stack is empty, top is illegal.");
                }
                return stack.peek();
            }

            public int getMin() {
                if (minStack.isEmpty()) {
                    throw new RuntimeException("stack is empty, getMin is illegal.");
                }
                return minStack.peek();
            }
        }
    }


    private static class Solution1 {
        class MinStack {

            private LinkedList<Integer> dataStack = null;
            private LinkedList<Integer> minStack = null;

            /** initialize your data structure here. */
            public MinStack() {
                dataStack = new LinkedList<>();
                minStack = new LinkedList<>();
            }

            public void push(int x) {
                dataStack.push(x);
                if (minStack.isEmpty()) minStack.push(x);
                else                    minStack.push(Math.min(minStack.peek(), x));
            }

            public void pop() {
                if(!minStack.isEmpty()) minStack.pop();
                if(!dataStack.isEmpty()) dataStack.pop();
            }

            public int top() {
                return dataStack.peek();
            }

            public int getMin() {
                return minStack.peek();
            }
        }
    }
}
