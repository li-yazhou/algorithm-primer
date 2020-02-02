package offerV2;

import java.util.Arrays;

/**
 * @No          v2-012, v1-66
 * @problem     矩阵中的路径
 * @tag         数组、回溯法、DFS
 * @author      liyazhou1
 * @date        2020/02/02
 *
 * <pre>
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以
 * 在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如下面的矩阵包含了一条 bfce 路径。
 *                     {'a', 'b', 't', 'g'},
 *                     {'c', 'f', 'c', 's'},
 *                     {'j', 'd', 'e', 'h'},
 * </pre>
 */
public class _012_Path_In_Matrix {


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

        public boolean hasPath(char[][] matrix, char[] target) {
            int r = matrix.length;
            int c = matrix[0].length;

            boolean[][] marked = new boolean[r][c];
            for (int i = 0; i < r; i ++) {
                for (int j = 0; j < c; j ++) {
                    if (backtracking(matrix, target,0, marked, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }


        private boolean backtracking(char[][] matrix, char[] target, int matchedLen, boolean[][] marked, int r, int c) {

            if (matchedLen == target.length) {
                return true;
            }
            if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length
                    || marked[r][c]
                    || matrix[r][c] != target[matchedLen]
            ) {
                return false;
            }

            marked[r][c] = true;
            for (int[] direct : directs) {
                if (backtracking(matrix, target, matchedLen+1, marked, r+direct[0], c+direct[1])) {
                    return true;
                }
            }
            marked[r][c] = false;
            return false;
        }

        public static void main(String[] args) {
            char[][] matrix = {
                    {'a', 'b', 't', 'g'},
                    {'c', 'f', 'c', 's'},
                    {'j', 'd', 'e', 'h'},
            };
            char[][] usecases = {
                    {'b', 'f', 'c', 'e'},
                    {'b', 'f', 'c', 'd'},
            };

            for (char[] usecase : usecases) {
                System.out.println(Arrays.toString(usecase));
                boolean result = new Solution().hasPath(matrix, usecase);
                System.out.println("result = " + result);
                System.out.println("------------");
            }
        }
    }
}
