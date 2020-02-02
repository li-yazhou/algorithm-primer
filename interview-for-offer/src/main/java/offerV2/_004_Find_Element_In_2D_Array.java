package offerV2;

/**
 * @No          v2-04,v1-03
 * @problem     二维数组中的查找
 * @tag         数组
 * @author      liyazhou1
 * @date        2017/5/23
 *
 * <pre>
 *  在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </pre>
 */
public class _004_Find_Element_In_2D_Array {

    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *  首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束。
     *  如果该数字大于要查找的数字，剔除这个数字所在的列；
     *  如果该数字小于要查找的数字，剔除这个数字所在的行。
     *
     *  也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除行或者列，
     *  这样每一步都可以缩小查找范围，直到要查找的数字，或者查找范围为空。
     */
    private static class Solution {

        public static boolean find(int[][] matrix, int number){
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;  // 判断数组

            int rows = matrix.length;
            int cols = matrix[0].length;
            if (number < matrix[0][0] || number > matrix[rows-1][cols-1]) return false;  // 判断边界

            boolean found = false;
            int row = 0;
            int col = cols-1;  // 注意边界
            while(row < rows && col >=0){
                int topRightVal = matrix[row][col];  // 获取到查找范围内的右上角的元素
                if (number == topRightVal){
                    found = true;
                    break;  // 找到该数字，停止查询
                }
                else if (number < topRightVal) --col;  // 删除当前列， 第 col 列
                else ++row;  // number > topRightVal， 删除当前行，第 row 行
            }
            System.out.println(String.format("row, col = %d, %d", row, col));
            return found;
        }

        public static void main(String[] args){
            int[][] matrix = {
                    {1 ,2, 8, 9},
                    {2, 4, 9, 12},
                    {4, 7, 10, 13},
                    {6, 8, 11, 15}
            };
            int[] numbers = {-1, 1, 15, 7};
            for (int number : numbers){
                System.out.println("--------");
                System.out.println(String.format("find %d, %b", number, find(matrix, number)));
            }
        }

    }
}
