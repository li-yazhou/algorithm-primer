package leetcode;

import java.util.Arrays;

/**
 * @No          416
 * @problem     Partition Equal Subset Sum
 * @level       Medium
 * @desc        分割等和子集
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * </pre>
 */
public class _0416_PartitionEqualSubsetSum {


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
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length < 2) {
                return false;
            }

            int sum = 0;
            for (int num: nums) {
                sum += num;
            }

            if ((sum & 1) == 1) {
                return false;
            }

            int target = sum / 2;

            int len = nums.length;
            boolean[][] dp = new boolean[len][target+1];
            dp[0][nums[0]] = true;

            for (int i = 1; i < len; i ++) {
                for (int j = 0; j < target+1; j ++) {
                    dp[i][j] = dp[i-1][j];
                    if (j >= nums[i]) {
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                    }
                }
            }

            return dp[len-1][target];
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 5, 11, 5},
                    {1, 2, 3, 5}
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                boolean result = new Solution().canPartition(input);
                System.out.println("result = " + result);
                System.out.println("---------------");
            }

        }
    }
}
