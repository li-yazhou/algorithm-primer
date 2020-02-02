package offerV2;

/**
 * @No          v2-015
 * @problem     二进制中1的个数
 * @tag         位运算
 * @author      liyazhou1
 * @date        2017/5/25
 *
 * <pre>
 *      请实现一个函数，输入一个整数，输出该整数二进制表示中 1 的个数。
 *      例如把 9 表示成二进制是 1001， 有 2 位是 1。因此如果输入 9，该函数输出 2。
 * </pre>
 */
public class _015_Count_1_Num {


    /**
     * Note
     *
     * Thought
     *  输入一个整数，输出该数二进制表示中 1 的个数。
     *  n&(n-1)
     *  该位运算去除 n 的位级表示中最低的那一位。
     *      n       : 10110100
     *      n-1     : 10110011
     *      n&(n-1) : 10110000
     *  时间复杂度:O(M)，其中 M 表示 1 的个数。
     *
     * Algorithm
     *      1.
     *      2.
     */
    private static class Solution {


        public int countOfOne(int n) {
            int count = 0;
            while (n != 0) {
                count ++;
                n &= (n-1);
            }
            return count;
        }


        public int bitCount(int n) {
            return Integer.bitCount(n);
        }


        public int countOfOne2 (int number) {
            int counter = 0;
            // Java语言规范中，int整型类型占四个字节，总计32位
            // 对每一个位置与 1 进行按位与操作，再累加就可以求出当前数字的表示包含有多少位 1
            for (int i = 0; i < 32; i++){
                counter += (number & 1);
                number = number >>> 1;
            }
            return counter;
        }


        public static void main(String[] args) {

            int[] usecases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            for (int usecase : usecases) {
                System.out.printf("%s, ", Integer.toBinaryString(usecase));
                int r1 = new Solution().countOfOne(usecase);
                int r2 = new Solution().countOfOne2(usecase);
                int r = new Solution().bitCount(usecase);
                System.out.printf("r1 = %d, r2 = %d, r = %d", r1, r2, r);
                System.out.println();
            }
        }
    }
}
