package offerV2;

import java.util.Arrays;

/**
 * @No          v2-03,v1-51
 * @problem     数组中重复的数字
 * @tag         数组
 * @author      liyazhou1
 * @date        2020/2/2
 *
 * <pre>
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道
 * 每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应
 * 的输出是重复的数字 2 或者 3。
 * </pre>
 */
public class _003_Repeat_Num_In_Array {


    /**
     * Thought
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[],int length,int [] duplication) {
            if (numbers == null || numbers.length < 1) {
                return false;
            }

            int n = numbers.length;

            for (int i = 0; i < n; i ++) {

                int valueForCurrPos = numbers[i];
                int valueForExpectedPos = numbers[valueForCurrPos];
                if (valueForCurrPos == valueForExpectedPos) {
                    duplication[0] = valueForCurrPos;
                    return true;
                } else {
                    swap(numbers, i, valueForCurrPos);
                }
            }
            return false;

        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


        public static void main(String[] args) {
            int[][] arrays = {
                    {2, 3, 1, 0, 2, 5}
            };

            for (int[] array : arrays) {
                System.out.println("array = " + Arrays.toString(array));
                int[] duplication = new int[1];
                boolean result = new Solution().duplicate(array, array.length, duplication);
                System.out.println("result = " + result + ", duplication = " + duplication[0]);
            }
        }

    }

}
