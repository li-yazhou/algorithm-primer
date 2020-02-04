package offerV2;

import java.util.Arrays;

/**
 * @No          v2-057,v1-041
 * @problem     有序数组中查找和为s的两个数
 * @tag         数组、双指针
 * @author      liyazhou
 * @date        2017-06-01
 *
 * <pre>
 *      输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是 s。
 *      如果有多对数字的和等于 s， 输出任意一对即可。
 *      例如，输入数组 {1, 2, 4, 7, 11, 15}和数字15，输出 4,7。
 * </pre>
 */
public class _057_Find_2Num_Equal_Value_In_Sorted_Array {


    /**
     * Note
     *
     * Thought
     *      1. 二叉查找的思想（对于排序数组，首先要想到二分查找，使用两个指针不断缩小范围）
     *
     * Algorithm
     *      1. 使用两个指针，分别指向查找范围的最小值 min 和最大值 max
     *      2. 如果 min + max < sum，则 min 向后移动一位
     *         如果 min + max > sum，则 max 向前移动一位
     *         如果 min + max == sum，则输出 min, max，停止循环
     */
    private static class Solution {

        public int[] findTwoNum(int[] array, int sum){
            if (array == null || array.length < 2)  return new int[0];

            int l = 0;
            int r = array.length-1;

            while (l < r){
                if (array[l] + array[r] == sum) {
                    return new int[]{array[l], array[r]};
                } else if (array[l] + array[r] < sum) {
                    l ++;
                } else {
                    r --;
                }
            }
            return new int[0];
        }

    }
}
