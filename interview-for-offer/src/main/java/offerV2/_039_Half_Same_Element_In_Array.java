package offerV2;

/**
 * @No          v2-038,v1-029
 * @problem     数组中出现次数超过一半的数字
 * @tag         数组、多数投票问题
 * @author      liyazhou
 * @date        2017/5/29
 *
 * <pre>
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为 9 的数组 {1, 2, 3, 2, 2, 2, 5, 4, 2}。
 *      由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
 *      （牛客题目的额外要求，如果不存在次数过半的数字，则返回0）
 * </pre>
 */
public class _039_Half_Same_Element_In_Array {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 遍历数组时，保存两个值，一个是数组中的一个数字，一个是次数。
     *         当遍历到下一个数字时候，如果其和之前保存的数字相同，则次数加 1，否则次数减 1。
     *         如果次数为零，则保存下一个数字，并把次数设为 1。
     *         最后一次把次数设置为 1 时，保存的数字即为出现次数超过数组长度一半的数字。
     */
    private static class Solution {

        public static int findNum(int[] nums){

            int majority = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i ++){
                // 如果次数不等于0，若当前值跟保存值相等则次数加1，否则减1
                count = nums[i] == majority ? count+1 : count-1;
                if (count == 0){    // // 如果次数等于0，则保存当前数组，并将次数设置为1
                    majority = nums[i];
                    count = 1;
                }
            }

            // 验证是否过半
            int counter = 0;
            for (int i = 0; i < nums.length; i ++){
                if (nums[i] == majority) counter ++;
            }
            // 如果不过半，则返回0
            if (counter <= nums.length/2) majority = 0;

            return majority;
        }
    }
}
