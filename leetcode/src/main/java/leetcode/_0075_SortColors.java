package leetcode;

import java.util.Arrays;

/**
 * @No          75
 * @problem     Sort Colors
 * @level       Medium
 * @desc        颜色分类
 * @author      liyazhou1
 * @date        2019/09/29
 *
 * <pre>
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * </pre>
 */
public class _0075_SortColors {


    /**
     * Note
     *      note
     *
     * Thought
     *      方法一，统计0、1、2出现的次数，然后将它们按顺序及出现次数写入到原数组
     *      方法二，荷兰国旗问题，使用三个指针处理，本解使用的方法
     *
     *
     * Challenge
     *      指针的使用
     *      数组的处理艺术是元素交换，多个指针（下标）作为索引标识元素，然后对它们进行交换操作
     *      本题目的关键之处，是找出0与1，1与2的边界
     *
     * Algorithm
     *      1. p0指针指向0元素的右边界（不包括），初始值是0；
     *      2. p2指针指向2元素的左边界（不包括），初始值是n-1；
     *      3. curr指针小于等于p2遍历数组
     *              若当前元素为0，则与p0指向的元素交换位置，并执行p0++, curr++;
     *              若当前元素为2，则与p2指向的元素交换位置，并执行p2--；（由2换回来的元素可能是1也能是0，因此curr的位置不变）
     *              若当前元素为1，则curr++，继续查找0或者2；
     *
     * Complexity
     *      Time, O(n)
     *      Space, O(1)
     *
     * Rank
     *      Runtime,
     *      Memory Usage,
     *
     */
    private static class Solution {

        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int p0 = 0;
            int p2 = nums.length - 1;
            int curr = 0;
            while (curr <= p2) {
                if (nums[curr] == 0) {
                    swap(nums, curr ++, p0 ++);
                } else if (nums[curr] == 2) {
                    swap(nums, curr, p2 --);
                } else if (nums[curr] == 1) {
                    curr ++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 2, 0, 2, 1, 1, 0, 2},
                    {0}
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                new Solution().sortColors(input);
                System.out.println("output = " + Arrays.toString(input));
                System.out.println("----------------");
            }
        }

    }
}
