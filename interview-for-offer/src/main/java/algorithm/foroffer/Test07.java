package algorithm.foroffer;

import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/24.
 * 面试题7：用两个栈实现队列
 * 题目：
 *      用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
 *      分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 *
 * 思路：
 *      1. 当在"队列"尾部插入结点时，把队列（子队列）的元素压入 A 栈
 *      2. 当删除"队列"的首部元素时，检查 B 栈是否为空，
 *              如果为空，将 A 栈中的元素弹出并依次压入B栈，此时 B 栈存储的就是子队列，可以访问该子队列的首部元素
 *              如果不为空，则 B 栈中已经存储子队列，可以访问子队列的首部元素
 */
public class Test07 {

    class MQueue<T>{
        // 压入栈，存储添加的数据
        private Stack<T> pushStack = new Stack<>();
        // 弹出栈，存储子队列
        private Stack<T> popStack = new Stack<>();

        public MQueue(){ }
        public MQueue(T[] args){
            for (T str: args)
                pushStack.push(str);
        }

        public void appendTail(T element){
            pushStack.push(element);
        }

        public T deleteHead(){
            // 子队列为空时，再次创建子队列
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    T popElement = pushStack.pop();
                    popStack.push(popElement);
                }
            }
            // String retval = this.popStack.isEmpty() ? null: this.popStack.pop();
            if (popStack.isEmpty()) throw new RuntimeException("Queue is empty, no more element.");
            return popStack.pop();
        }
    }

    public void test1(){
        MQueue<String> queue = new MQueue<>();
        String[] strs = new String[2];
        for (int i = 0; i < strs.length; i++)
            strs[i] = "" + i;
        queue.appendTail(strs[0]);
        queue.appendTail(strs[1]);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        // System.out.println(queue.deleteHead());
    }

    public void test2(){

        String[] strs = new String[2];
        for (int i = 0; i < strs.length; i++)
            strs[i] = "" + i;
        MQueue<String> queue = new MQueue<>(strs);
        queue.appendTail("xxxx");
        // queue.appendTail("yyyy");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    public static void main(String[] args){
        Test07 test = new Test07();
        test.test1();
        test.test2();
    }
}
