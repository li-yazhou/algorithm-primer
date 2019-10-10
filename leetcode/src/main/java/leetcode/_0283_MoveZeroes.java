package leetcode;


/**
 * @No          283
 * @problem     Move Zeroes
 * @level       Easy
 * @desc        移动零
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * </pre>
 */
public class _0283_MoveZeroes {

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


        public void moveZeroes(int[] nums) {
            int pos = 0;
            for (int num : nums){
                if (num != 0) nums[pos++] = num;
            }

            while (pos < nums.length){
                nums[pos++] = 0;
            }
        }

         public void moveZeroes1(int[] nums) {
             int numOfZero = 0;
             for (int i = 0; i < nums.length; i ++){
                 if (nums[i] != 0) continue;
                 for (int j = i+1; j < nums.length; j ++){
                     if (nums[j] != 0) {
                         nums[i] = nums[j];
                         nums[j] = 0;
                         break;
                     }
                 }
             }
         }
    }

}