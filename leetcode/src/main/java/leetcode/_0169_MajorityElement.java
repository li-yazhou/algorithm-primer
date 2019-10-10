package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @No          169
 * @problem     Majority Element
 * @level       Easy
 * @desc        求众数
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * </pre>
 */
public class _0169_MajorityElement {


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
        /* 摩尔投票法 */
        public int majorityElement(int[] nums) {
            int result = nums[0];
            int count = 0;
            for (int i = 0; i < nums.length; i ++) {
                if (result == nums[i]) count ++;
                else count --;
                if (count == 0) result = nums[i+1];
            }
            return result;
        }

        public int majorityElement2(int[] nums) {
            int counter = 0;
            int curr = nums[0];
            for (int i = 0; i < nums.length; i ++){
                if (counter == 0) curr = nums[i];

                if (nums[i] == curr) counter ++;
                else{
                    counter --;
                    if (counter <= 0) counter = 0;
                }
            }
            return curr;
        }

        // 哈希表
        public int majorityElement1(int[] nums) {
            Integer result = null;
            int majorityNum = nums.length/2;
            Map<Integer, Integer> map = new HashMap<>();
            for (int element : nums) {
                Integer count = map.get(element);
                if (count == null) count = 1;
                else count = count + 1;
                if (count > majorityNum) {
                    result = element;
                    break;
                }
                map.put(element, count);
            }
            return result;
        }
    }
}
