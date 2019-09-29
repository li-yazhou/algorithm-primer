package leetcode;

import java.util.Arrays;

/**
 * @No          64
 * @problem     Minimum Path Sum
 * @level       Medium
 * @desc        最小路径和
 * @author      liyazhou1
 * @date        2019/09/29
 *
 * <pre>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 *
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * </pre>
 */
public class _0064_MinimumPathSum {


    /**
     * Note
     *      note
     *
     * Thought
     *      一维动态规划
     *      若可以修改原数组，则不需要额外的空间
     *
     * Challenge
     *      边界控制
     *
     * Algorithm
     *      1. 一维数组dp保存第i行位置的最小权重；
     *      2. 遍历2到m-1行元素，求解当前行各个位置的最小权重，当前位置的最小权重等于左边元素和上边元素之和，更新到一维数组；
     *      3. dp[n-1] 即是解。
     *
     * Complexity
     *      Time, O(m*n)
     *      Space, min(O(m), O(n))
     *
     * Rank
     *      Runtime,
     *      Memory Usage,
     *
     */
    private static class Solution {

        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            int row = grid.length;
            int column = grid[0].length;
            int[] dp = Arrays.copyOf(grid[0], grid[0].length);

            // 第一行元素的权重，等于左侧元素的权重 + 当前元素的值
            for (int k = 1; k < dp.length; k ++) {
                dp[k] += dp[k-1];
            }
            // System.out.println("dp = " + Arrays.toString(dp));
            for (int i = 1; i < row; i ++) {
                for (int j = 0; j < column; j ++) {
                    if (j == 0) {
                        // 第一列元素的权重，等于上面元素的权重 + 当前元素的值
                        dp[j] = dp[j] + grid[i][j];
                    } else {
                        // 非0行0列的元素的权重，等于min(左侧元素的权重, 上面元素的权重) + 当前元素的权重
                        dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                    }
                }
                // System.out.println("dp = " + Arrays.toString(dp));
            }

            return dp[column-1];
        }

        public static void main(String[] args) {
            int[][][] inputs = {
                    {
                            {1, 3, 1},
                            {1, 5, 1},
                            {4, 2, 1}
                    }
            };

            for (int[][] input: inputs) {
                System.out.println("input = " + Arrays.deepToString(input));
                int result = new Solution().minPathSum(input);
                System.out.println("result = " + result);
            }
        }
    }
}
