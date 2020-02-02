package offerV2;

import java.util.Arrays;

/**
 * @No          v2-016,v1-011
 * @problem     数值的整数次方
 * @tag         递归
 * @author      liyazhou1
 * @date        2017/5/25
 *
 * <pre>
 *      实现函数 double Power(double base, int exponent)，求 base 的 exponent 次方。
 *      不得使用库函数，同时不需要考虑大数问题。
 * </pre>
 */
public class _016_N_Power {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     */
    private static class Solution {

        public double power(double base, int exponent) {
            if (exponent == 0) {
                return 1;
            }
            if (exponent == 1) {
                return base;
            }

            boolean isNegative = false;
            if (exponent < 0) {
                exponent = -exponent;
                isNegative = true;
            }
            double pow = power(base*base, exponent/2);
            if ((exponent & 1) == 1) {
                pow = pow * base;
            }

            return isNegative ? 1/pow : pow;
        }

        public static void main(String[] args) {
            int[][] usecasess = {
                    {2, 3},
                    {10, 4}
            };

            for (int[] usecase : usecasess) {
                System.out.println("Arrays.toString(usecase) = " + Arrays.toString(usecase));
                double result = new Solution().power(usecase[0], usecase[1]);
                System.out.println("result = " + result);
                System.out.println("----------------");
            }
        }
    }
}
