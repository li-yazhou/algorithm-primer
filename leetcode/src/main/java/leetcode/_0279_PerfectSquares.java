package leetcode;

/**
 * @No          279
 * @problem     Perfect Squares
 * @level       Medium
 * @desc        完全平方数
 * @author      liyazhou1
 * @date        2019/10/05
 *
 * <pre>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * </pre>
 */
public class _0279_PerfectSquares {


    /**
     * Note
     *
     * Thought
     *      回溯法
     *                     13
     *                 /    |    \
     *               12     9     4
     *             / | \  / | \  / \
     *            11 8 3 8  5 0 3  0
     *           /|\
     *           ……
     *
     *      求二叉树的最小深度，它的最大深度等于n。
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

        public int numSquares(int n) {
            int[] memo = new int[n+1];  // 默认初始化为0
            for (int i = 1; i <= n; i ++ ) {
                memo[i] = i;  // 最坏的情况是每次 +1
                for (int j = 1; j * j <= i; j ++) {
                    memo[i] = Math.min(memo[i - j * j] + 1, memo[i]);   // 动态转移方程
                }
            }
            return memo[n];
        }

        public static void main(String[] args) {

//            for (int i = 1; i < 20; i ++) {
//                System.out.println("input = " + i);
//                int num = new Solution().numSquares(i);
//                System.out.println("num = " + num);
//                System.out.println("---------------------");
//            }

            int[] inputs = {
                    63
            };
            for (int input: inputs) {
                System.out.println("input = " + input);
                int num = new Solution().numSquares(input);
                System.out.println("num = " + num);
                System.out.println("---------------------");
            }

        }
    }


    /**
     * Note
     *
     * Thought
     *      回溯法
     *                     13
     *                 /    |    \
     *               12     9     4
     *             / | \  / | \  / \
     *            11 8 3 8  5 0 3  0
     *           /|\
     *           ……
     *
     *      求二叉树的最小深度，它的最大深度等于n。
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
    private static class Solution2 {

        public int numSquares(int n) {
            int[] memo = new int[n+1];
            int result = numSquares(n, memo);
            // System.out.println("memo = " + Arrays.toString(memo));
            return result;
        }


        private int numSquares(int n, int[] memo) {
            if (memo[n] != 0) {
                return memo[n];
            }

            int sqrt = (int) Math.sqrt(n);
            if (sqrt * sqrt == n) {
                memo[n] = 1;
                return memo[n];
            }

            int depth = Integer.MAX_VALUE;
            for (int i = 1; i * i < n; i ++) {
                depth = Math.min(depth, numSquares(n - i * i, memo) + 1);
            }

            memo[n] = depth;

            return memo[n];
        }


        public static void main(String[] args) {

//            for (int i = 1; i < 20; i ++) {
//                System.out.println("input = " + i);
//                int num = new Solution().numSquares(i);
//                System.out.println("num = " + num);
//                System.out.println("---------------------");
//            }

            int[] inputs = {
                    63
            };
            for (int input: inputs) {
                System.out.println("input = " + input);
                int num = new Solution2().numSquares(input);
                System.out.println("num = " + num);
                System.out.println("---------------------");
            }

        }
    }


    /**
     * Note
     *
     * Thought
     *      回溯法
     *                     13
     *                 /    |    \
     *               12     9     4
     *             / | \  / | \  / \
     *            11 8 3 8  5 0 3  0
     *           /|\
     *           ……
     *
     *      求二叉树的最小深度，它的最大深度等于n。
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
    private static class Solution1 {

        public int numSquares(int n) {

            int sqrt = (int) Math.sqrt(n);
            if (sqrt * sqrt == n) {
                return 1;
            }

            int depth = Integer.MAX_VALUE;
            for (int i = 1; i * i < n; i ++) {
                depth = Math.min(numSquares(n - i * i) + 1, depth);
            }

            return depth;
        }


        /**
         * 拉格朗日四平方和定理
         * 任何正整数均是完全平方数，它们都可以表示为4个以内的整数的平方和。
         */
        public boolean isSquaresSum(int n) {
            System.out.println(n);
            if (n < 0) {
                return false;
            }

            int sqrt = (int) Math.sqrt(n);
            if (sqrt * sqrt == n) {
                return true;
            }

            for (int i = 1; i * i < n; i ++) {
                if (isSquaresSum(n - i * i)) {
                    return true;
                }
            }
            return false;
        }


        public static void main(String[] args) {

            for (int i = 1; i < 20; i ++) {
                System.out.println("input = " + i);
                int num = new Solution1().numSquares(i);
                System.out.println("num = " + num);
                System.out.println("---------------------");
            }

            int[] inputs = {
                    63
            };
            for (int input: inputs) {
                System.out.println("input = " + input);
                int num = new Solution1().numSquares(input);
                System.out.println("num = " + num);
                System.out.println("---------------------");
            }

        }
    }
}
