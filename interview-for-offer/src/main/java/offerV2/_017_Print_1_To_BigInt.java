package offerV2;

/**
 * @No          v2-017,v1-12
 * @problem     打印从 1 到最大的 n 位数
 * @tag         数组、大整数
 * @author      liyazhou1
 * @date        2017/5/25
 *
 * <pre>
 *      输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。
 *      比如输入 3，则打印出 1,2,3 一直到最大的 3 位数即 999.
 * </pre>
 */
public class _017_Print_1_To_BigInt {


    /**
     * Note
     *
     * Thought
     *      使用字符数组表示大整数
     *
     * Algorithm
     *      1. 使用数组模拟大整数，数组左端为高位，右端为低位
     *      2. "数字"每次增加 1，
     *          如果没有溢出，也即是最高位没有进位时，打印出用数组表示的该数字；
     *          否则，退出循环
     */
    private static class Solution {

        /**
         * @param length 最大数字的位数
         */
        public static void printOneToNDigits2(int length){
            if (length < 1) throw new RuntimeException("Invalid input, the parameter must be bigger than 0");
            // 存储大整数
            int[] arr = new int[length];
            while(!addOne(arr)){
                // System.out.println(Arrays.toString(arr));
                printDigit(arr);
            }
        }

        /**
         * 功能：打印用数组表示的整数
         * 思路：判断开头是不是连续的0，如果是，则忽略；遇见非零元素后，打印后面的全部元素
         * @param arr 表示"整数"的数组
         */
        private static void printDigit(int[] arr) {
            boolean isZero = true;
            for (int i = 0; i < arr.length; i++){
                if (isZero && arr[i] != 0) isZero = false;  //遇见非零数字后，不会再执行该语句
                if (!isZero)  System.out.print(arr[i]);
            }
            System.out.print("\t");
        }

        /**
         * 用数组模拟大整数加法运算，并判断"整数"加 1 后最高位是不是进位
         *
         * @param arr 表示"整数"的数组
         * @return 最高位是否进位
         */
        private static boolean addOne(int[] arr) {
            int increment = 1;
            boolean isOverflow = true;
            for(int i = arr.length-1; i >=0; i--){
                int digit = arr[i] + increment;
                increment = digit / 10;
                arr[i] = digit % 10;
                if (increment == 0) {
                    isOverflow = false;
                    break;
                }
            }
            return isOverflow;
        }
    }
}
