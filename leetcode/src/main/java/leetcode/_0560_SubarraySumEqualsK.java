package leetcode;

/**
 * @No          560
 * @problem     Subarray Sum Equals K
 * @level       Medium
 * @desc        和为K的子数组
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * </pre>
 */
public class _0560_SubarraySumEqualsK {


    /**
     * Note
     *
     * Thought
     *      方法一，暴力法
     *      方法二，动态规划
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        /**
         * 方法一，暴力法
         */
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int start = 0; start < nums.length; start ++) {
                int sum = 0;
                for (int end = start; end < nums.length; end ++) {
                    sum += nums[end];
                    if (sum == k) {
                        count ++;
                    }
                }
            }
            return count;
        }

        public static void main(String[] args) {
            int[] input = {1, 1, 1};
            int k = 2;
            int result = new Solution().subarraySum(input, k);
            System.out.println("result = " + result);
        }
    }
}
