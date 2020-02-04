package offerV2;

/**
 * @No          v2-064
 * @problem     求前N个正整数之和
 * @tag         递归
 * @author      liyazhou
 * @date        2017-06-03
 *
 * <pre>
 *      求 1+2+...+n。要求不能使用乘除法、for、while、if、else、switch、case等关键字
 *      及条件判断语句。
 * </pre>
 */
public class _064_N_Num_Sum {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        public static int sumOfTopN(int n) {
            if (n == 1) {
                return n;
            } else {
                return sumOfTopN(n-1)+n;
            }
        }

        public static void main(String[] args) {
            int result = sumOfTopN(10);
            System.out.println("result = " + result);
            int ret2 = sum(10);
            System.out.println("ret2 = " + ret2);
        }


        public static int sum(int n) {
            int sum = n;
            boolean bool = (n > 0) && ((sum += sum(n-1)) > 0);
            return sum;
        }
    }
}
