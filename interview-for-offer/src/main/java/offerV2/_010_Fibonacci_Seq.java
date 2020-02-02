package offerV2;

/**
 * @No          v2-010,v1-009
 * @problem     斐波那契数列
 * @tag         递归、动态规划
 * @author      liyazhou1
 * @date        2017/5/24
 *
 * <pre>
 *      写一个函数，输入 n，求斐波那契 (Fibonacci)数列的第 n 项。斐波那契数列的定义如下：
 *          f(n) = 0,                   n = 0
 *          f(n) = 1,                   n = 1
 *          f(n) = f(n-1) + f(n-2),     n > 1
 * </pre>
 */
public class _010_Fibonacci_Seq {


    /**
     * Note
     *
     * Thought
     *      递归
     *
     * Algorithm
     *      1. 当 n = 0 或 1 时，返回 n
     *      2. 当 n > 1 时，返回前两项元素之和。使用循环实现
     */
    private static class Solution {

        public static int fibonacciUsingRecursion(int n){
            // 递归终止条件
            if (n < 2) return n;
            // 递归操作，不能改变状态变量的数值
            return fibonacciUsingRecursion(n-1) + fibonacciUsingRecursion(n-2);
        }

    }


    /**
     * Note
     *
     * Thought
     *      循环迭代
     *
     * Algorithm
     *      1. 当 n = 0 或 1 时，返回 n
     *      2. 当 n > 1 时，返回前两项元素之和。使用循环实现
     */
    private static class Solution2 {

        public static int fibonacci(int n){
            if (n < 0) throw new RuntimeException("Invalid input n");
            else if (n <=1 ) return n;

            int first = 0;
            int second = 1;
            int tmp = -1;
            for (int i = 1; i < n; i++){
                tmp = second;
                second = first + second;
                first = tmp;
            }
            return second;
        }

    }
}
