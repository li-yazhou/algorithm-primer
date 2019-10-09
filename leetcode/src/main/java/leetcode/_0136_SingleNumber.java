package leetcode;

/**
 * @No          136
 * @problem     Single Number
 * @level       Easy
 * @desc        只出现一次的数字
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 * </pre>
 */
public class _0136_SingleNumber {


    /**
     * Note
     *
     * Thought
     *      位运算
     *          任何整数与0异或均等于它本身；
     *          任务整数与它本身异或均等于0；
     *
     *      位运算——异或运算
     *          只有一个1则结果为1，也即是“有1则1”。
     *
     *      则可以推出：
     *          任何整数和0异或结果是它本身。
     *          一个整数异或它本身结果等于0。
     *
     *      可以进一步推出：
     *          一个整数异或另一个整数两次结果是它本身。
     *
     * Challenge
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

        public int singleNumber(int[] nums) {
            int result = 0;
            for (int element : nums) {
                result ^= element;
            }
            return result;
        }
    }
}
