package leetcode;


/**
 * @No          581
 * @problem     Shortest Unsorted Continuous Subarray
 * @level       Easy
 * @desc        最短无序连续子数组
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 * </pre>
 */
public class _581_ShortestUnsortedContinuousSubarray {


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

        public int findUnsortedSubarray(int[] nums) {

            if (nums == null || nums.length <= 1) {
                return 0;
            }

            int unsortedMinIndex = -1;
            int unsortedMin = Integer.MAX_VALUE;
            int max = nums[0];

            int unsortedMaxIndex = -1;
            int unsortedMax = Integer.MIN_VALUE;
            int min = nums[nums.length-1];

            for (int i = 0; i < nums.length; i ++) {
                if (nums[i] < max) {
                    unsortedMin = Math.min(unsortedMin, nums[i]);
                }
                max = Math.max(max, nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > unsortedMin) {
                    unsortedMinIndex = i;
                    break;
                }
            }
            System.out.println("unsortedMin = " + unsortedMin);
            System.out.println("unsortedMinIndex = " + unsortedMinIndex);

            for (int j = nums.length-1; j >= 0; j --) {
                if (nums[j] > min) {
                    unsortedMax = Math.max(unsortedMax, nums[j]);
                }
                min = Math.min(min, nums[j]);
            }
            for (int j = nums.length-1; j >= 0; j --) {
                if (nums[j] < unsortedMax) {
                    unsortedMaxIndex = j;
                    break;
                }
            }
            System.out.println("unsortedMax = " + unsortedMax);
            System.out.println("unsortedMaxIndex = " + unsortedMaxIndex);

            int count = 0;
            if (unsortedMinIndex != -1) {
                count = unsortedMaxIndex - unsortedMinIndex + 1;
            }
            return count;
        }


        public static void main(String[] args) {
            int[][] nums = {
                    {
                            2, 6, 4, 8, 10, 9, 15
                    },
                    {
                            1, 2, 3, 4
                    },
            };
            int count = new Solution().findUnsortedSubarray(nums[1]);
            System.out.println("count = " + count);
        }


        public int findUnsortedSubarray1(int[] nums) {
            int left = nums.length;
            int right = 0;
            for (int i = 0; i < nums.length; i ++) {
                for (int j = i+1; j < nums.length; j ++) {
                    if (nums[i] > nums[j]) {
                        left = Math.min(i, left);
                        right = Math.max(j, right);
                    }
                }
            }
            int count = 0;
            if (right != 0) {
                count = right - left + 1;
            }
            return count;
        }

    }

}