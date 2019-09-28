package leetcode;

import java.util.Arrays;

/**
 * @No          48
 * @problem     Rotate Image
 * @level       Medium
 * @desc        旋转图像
 * @author      liyazhou1
 * @date        2019/09/28
 *
 * <pre>
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * </pre>
 */
public class _0048_RotateImage {


    /**
     * Thought
     *      数组顺时针旋转90度
     *
     * Challenge
     *      数组下标控制
     *
     * Algorithm
     *      1. 沿正对角线反转
     *      2. 沿竖中轴线对折
     */
    private static class Solution {

        public void rotate(int[][] matrix) {
            if (matrix == null) {
                return;
            }

            System.out.println("origin matrix = \n" + matrixToString(matrix));
            for (int i = 0; i < matrix.length; i ++) {
                for (int j = 0; j < i; j ++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            System.out.println("diagonal matrix = \n" + matrixToString(matrix));

            for (int m = 0; m < matrix.length; m ++) {
                for (int n = 0; n < matrix.length/2; n ++) {
                    int temp = matrix[m][n];
                    matrix[m][n] = matrix[m][matrix.length-1-n];
                    matrix[m][matrix.length-1-n] = temp;
                }
            }
            System.out.println("axile matrix = \n" + matrixToString(matrix));
        }

        private String matrixToString(int[][] matrix) {
            StringBuilder toString = new StringBuilder();
            for (int[] vector: matrix) {
                toString.append(Arrays.toString(vector))
                        .append(System.lineSeparator());
            }
            return toString.toString();
        }

        public static void main(String[] args) {
            int[][][] inputs = {
                    {
                            {5, 1, 9, 11},
                            {2, 4, 8, 10},
                            {13, 3, 6, 7},
                            {15, 14, 12, 16}
                    },
                    {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                    }
            };

            for (int[][] matrix: inputs) {
                new Solution().rotate(matrix);
                System.out.println("--------------------------");
            }
        }


    }
}
