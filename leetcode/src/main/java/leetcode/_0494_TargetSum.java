package leetcode;

/**
 * @No          494
 * @problem     Target Sum
 * @level       Medium
 * @desc        目标和
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * </pre>
 */
public class _0494_TargetSum {


    /**
     * Note
     *
     * Thought
     *      递归
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

        public int findTargetSumWays(int[] nums, int S) {
            return dfs(nums, S, 0);
        }

        private int dfs(int[] nums, int sum, int start) {
            if (start == nums.length) {
                return sum == 0 ? 1 : 0;
            }

            return dfs(nums, sum+nums[start], start+1)
                    + dfs(nums, sum-nums[start], start+1);
        }

        public static void main(String[] args) {
            int[] input = {1, 1, 1, 1, 1};
            int target = 3;
            int result = new Solution().findTargetSumWays(input, target);
            System.out.println("result = " + result);
        }

    }
}
