package offerV2;

import java.util.Stack;

/**
 * @No          v2-030,v1-021
 * @problem     包含 min 函数的栈
 * @tag         栈
 * @author      liyazhou1
 * @date        2017/5/27
 *
 * <pre>
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数，
 *      在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * </pre>
 */
public class _030_Stack_With_Min_Value {


    /**
     * Note
     *
     * Thought
     *      1. 栈的特性
     *      2. 求栈中的最小元素
     *
     * Algorithm
     *      1. 使用索引栈
     *      2. 每次添加新元素时，在辅助栈中保存当前数据栈中的最小元素的位置
     */
    private static class Solution {
        Stack<Integer> dataStack;   // 数据栈，保存压入的数据
        Stack<Integer> minStack;    // 最小栈（也可以使用索引栈，该位置保存与数据栈的相同位置到栈底之间的最小元素的位置）

        public void push(Integer element){
            dataStack.push(element);

            if (!minStack.isEmpty()) {
                minStack.push(element);
            } else {
                minStack.push(Math.min(minStack.peek(), element));
            }
        }

        public Integer pop(){
            if (dataStack.isEmpty()) throw new RuntimeException("The stack is already null.");
            minStack.pop();
            return dataStack.pop();
        }

        public Integer min(){
            if (dataStack.isEmpty()) throw new RuntimeException("The stack is already null.");
            return dataStack.get(minStack.peek());
        }
    }
}
