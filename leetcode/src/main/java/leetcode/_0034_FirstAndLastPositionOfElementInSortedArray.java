package leetcode;

import java.util.Arrays;

/**
 * @No         34
 * @problem    Find First and Last Position of Element in Sorted Array
 * @level      Medium
 * @desc       在排序数组中查找元素的第一个和最后一个位置
 * @author     liyazhou1
 * @date       2019/9/28
 *
 * <pre>
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * </pre>
 */
public class _0034_FirstAndLastPositionOfElementInSortedArray {

    /**
     * Thought
     *      折半查找
     *
     * Challenge
     *      边界控制
     *
     * Algorithm
     *      1. 折半查找target，确定 M，若 M 小于 0 则返回 {-1, -1}
     *      2. 在 [L, M) 折半查找 target，确定 L，表示左侧第一个为 target 元素的下标
     *      3. 在 (M, R] 折半查找 target，确定 R，表示右侧最后一个为 target 元素的下标
     *      4. 返回 [L, R]
     */
    private static class Solution {

        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int M = Arrays.binarySearch(nums, target);
            if (M < 0) {
                return new int[]{-1, -1};
            }
            // System.out.println("M = " + M);

            int L0 = 0;
            int R0 = M;
            while (L0 <= R0) {
                int mid = (L0 + R0) / 2;
                // System.out.printf("L0 = %d, R0 = %d, mid = %d", L0, R0, mid);
                if (nums[mid] == target) {
                    R0 = mid - 1;
                } else if (nums[mid] < target){
                    L0 = mid + 1;
                }
                // System.out.printf(" ==> L0 = %d, R0 = %d, mid = %d\n", L0, R0, mid);
            }

            int L1 = M;
            int R1 = nums.length - 1;
            while (L1 <= R1) {
                int mid = (L1 + R1) / 2;
                // System.out.printf("L1 = %d, R1 = %d, mid = %d", L1, R1, mid);
                if (nums[mid] == target) {
                    L1 = mid + 1;
                } else if (nums[mid] > target){
                    R1 = mid - 1;
                }
                // System.out.printf(" ==> L1 = %d, R1 = %d, mid = %d \n", L1, R1, mid);
            }
            return new int[]{L0, R1};
        }


        public static void main(String[] args) {
            int[][][] inputs = {
                    {
                            {5,7,7,8,8,10},
                            {8}
                    },
                    {
                            {5,7,7,8,8,10},
                            {6}
                    },
                    {
                            {5,7,7,8,8,10},
                            {7}
                    }
            };

            for (int[][] input: inputs) {
                int[] nums = input[0];
                int target = input[1][0];
                System.out.printf("nums = %s, target = %d \n", Arrays.toString(nums), target);
                int[] output = new Solution().searchRange(nums, target);
                System.out.printf("output = %s \n", Arrays.toString(output));
                System.out.println("--------------------------");
            }
        }
    }

}
