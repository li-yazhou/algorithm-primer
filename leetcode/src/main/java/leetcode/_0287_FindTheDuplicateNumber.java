package leetcode;

import java.util.Arrays;

/**
 * @No          287
 * @problem     Find the Duplicate Number
 * @level       Medium
 * @desc        寻找重复数
 * @author      liyazhou1
 * @date        2019/10/06
 *
 * <pre>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * </pre>
 */
public class _0287_FindTheDuplicateNumber {


    /**
     * Note
     *
     * Thought
     *      142 环形链表II，求环形链表的入口结点
     *
     * Challenge
     *      求链表的长度
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

        public int findDuplicate(int[] nums) {
            Arrays.sort(nums);
            int result = -1;
            for (int i = 1; i < nums.length; i ++) {
                if (nums[i-1] == nums[i]) {
                    result = nums[i];
                    break;
                }
            }
            return result;
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 3, 4, 2, 2},
                    {3, 1, 3, 4, 2}
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int result = new Solution().findDuplicate(input);
                System.out.println("result = " + result);
                System.out.println("-----------");
            }
        }
    }
}
