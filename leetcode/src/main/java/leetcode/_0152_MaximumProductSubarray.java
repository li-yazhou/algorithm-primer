package leetcode;

import java.util.Arrays;

/**
 * @No          152
 * @problem     Maximum Product Subarray
 * @level       Medium
 * @desc        乘积最大子序列
 * @author      liyazhou1
 * @date        2019/10/02
 *
 * <pre>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * </pre>
 */
public class _0152_MaximumProductSubarray {


    /**
     * Note
     *
     * Thought
     *      对比53题--连续子串最大和
     *      动态规划
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time, O(n)
     *      Space, O(1)
     */
    private static class Solution {

        public int maxProduct(int[] nums) {

            int max = nums[0];

            int imax = nums[0];  // 当前的最大值
            int imin = nums[0];  // 当前的最小值

            for (int i = 1; i < nums.length; i ++) {
                if (nums[i] < 0) {
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                imax = Math.max(imax*nums[i], nums[i]);
                imin = Math.min(imin*nums[i], nums[i]);
                max = Math.max(max, imax);
            }

            return max;
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {2, 3, -2, 4},
                    {-2, 0, -1}
            };

            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int result = new Solution().maxProduct(input);
                System.out.println("result = " + result);
                System.out.println("-------------------------");
            }
        }
    }


    /**
     * Note
     *
     * Thought
     *      动态规划
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time, O(n)
     *      Space, O(n)
     */
    private static class Solution1 {

        private class Tuple {
            int imax;
            int imin;
            public Tuple (int imax, int imin) {
                this.imax = imax;
                this.imin = imin;
            }
        }

        public int maxProduct(int[] nums) {

            Tuple[] dp = new Tuple[nums.length];
            dp[0] = new Tuple(nums[0], nums[0]);

            int max = nums[0];
            for (int i = 1; i < nums.length; i ++) {
                Tuple prev = dp[i-1];
                int imax = Math.max(Math.max(nums[i], nums[i] * prev.imax), nums[i] * prev.imin);
                int imin = Math.min(Math.min(nums[i], nums[i] * prev.imin), nums[i] * prev.imax);
                dp[i] = new Tuple(imax, imin);
                max = Math.max(max, imax);
            }
            return max;
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {2, 3, -2, 4},
                    {-2, 0, -1}
            };

            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int result = new Solution1().maxProduct(input);
                System.out.println("result = " + result);
                System.out.println("-------------------------");
            }
        }
    }

}
