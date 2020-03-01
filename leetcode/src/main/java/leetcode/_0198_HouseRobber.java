package leetcode;

/**
 * @No          198
 * @problem     House Robber
 * @level       Easy
 * @desc        打家劫舍
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * </pre>
 */
public class _0198_HouseRobber {


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
    private static class Solution {


        public int rob0(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            } else if (nums.length == 1) {
                return Math.max(nums[0], nums[1]);
            }

            int first = nums[0];
            int second = Math.max(nums[0], nums[1]);
            int rob = Math.max(first, second);
            for (int i = 2; i < nums.length; i ++) {
                rob = Math.max(second, first+nums[i]);
                first = second;
                second = rob;
            }
            return rob;
        }


        /**
         * 两种状态，抢或不抢，使用列长为2的二维数组表示。
         */
        public int rob1(int[] nums) {
            int[][] dp = new int[nums.length+1][2];
            // dp[i][1] means we rob the current house and dp[i][0] means we don't,

            for (int i = 1; i < dp.length; i ++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);  // 不抢
                dp[i][1] = dp[i-1][0] + nums[i-1];   // 抢
            }
            return Math.max(dp[nums.length][0], dp[nums.length][1]);
        }


        public int rob3(int[] nums) {
            return doRob(nums, nums.length - 1);
        }

        private int doRob(int[] nums, int i) {
            if (i < 0) {
                return 0;
            }
            return Math.max(doRob(nums, i - 2) + nums[i], doRob(nums, i - 1));
        }


        public int rob4(int[] nums) {
            int max = rob(nums, 0);
            System.out.println("max = " + max);
            return max;
        }

        private int rob(int[] nums, int i) {
            if (i >= nums.length) {
                return 0;
            } else {
                int rob = sum(nums, i+2) + nums[i];
                int noRob = sum(nums, i+1);
                return Math.max(rob, noRob);
            }
        }


        private int sum(int[] nums) {
            return sum(nums, nums.length-1);
        }

        int sum(int[] nums, int i) {
            if (i < 0) {
                return 0;
            } else {
                return sum(nums, i-1) + nums[i];
            }
        }

        public static void main(String[] args) {
            int result = new Solution().rob3(new int[]{1, 2, 3, 4});
            System.out.println("result = " + result);
            int max = new Solution().rob4(new int[]{1, 2, 3, 4});
            System.out.println("max = " + max);

            int sum = new Solution().sum(new int[]{1, 2, 3, 4});
            System.out.println("sum = " + sum);
        }
    }
}
