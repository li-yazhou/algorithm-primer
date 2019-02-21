package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/27.
 * 面试题20：顺时针打印矩阵
 *
 * 题目：
 *      输入一个矩阵，按照从外向里以顺时针依次打印出每一个数字。
 *      例如，如果输入矩阵如下：
 *          1   2   3   4
 *          5   6   7   8
 *          9   10  11  12
 *          13  14  15  16
 *      则依次打印出数字 1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10。
 *
 * 问题：对这道题目懵圈
 *
 * 思路：对这道题目懵圈
 *
 */
public class Test20 {

    public static void printMatrixClockwisely(int[][] matrix){
        if (matrix == null) return;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        // 没有发现这规律，不会定义这条件
        while (rows > 2 * start && cols > 2 * start){
            printMatrixCircle(matrix, start);
            start ++;
        }

    }

    private static void printMatrixCircle(int[][] matrix, int start) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++){
            int number = matrix[start][i];
            System.out.print(number + " ");
        }

        // 从上到下打印一列
        if (start < endY){
            for (int i = start + 1; i <= endY; i++){
                int number = matrix[i][endX];
                System.out.print(number + " ");
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY){
            for (int i = endY - 1; i >= start; i--){
                int number = matrix[endY][i];
                System.out.print(number + " ");
            }
        }

        // 从下到上打印一列
        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start + 1; i--){
                int number = matrix[i][start];
                System.out.print(number + " ");
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,    2,    3,    4},
                {5,    6,    7,    8},
                {9,   10,   11,   12},
                {13,  14,   15,   16}
        };

        printMatrixClockwisely(matrix);
    }


}
