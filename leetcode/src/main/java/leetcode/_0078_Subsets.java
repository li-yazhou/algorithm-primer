package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @No          78
 * @problem     Subsets
 * @tag         位运算
 * @level       Medium
 * @desc        子集
 * @author      liyazhou1
 * @date        2019/10/01
 *
 * <pre>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </pre>
 */
public class _0078_Subsets {


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

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int count = 1 << nums.length;
            for (int i = 0; i < count; i ++) {
                int flag = i;
                List<Integer> solution = new ArrayList<>();
                for (int j = 0; j < nums.length; j ++) {
                    if ((flag & 1) == 1) {
                        solution.add(nums[j]);
                    }
                    flag = flag >> 1;
                }
                result.add(solution);
            }
            return result;
        }
    }
}
