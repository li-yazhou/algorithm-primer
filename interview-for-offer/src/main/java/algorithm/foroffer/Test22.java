package algorithm.foroffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/27.
 * 面试题22：栈的压入、弹出序列
 *
 * 题目：
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *      假设压入栈的所有数字均不相等。
 *      例如序列 1、2、3、4、5 是某栈的压栈序列，序列 4、5、3、2、1 是该压栈序列对应的一个弹出序列，
 *      但 4、3、5、1、2 就不可能是该压栈序列的弹出序列。
 *
 * 问题：
 *      1. 使用辅助栈，
 *      2. 顺序压栈和有条件的出栈操作
 *
 * 思路：
 *      1. 两个序列存储在数组中，创建一个辅助栈（数据结构）
 *      2. 将压入序列的"第一个元素"依次压入到辅助栈中，（算法）
 *          如果辅助栈的栈顶元素和弹出序列的"第一个元素"相等，则从辅助栈弹出该元素；
 *          // 如果辅助栈为空，则继续压入压入序列中为入栈的元素；
 *      3. 辅助栈为空，该弹出序列是压入序列的出栈序列，返回 true；否则两者不匹配，返回 false。
 *         (如果辅助栈栈顶元素和弹出序列的"第一个元素"不相等，而且压入栈没有要压入辅助栈中的元素，返回 false)
 *
 *
 */
public class Test22 {

    public static boolean isPopOrder(int[] pushOrder, int[] popOrder){
        if (pushOrder == null || popOrder == null || pushOrder.length != popOrder.length) return false;

        boolean result = false;
        Stack<Integer> stack = new Stack<>();
        int popNum = 0;
        for (int i = 0; i < pushOrder.length; i++){  // 依次将压入序列中的元素压入到辅助栈
            stack.push(pushOrder[i]);
            // 从辅助栈中弹出和弹出序列中匹配的元素
            while (!stack.isEmpty() && stack.peek() == popOrder[popNum]){
                stack.pop();
                popNum ++;
            }
        }
        if (stack.isEmpty()) result = true;  // 压入序列和弹出序列中的所有的元素都匹配
        return result;
    }


    public static void main(String[] args){
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[][] popOrders = {
                {4, 5, 3, 2, 1},
                {4, 5, 3, 1, 2},
                {4, 5, 3, 1, 6},
        };
        for (int i = 0; i < popOrders.length; i++){
            System.out.print("压入序列：" + Arrays.toString(pushOrder) + "  ");
            System.out.print("弹出序列：" + Arrays.toString(popOrders[i]) + "  ");
            System.out.println(Test22.isPopOrder(pushOrder, popOrders[i]));
        }
    }
}
