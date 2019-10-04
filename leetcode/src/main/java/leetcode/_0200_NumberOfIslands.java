package leetcode;

import java.util.Arrays;

/**
 * @No          200
 * @problem     Number of Islands
 * @level       Medium
 * @desc        岛屿数量
 * @author      liyazhou1
 * @date        2019/10/01
 *
 * <pre>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 * </pre>
 */
public class _0200_NumberOfIslands {


    /**
     * Note
     *
     * Thought
     *      递归 + 标记
     *
     * Challenge
     *      递归
     *
     * Algorithm
     *      1. 遍历二维数组中的每一个元素
     *              若当前元素是'1'
     *                  将计数器加1
     *                  以该元素为入口DFS二维数组
     *                      若下标超出边界或者当前元素值为 '0'，则退出DFS
     *                      将当前元素设置为已访问过，即元素值置为 '0'
     *                      向当前元素的四个方向DFS
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int numIslands(char[][] grid) {
            int count = 0;
            if (grid == null || grid.length == 0) {
                return count;
            }

            int r = grid.length;
            int c = grid[0].length;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfsMarking(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfsMarking(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfsMarking(grid, i - 1, j);
            dfsMarking(grid, i + 1, j);
            dfsMarking(grid, i, j - 1);
            dfsMarking(grid, i, j + 1);
        }


        private static void printMatrix(char[][] matrix) {
            for (char[] line: matrix) {
                System.out.println(Arrays.toString(line));
            }
            System.out.println();
        }

        public static void main(String[] args) {
            char[][][] inputs = {
                    {
                            {'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '0'}
                    },
                    {
                            {'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}
                    }
            };

            for (char[][] input: inputs) {
                printMatrix(input);
                int count = new Solution().numIslands(input);
                System.out.println("count = " + count);
                System.out.println("---------------------");
            }
        }
    }
}
