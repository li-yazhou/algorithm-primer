package offerV2;

/**
 * @No          v2-052,v1-038
 * @problem     数字在排序数组中出现的次数
 * @tag         数组、折半查找
 * @author      liyazhou
 * @date        2017-05-31
 *
 * <pre>
 *      统计一个数字在排序数组中出现的次数。例如输入排序数组 {1,2,3,3,3,3,4,5} 和数字 3，
 *      由于 3 在这个数组中出现了 4 次，因此输出 4。
 * </pre>
 */
public class _053_Occurence_Count_In_Sorted_Array {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        public int getNumberOfK(int[] nums, int k) {
            int first = binarySearch(nums, k);
            int second = binarySearch(nums, k+1);

            if (first == nums.length || nums[first] != k) {
                return 0;
            } else {
                return second - first;
            }
        }


        /**
         * 查找元素第一次出现的位置，若不存在则返回起应该在的位置
         */
        private int binarySearch(int[] nums, int k) {
            int l = 0;
            int h = nums.length;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[m] >= k) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }
}
