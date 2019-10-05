package leetcode;

/**
 * @No          240
 * @problem     Search a 2D Matrix II
 * @level       Medium
 * @desc        搜索二维矩阵 II
 * @author      liyazhou1
 * @date        2019/10/05
 *
 * <pre>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 * </pre>
 */
public class _0240_SearchA2DMatrixII {


    /**
     * Note
     *
     * Thought
     *      方法一、暴力法，时间复杂度为 O(m*n)；
     *      方法二、沿着对角线遍历，M[i][i] 是左上角最的元素，该方法需要特别处理 m > n 和 m < n 的情况；
     *      方法三、二维数组的行指针、列指针，双指针，时间复杂度是 O(m+n)；
     *
     * Challenge
     *
     * Algorithm
     *      方法三，行列指针
     *      1. 行、列指针的初始值分别为 m-1、0，即R = m - 1，C = 0；
     *      2. while (R >= 0 && C < n)
     *              比较 M[R][C] 与 T 的大小
     *                  若 M[R][C] == T 则返回 true
     *                  若 M[R][C] > T 则 R --
     *                  若 M[R][C] < T 则 C ++
     *      3. 返回 false，表示在二维数组中没有找到目标元素
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int R = matrix.length - 1;
            int C = 0;
            while (R >= 0 && C < matrix[0].length) {
                int curr = matrix[R][C];
                if (curr > target) {
                    R --;
                } else if (curr < target){
                    C ++;
                } else {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            int[][] input = {
                    {1,   4,  7, 11, 15},
                    {2,   5,  8, 12, 19},
                    {3,   6,  9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
            };

            int[] targets =  {5, 20};
            for (int target: targets) {
                boolean result = new Solution().searchMatrix(input, target);
                System.out.println("result = " + result);
            }
        }
    }
}
