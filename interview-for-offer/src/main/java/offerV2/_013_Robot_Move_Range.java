package offerV2;

import java.util.Arrays;

/**
 * @No          v2-013, v1-67
 * @problem     机器人的运动范围
 * @tag         数组、回溯法、DFS
 * @author      liyazhou1
 * @date        2020/02/02
 *
 * <pre>
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。
 * 但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。
 * 请问该机器人能够达到多少个格子?
 * </pre>
 */
public class _013_Robot_Move_Range {


    /**
     * Note
     *
     * Thought
     *      DFS
     *      回溯法
     *
     * Algorithm
     *      1.
     *      2.
     */
    private static class Solution {

        int[][] directs = {
                {0, -1},
                {0, 1},
                {-1, 0},
                {1, 0},
        };

        int count = 0;


        public int movingCount(int r, int c, int threshold) {
            int[][] matrix = initMatrix(r, c);
            boolean[][] marked = new boolean[r][c];
            backtracking(matrix, r, c, threshold, marked, 0, 0);
            return count;
        }


        private void backtracking(int[][] matrix, int r, int c, int threshold, boolean[][] marked, int i, int j) {
            if (i < 0 || i >= r || j < 0 || j >= c || marked[i][j] || matrix[i][j] > threshold) {
                return;
            }
            marked[i][j] = true;
            count ++;
            for (int[] direct : directs) {
                backtracking(matrix, r, c, threshold, marked, i+direct[0], j+direct[1]);
            }
        }


        private int[][] initMatrix(int r, int c) {

            int[] memory = new int[Math.max(r, c)];
            for (int k = 0; k < memory.length; k ++) {
                int n = k;
                while (n > 0) {
                    memory[k] += n % 10;
                    n /= 10;
                }
            }

            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i ++) {
                for (int j = 0; j < c; j ++) {
                    matrix[i][j] = memory[i] + memory[j];
                }
            }
            return matrix;
        }


        public static void main(String[] args) {

            int[][] usecases = {
                    {23, 32, 5},
            };

            for (int[] usecase : usecases) {
                int r = usecase[0];
                int c = usecase[1];
                int threshold = usecase[2];
                System.out.println(Arrays.toString(usecase));
                int result = new Solution().movingCount(r, c, threshold);
                System.out.println("result = " + result);
                System.out.println("------------");
            }
        }
    }
}
