package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @No          15
 * @problem     3Sum
 * @level       Medium
 * @desc        三数之和
 * @author      liyazhou1
 * @date        2019/09/15
 *
 * <pre>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * </pre>
 */
public class _0015_3Sum {

    /**
     * Note
     *
     * Thought
     *      方法一，暴力验证
     *      方法二，排序 + 左右双指针
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

        /**
         * 方法二，排序 + 左右双指针
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) return result;

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i ++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i-1]) continue;

                int L = i + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum < 0) {
                        L ++;
                    } else if (sum > 0) {
                        R --;
                    } else if (sum == 0){  // else 不通过，？？？？？
                        result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        for (; L < R && nums[L] == nums[L+1]; L ++);
                        for (; L < R && nums[R] == nums[R-1]; R --);
                        L ++;
                        R --;
                    }
                }
            }
            return result;
        }
    }
}
