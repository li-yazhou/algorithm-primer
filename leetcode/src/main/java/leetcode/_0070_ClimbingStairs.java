package leetcode;

/**
 * @No          70
 * @problem     Climbing Stairs
 * @level       Easy
 * @desc        爬楼梯
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 */
public class _0070_ClimbingStairs {


    /**
     * Note
     *
     * Thought
     *      递归
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

        public int climbStairs(int n) {
            int first = 1;
            int second = 1;
            int third = 2;

            if (n == 0 || n == 1) {
                return 1;
            }

            while (n > 0) {
                first = second;
                second = third;
                third = first + second;
                n --;
            }
            return first;
        }

        /*
        public int climbStairs(int n) {
            if (n == 0 || n == 1 || n == 2) {
                return n;
            } else {
                return climbStairs(n-1) + climbStairs(n-2);
            }
        }
        */

        // public int climbStairs(int n) {
        //     if (n <= 2) return n;
        //     return climbStairs(n-1) + climbStairs(n-2);
        // }



        public int climbStairs0(int n) {
            if (n <= 2) return n;

            int result = 0;

            int first = 1;
            int second = 2;
            for (int i = 3; i <= n; i ++) {
                result = first + second;

                int temp = first;
                first = second;
                second = second + temp;

            }
            return result;
        }
    }
}
