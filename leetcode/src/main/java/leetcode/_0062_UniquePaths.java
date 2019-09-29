package leetcode;

import java.util.Arrays;

/**
 * @No          62
 * @problem     Unique Paths
 * @level       Medium
 * @desc        不同路径
 * @author      liyazhou1
 * @date        2019/09/29
 *
 * <pre>
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 *
 * </pre>
 */
public class _0062_UniquePaths {


    /**
     * Note
     *
     * Thought
     *      一维数组
     *
     * Challenge
     *      边界控制
     *
     * Algorithm
     *      1. 一维数组array保存第i行位置的不同路径数，初始化为1；
     *      2. 遍历2到m-1行元素，求解当前行各个位置的不同的路径数，当前位置的路径等于左边元素和上边元素之和，更新到一维数组；
     *      3. array[n-1] 即是解。
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

        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) {
                return 0;
            }

            int[] array = new int[n];
            Arrays.fill(array, 1);
            for (int i = 1; i < m; i ++) {
                for (int j = 1; j < array.length; j ++) {
                    array[j] = array[j-1] + array[j];
                }
            }

            return array[n-1];
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {3, 2},
                    {7, 3}
            };

            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int result = new Solution().uniquePaths(input[0], input[1]);
                System.out.println("result = " + result);
                System.out.println("---------------------------");
            }
        }

    }


    /**
     * Note
     *
     * Thought
     *      二维数组
     *
     * Challenge
     *      边界控制
     *
     * Algorithm
     *      1. 初始化"数组"的第0行、第0列，它们的值均为1；
     *      2. 非第0行且非第0列的元素均等于它左边和上边元素的之和；
     *      3. 第m-1行第n-1列的元素即是解
     *
     * Complexity
     *      Time, O(m*n)
     *      Space, O(m*n)
     *
     * Rank
     *      Runtime, 100.00%
     *      Memory Usage, 13.92%
     *
     */
    private static class Solution1 {

        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) {
                return 0;
            }

            int[][] matrix = new int[m][n];
            Arrays.fill(matrix[0], 1);
            for (int k = 0; k < matrix.length; k ++) {
                matrix[k][0] = 1;
            }

            for (int i = 1; i < matrix.length; i ++) {
                for (int j = 1; j < matrix[0].length; j ++) {
                    matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
                }
            }

            return matrix[m-1][n-1];
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {3, 2},
                    {7, 3}
            };

            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int result = new Solution1().uniquePaths(input[0], input[1]);
                System.out.println("result = " + result);
                System.out.println("---------------------------");
            }
        }

    }
}
