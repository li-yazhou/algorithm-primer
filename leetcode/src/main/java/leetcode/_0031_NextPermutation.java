package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @No          31
 * @problem     Next Permutation
 * @level       Medium
 * @desc        下一个排列
 * @author      liyazhou1
 * @date        2019/09/21
 *
 * <pre>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * </pre>
 */
public class _0031_NextPermutation {


    /**
     * Note
     *
     * Thought
     *
     * Challenge
     *
     * Algorithm
     *      从右向左遍历
     *          记录max
     *          若当前元素nums[k]小于max
     *              遍历nums[k~len-1]查找到比nums[k]大的最小元素，并交换两者
     *              Arrays.sort(nums, k+1, nums.length)
     *          若每个元素均不小于max，即序列为逆序DESC，则反转序列或者排序，将序列转换为升序序列
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int index = nums.length - 1;
            int max = nums[index];
            boolean desc = true;
            for (int k = nums.length-1; k >= 0; k --) {
                int curr = nums[k];
                if (curr < max) {
                    int minHead = max;
                    int minHeadIndex = index;
                    for (int i = k+1; i < nums.length; i ++) {
                        if (nums[i] > nums[k]) {
                            if (minHead > nums[i]) {
                                minHead = nums[i];
                                minHeadIndex = i;
                            }
                        }
                    }
                    swap(nums, k, minHeadIndex);
                    Arrays.sort(nums, k+1, nums.length);
                    desc = false;
                    break;
                }

                if (curr > max) {
                    max = curr;
                    index = k;
                }
            }
            if (desc) {
                Arrays.sort(nums);
            }
        }


        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


        @Test
        public void solution() {
            int[][] inputs = {
                    {1, 2, 3},
                    {3, 2, 1},
                    {1, 1, 5},
                    {1, 2, 3, 1},
                    {5, 4, 7, 5, 3, 2},
                    {1, 2, 0, 3, 0, 1, 2, 4},
            };
            for (int[] nums: inputs) {
                for (int i = 0; i < nums.length * 3; i ++) {
                    System.out.print("before = " + Arrays.toString(nums) + "\t");
                    nextPermutation(nums);
                    System.out.println("after = " + Arrays.toString(nums));
                }
                System.out.println("----------------------------");
            }
        }
    }

}
