package offerV2;

import java.util.Arrays;

/**
 * @No          v2-011,v1-008
 * @problem     旋转数组中的最小数字
 * @tag         数组、二分查找
 * @author      liyazhou1
 * @date        2020/02/02
 *
 * <pre>
 *      把一个数组的最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如，数组 {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * </pre>
 */
public class _011_Min_Element_In_Rotate_Array {


    /**
     * Note
     *
     * Thought
     *      旋转数组可以由任意一个下标切分为两部分组，非递减数组和旋转数组
     *      其中，非递减数组的特点是第一个元素小于最后一个元素，否则为旋转数组
     *
     *      通过修改二分查找算法进行求解(l 代表 low，m 代表 mid，h 代表 high):
     *      当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，此时 令 h = m;
     *      否则 [m + 1, h] 区间内的数组是旋转数组，令 l = m + 1。
     *
     *      如果数组元素允许重复，会出现一个特殊的情况:nums[l] == nums[m] == nums[h]，
     *      此时无法确定解在哪个区间， 需要切换到顺序查找。
     *      例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区 间。
     *
     * Algorithm
     *      1. 若后半部分为非递减数组，则区间往前压缩
     *      2. 若后半部分为选择数组（不是非递减数组），则区间往后压缩
     *      3. 特殊情况是，如果数组出现相等的元素
     */
    private static class Solution {

        public int minElementInRotateArray(int[] nums) {
            int l = 0;
            int h = nums.length-1;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[m] <= nums[h]) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l];
        }


        public int minElementInRotateArrayFull(int[] nums) {
            int l = 0;
            int h = nums.length-1;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[l] == nums[m] && nums[m] == nums[h]) {
                    return findMinElement(nums, l, h);
                } else if (nums[m] <= nums[h]) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l];
        }

        private int findMinElement(int[] nums, int l, int h) {
            for (int i = l; i < h; i ++) {
                if (nums[i] > nums[i+1]) {
                    return nums[i+1];
                }
            }
            return nums[l];

        }


        public static void main(String[] args) {
            int[][] usecases = {
                    {3, 4, 5, 1, 2},  // 典型输入，单调升序的数组的旋转数组
                    {1, 0, 1, 1, 1},  // 折半后的指针指向的元素等于两个指针指向的元素，且该元素属于第二个递增子数组
                    {1, 1, 1, 0, 1},  // 折半后的指针指向的元素等于两个指针指向的元素，且该元素属于第一个递增子数组
                    {1, 2, 3, 4, 5},  // 第二个递增子数组的长度为 0
                    {3, 4, 5, 1, 1},  // 有重复元素
                    {2},              // 只有一个数字
            };

            for (int[] usecase : usecases) {
                System.out.println("usecase = " + Arrays.toString(usecase));
                int result = new Solution().minElementInRotateArrayFull(usecase);
                System.out.println("result = " + result);
                System.out.println("---------");
            }
        }
    }
}
