package leetcode;

import java.util.*;

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
     *  改编题目，求数组任意子集的元素和，即每个元素不参与运算或者仅参与一次运算
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
    private static class Solution2 {

        Set<Integer> result = new HashSet<>();

        public Set<Integer> subsums(int[] nums) {
            subsums(nums, 0, nums.length-1);
            return result;
        }

        private void subsums(int[] nums, int sum, int i) {
            if (i < 0) {
                return;
            }

            int taken = sum + nums[i];
            int nottaken = sum;
            result.add(taken);
            result.add(nottaken);

            subsums(nums, taken, i-1);
            subsums(nums, nottaken, i-1);

        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 5, 11, 5},
                    {1, 2, 3, 5},
            };
            for (int[] input: inputs) {
                System.out.println("2 input = " + Arrays.toString(input));
                Set<Integer> result = new Solution2().subsums(input);
                List<Integer> list = new ArrayList<>(result);
                Collections.sort(list);
                System.out.println("1 list = " + list);
                System.out.println("---------------");
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
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution1 {

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

            return subsum(nums, target, nums.length-1);
        }


        private boolean subsum(int[] nums, int target, int i) {
            if (i < 0) {
                return  false;
            }

            int taken = target - nums[i];
            int nottaken = target;

            if (taken == 0 || nottaken == 0) {
                return true;
            }

            return subsum(nums, taken, i-1) || subsum(nums, nottaken, i-1);
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 5, 11, 5},
                    {1, 2, 3, 5},
            };
            for (int[] input: inputs) {
                System.out.println("1 input = " + Arrays.toString(input));
                boolean result = new Solution1().canPartition(input);
                System.out.println("1 result = " + result);
                System.out.println("---------------");
            }

            int[] input = {1, 5, 11, 5};
            int[] targets = {1, 5, 10, 11, 12, 16, 17, 21, 22, 23, 2, 6};
            System.out.println("target = " + Arrays.toString(targets));
            for (int target : targets) {
                System.out.println("target = " + target);
                boolean result = new Solution1().subsum(input, target, input.length-1);
                System.out.println("result = " + result);
                System.out.println("++++++++++++++++++");
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
