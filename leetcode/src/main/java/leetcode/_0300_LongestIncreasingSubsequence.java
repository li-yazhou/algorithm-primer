package leetcode;

import java.util.Arrays;

/**
 * @No          300
 * @problem     Longest Increasing Subsequence
 * @level       Medium
 * @desc        最长的上升子序列
 * @author      liyazhou1
 * @date        2019/10/06
 *
 * <pre>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 *
 * Explanation:
 * The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 * </pre>
 */
public class _0300_LongestIncreasingSubsequence {

    /**
     * Note
     *
     * Thought
     *      动态规划
     *
     * Challenge
     *
     * Algorithm
     *      1. dp[i+1] 表示以 nums[i]为结尾元素的最长上升子序列的长度
     *      2. 初始值是 1
     *      3. 动态转移条件和方程为
     *          nums[i] > nums[j]
     *              dp[i] = max(dp[i], dp[j]+1)
     *      4. return max(dp[i])
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int lengthOfLIS(int[] nums) {

            int[] dp = new int[nums.length+1];
            Arrays.fill(dp, 1);

            int len = 0;

            for (int i = 0; i < nums.length; i ++) {
                for (int j = 0; j < i; j ++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                len = Math.max(len, dp[i]);
            }

            return len;
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {10, 9, 2, 5, 3, 7, 101, 18}
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int result = new Solution().lengthOfLIS(input);
                System.out.println("result = " + result);
            }
        }

    }


    /**
     * Note
     *
     * Thought
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
    private static class Solution1 {

        public int lengthOfLIS(int[] nums) {
            return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
        }

        private int lengthOfLIS(int[] nums, int prev, int curpos) {
            if (curpos == nums.length) {
                return 0;
            }

            int taken = 0;
            if (nums[curpos] > prev) {
                taken = 1 + lengthOfLIS(nums, nums[curpos], curpos+1);
            }
            int nottaken = lengthOfLIS(nums, prev, curpos+1);

            return Math.max(taken, nottaken);
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {10, 9, 2, 5, 3, 7, 101, 18}
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int result = new Solution1().lengthOfLIS(input);
                System.out.println("result = " + result);
            }
        }

    }
}
