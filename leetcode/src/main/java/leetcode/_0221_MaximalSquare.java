package leetcode;

/**
 * @No          221
 * @problem     Maximal Square
 * @level       Medium
 * @desc        最大正方形
 * @author      liyazhou1
 * @date        2019/10/04
 *
 * <pre>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 * </pre>
 */
public class _0221_MaximalSquare {


    /**
     * Note
     *
     * Thought
     *      方法一，暴力法
     *          遍历以 matrix[i][j]为右下角元素、由'1'构成的正方形，求最大边长
     *          时间复杂度为 O((mn)^2)
     *
     *      方法二，动态规划
     *          dp[i+1][j+1] 表示以 matrix[i][j] 为右下角元素的正方形的最大边长
     *          若 matrix[i][j] == '1'，则 dp[i+1][j+1] 为其左上角、左侧、上面元素的最小值加1，
     *              即dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            // dp[i+1][j+1] 表示以 matrix[i][j]为右下角元素的正方形的最大边长
            int[][] dp = new int[matrix.length+1][matrix[0].length+1];

            int max = 0;
            for (int i = 1; i <= matrix.length; i ++) {
                for (int j = 1; j <= matrix[0].length; j ++) {
                    if (matrix[i-1][j-1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            return max * max;
        }

        public static void main(String[] args) {
            char[][] input = {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            };

            int maximalSquare = new Solution().maximalSquare(input);
            System.out.println("maximalSquare = " + maximalSquare);
        }

    }
}
