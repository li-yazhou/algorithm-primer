package offerV2;

import java.util.Stack;

/**
 * @No          v2-009,v1-007
 * @problem     用两个栈实现队列
 * @tag         栈与队列
 * @author      liyazhou1
 * @date        2017/5/24
 *
 * <pre>
 *  用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
 *  分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * </pre>
 */
public class _009_2Stack_As_Queue {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 当在"队列"尾部插入结点时，把队列（子队列）的元素压入 A 栈
     *      2. 当删除"队列"的首部元素时，检查 B 栈是否为空，
     *              如果为空，将 A 栈中的元素弹出并依次压入B栈，此时 B 栈存储的就是子队列，可以访问该子队列的首部元素
     *              如果不为空，则 B 栈中已经存储子队列，可以访问子队列的首部元素
     */
    private static class Solution {

        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();


        public void push(Integer element) {
            in.push(element);
        }


        public Integer pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            if (out.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }

            return out.pop();
        }
    }
}
