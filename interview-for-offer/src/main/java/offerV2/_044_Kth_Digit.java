package offerV2;

/**
 * @No          v2-044,-
 * @problem     数字序列中的某一位数字
 * @tag         字符串
 * @author      liyazhou
 * @date        2020/02/02
 *
 * <pre>
 *  数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位
 * </pre>
 */
public class _044_Kth_Digit {


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

        public int getKthDigit(int k) {

            int digit = 1;
            while (true) {
                int amout = getAmountOfDigit(digit);
                if (amout >= k) {
                    return getKthDigit(k, digit);
                }
                k -= amout;
                digit ++;
            }
        }


        private int getKthDigit(int k, int digit) {
            int bias = k / digit;
            int count = k % digit;

            int start = getStartNumOfDigit(digit);
            String number = start + bias + "";

            return number.charAt(count) - '0';
        }


        /**
         *
         * @param digit 整数的位数
         * @return 位数为digit的整数个数
         */
        private int getAmountOfDigit(int digit) {
            if (digit == 1) {
                return 10;
            } else {
                return (int) (Math.pow(10, digit-1) * 9);
            }
        }

        /**
         *
         * @param digit 整数的位数
         * @return 位数为digit的最小整数
         */
        private int getStartNumOfDigit(int digit) {
            if (digit == 1) {
                return 0;
            } else {
                return (int) (Math.pow(10, digit-1));
            }
        }
    }
}
