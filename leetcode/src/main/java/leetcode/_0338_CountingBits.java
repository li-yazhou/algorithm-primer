package leetcode;

/**
 * @No          338
 * @problem     Counting Bits
 * @level       Medium
 * @desc        比特位计数
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * </pre>
 */
public class _0338_CountingBits {


    /**
     * Note
     *
     * Thought
     *      动态规划
     *
     * Challenge
     *      发现规律：
     *      An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int[] countBits(int num) {
            int[] res = new int[num+1];
            for (int i = 1; i <= num; i ++) {
                res[i] = res[i>>1] + (i & 1); // res[i] = res[i/2] + (i % 2);
            }
            return res;
        }


        public int[] countBits1(int num) {
            int[] result = new int[num+1];
            for (int i = 1; i <= num; i ++)
                result[i] = result[i/2] + i % 2;
            return result;
        }
    }
}
