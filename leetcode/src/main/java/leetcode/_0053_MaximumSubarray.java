package leetcode;

/**
 * @No          53
 * @problem     Maximum Subarray
 * @level       Easy
 * @desc        最大子序和
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * </pre>
 */
public class _0053_MaximumSubarray {


    /**
     * Note
     *
     * Thought
     *      动态规划
     *          一维DP，每个元素表示截止到当前元素时最大的和
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

        public int maxSubArray(int[] nums) {
            int energy = 0;
            int start = 0;
            int end = 0;
            int max = nums[0];

            for (int i = 0; i < nums.length; i ++) {
                if (energy <= 0) {
                    energy = 0;
                    start = i;
                }

                energy += nums[i];
                if (max < energy) {
                    max = energy;
                    end = i;
                }
            }
            return max;
        }

        public int maxSubArray0(int[] nums) {

            int maxSum = nums[0];
            int currSum = 0;

            for (int num : nums){
                if (currSum < 0) currSum = 0;
                currSum += num;
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }
    }
}
