package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * @No          448
 * @problem     Find All Numbers Disappeared in an Array
 * @level       Easy
 * @desc        找到所有数组中消失的数字
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 * </pre>
 */
public class _0448_FindAllNumbersDisappearedInAnArray {

    /**
     * Note
     *
     * Thought
     *       充分使用数组长度和数组元素大小的关系，数组元素可以作为数组的下标使用
     *
     *       The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
     *       In this way all the numbers that we have seen will be marked as negative.
     *       In the second iteration, if a value is not marked as negative, it implies we have never seen that index before,
     *       so just add it to the return list.
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
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;  // 元素关联的下标
                if (nums[index] > 0) nums[index] = -nums[index]; // 元素标记下标对应数字是否出现
            }
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > 0) list.add(j + 1);
            }
            return list;
        }


        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = (nums[i] - 1) % nums.length;
                nums[index] += nums.length;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= nums.length) {
                    result.add(i + 1);
                }
            }
            return result;
        }


        public List<Integer> findDisappearedNumbers1(int[] nums) {
            long bitset = 0;
            for (int element : nums) {
                int index = pow(element - 1);
                if ((bitset & index) == 0) {
                    bitset ^= index;
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = pow(i);
                if ((bitset & index) != index) {
                    result.add(i + 1);
                }
            }
            return result;
        }


        int pow(int n) {
            int result = 1;
            for (int i = 0; i < n; i++) {
                result *= 2;
            }
            return result;
        }
    }

}