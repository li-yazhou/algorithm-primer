package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/24.
 * 面试题9：斐波那契数列
 * 题目一：
 *      写一个函数，输入 n，求斐波那契 (Fibonacci)数列的第 n 项。斐波那契数列的定义如下：
 *          f(n) = 0,                   n = 0
 *          f(n) = 1,                   n = 1
 *          f(n) = f(n-1) + f(n-2),     n > 1
 *
 * 思路：
 *      1. 当 n = 0 或 1 时，返回 n
 *      2. 当 n > 1 时，返回前两项元素之和。使用循环实现
 *
 *
 * 题目二：
 *      一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。
 *      求该青蛙跳上一个 n 级台阶总共有多少种跳发。
 *
 * 思路：
 *      1. 本质就是斐波那契数列，使用递归思想解题
 *      2. 如果只有 1 级台阶，结果只有一种跳法；
 *         如果只有 2 级台阶，结果有两种跳法；
 *         如果台阶阶数为n，n 大于 2时，第一次跳有两种不同的选择，
 *         一是先跳一级台阶，则总的跳法数目为后面 n-1 级台阶的跳法数目；
 *         二是先跳二级台阶，则总的跳法数目为后面 n-2 级台阶的跳法数目
 */
public class Test09 {

    public static int fibonacciUsingRecursion(int n){
        // 递归终止条件
        if (n < 2) return n;
        // 递归操作，不能改变状态变量的数值
        return fibonacciUsingRecursion(n-1) + fibonacciUsingRecursion(n-2);
    }

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

    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.println(String.format("fibonacci(%d) = %d", i, Test09.fibonacci(i)));
            System.out.println(String.format("fibonacci(%d) = %d", i, Test09.fibonacciUsingRecursion(i)));
        }
    }
}
