package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @No          1
 * @problem     Two Sum
 * @level       Easy
 * @desc        两数之和
 * @author      liyazhou1
 * @date        2017-08-02 20:44
 *
 * <pre>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * </pre>
 */
public class _0001_TwoSum {


    /**
     * Note
     *
     * Thought
     *      方法一，暴力法
     *      方法二，Map
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

        /**
         * 方法二，Map
         * You may assume that each input would have exactly one solution
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i ++){
                int remainder = target - nums[i];
                if(map.containsKey(nums[i]))
                    return new int[]{map.get(nums[i]), i};
                map.put(remainder, i);
            }
            throw new IllegalArgumentException("no solution.");
        }


        /**
         * 方法一，暴力法
         */
         public int[] twoSum1(int[] nums, int target) {
             int[] result = new int[2];
             List<Integer> remainders = new ArrayList(nums.length);
             for(int i = 0; i < nums.length; i ++){
                 int remainder = target - nums[i];
                 for (int j = 0; j < remainders.size(); j ++){
                     if (remainders.get(j) == nums[i]){
                         result[0] = j;
                         result[1] = i;
                     }
                 }
                 remainders.add(remainder);
             }
             return result;
         }
    }

}
