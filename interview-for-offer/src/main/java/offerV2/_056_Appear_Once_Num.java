package offerV2;

/**
 * @No          v2-056,v1-040
 * @problem     数组中只出现一次的数字
 * @tag         位运算、数组
 * @author      liyazhou
 * @date        2017-06-01
 *
 * <pre>
 *      一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *      请写程序找出两个只出现了一次的数字。要求时间复杂度是 O(n)，空间复杂度是 O(1)
 * </pre>
 */
public class _056_Appear_Once_Num {


    /**
     * Note
     *
     * Thought
     *      1. 二进制与位运算
     *          第一，任何一个数字异或它自己都等于 0；
     *          第二，任何一个数字异或 0 都等于它自己。
     *
     *          在本题目中会运用到基于这两点的推论：
     *              任何一个数字异或另一个数字2n（n是正整数）次，则结果还是这个数字本身。
     *
     * Algorithm
     *      1. 如果一个数组中只有一个数字仅仅出现一次，其他数字都出现2次（或偶数次），
     *         则将该数组中所有的元素进行异或运算，则结果就是只出现一次的数字
     *      2. 根据 1，想办法将含有两个只出现一次的数字划分到两个数组中，之后可以按 1 分别计算出结果
     *      3. 将原始数组中的所有元素进行异或运算，由于有两个只出现一次的数字，则结果肯定是非0的数字，
     *         将异或结果转化为二进制，找到后边的第一个 1，记录其索引
     *         如果原始数组中的元素的二进制在该索引出是1，则将其划分到一个数组中，否则被划分到另一数组中。
     *         （注：我们的目的是将只出现一次的两个数字分别划分到两个数组中，而出现两次的数字同时被分配到哪一个数组是无关紧要的）
     *
     */
    private static class Solution {


        public int[] findTwoNumOfAppearanceOnce(int[] array){
            int[] result = {0, 0};

            if (array == null || array.length < 2) return result;

            int xor = 0;
            for (int emt : array) xor ^= emt;

            // int indexOfOne = findFirstBit1(xor);
            String xorStr = Integer.toBinaryString(xor);
            // 从右面开始计数，0 是第一个数字
            int indexOfOne = xorStr.length() - xorStr.lastIndexOf("1") - 1;
            for (int emt : array){
                // 如果这个数字的倒数第indexOfOne+1个数字是1则，划分到一个数组中，否则划分到另外一个数组中
                // 出现两次的数字同时被分配到哪一个数组是无关紧要的，
                // 我们的目的是将只出现一次的两个数字分别划分到两个数组中
                if (((emt >>> indexOfOne) & 1) == 1) result[0] ^= emt;
                else                                 result[1] ^= emt;
            }

            return result;
        }

        private int findFirstBit1(int num){
            int idx;
            for (idx = 0; (num & 1) == 0 && idx < 32; num >>>= 1, idx ++);
            return idx;
        }



        /**
         * num = diff & -diff，结果为diff最右侧不为0的数字
         * diff &= -diff，也即是两个不重复元素在位级表示上最右侧不同的那一位，使用这一位就可以将两个元素区分开来
         */
        public int[] find2NumAppearOnce(int[] nums) {
            int[] ret = new int[2];

            int diff = 0;

            for (int num : nums) {
                diff ^= num;
            }

            diff ^= diff;
            for (int num : nums) {
                if ((num & diff) == 0) {
                    ret[0] ^= num;
                } else {
                    ret[1] ^= num;
                }
            }
            return ret;
        }
    }
}
