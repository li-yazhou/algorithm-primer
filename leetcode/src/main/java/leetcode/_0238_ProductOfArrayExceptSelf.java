package leetcode;

import java.util.Arrays;

/**
 * @No          238
 * @problem     Product of Array Except Self
 * @level       Medium
 * @desc        除自身以外数组的乘积
 * @author      liyazhou1
 * @date        2019/10/05
 *
 * <pre>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * </pre>
 */
public class _0238_ProductOfArrayExceptSelf {


    /**
     * Note
     *
     * Thought
     *      动态规划，从左右两边做动态规划
     *
     *      result[i] = L * R；
     *
     *      L0 = 1
     *      Li = 1 * nums[0] * nums[1] * … * nums[i-1]
     *
     *      R0 = 1
     *      Rk = 1 * nums[n-1] * nums[n-2] * … * nums[k+1]
     *
     * Challenge
     *
     * Algorithm
     *      1. int[] result = new int[nums.length]；
     *      2. 从左遍历，result[i] = Li；
     *      3. 从右遍历，result[i] *= Ri；
     *      4. return result。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            int[] result = new int[nums.length];

            int L = 1;
            for (int i = 0; i < nums.length; i ++) {
                result[i] = L;
                L *= nums[i];
            }

            int R = 1;
            for (int k = nums.length-1; k >= 0; k --) {
                result[k] *= R;
                R *= nums[k];
            }

            return result;
        }


        public static void main(String[] args) {
            int[] input = {
                    1, 2, 3, 4, 5
            };
            System.out.println("input = " + Arrays.toString(input));
            int[] result = new Solution().productExceptSelf(input);
            System.out.println("result = " + Arrays.toString(result));
        }

    }
}
