package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @No          55
 * @problem     Jump Game
 * @level       Medium
 * @desc        跳跃游戏
 * @author      liyazhou1
 * @date        2019/09/28
 *
 * <pre>
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * </pre>
 */
public class _0055_JumpGame {

    /**
     * Thought
     *      贪心算法
     *
     * Challenge
     *
     * Algorithm
     *      1.
     */
    private static class Solution {

        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }

            int pos = nums.length - 1;
            for (int i = nums.length-1; i >= 0; i --) {
                int furthestPos = i + nums[i];
                if (furthestPos >= pos) {
                    pos = i;
                }
            }
            return pos == 0;
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {2, 3, 1, 1, 4},
                    {3, 2, 1, 0, 4},
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                boolean result = new Solution().canJump(input);
                System.out.println("result = " + result);
                System.out.println("----------------------");
            }
        }
    }


    /**
     * Note
     *      TIMEOUT
     *
     * Thought
     *      递归回溯法
     *
     * Challenge
     *      组合出所有可能的解，判断解是否有效
     *
     * Algorithm
     *      1.
     */
    private static class Solution1 {

        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }

            return canJump(nums, 0);
        }

        private boolean canJump(int[] nums, int position) {
            if (position == nums.length-1) {
                return true;
            }

            if (position >= nums.length) {
                return false;
            }

            for (int step = 1; step <= nums[position]; step ++) {
                if (canJump(nums, position+step)) {
                    return true;
                }
            }

            return false;
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {2, 3, 1, 1, 4},
                    {3, 2, 1, 0, 4},
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                boolean result = new Solution1().canJump(input);
                System.out.println("result = " + result);
                System.out.println("----------------------");
            }
        }
    }


    /**
     * 改编题目
     *      查找所有的跳跃路径
     */
    private static class JumpPaths {


        public List<List<Integer>> jumpPaths(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }

            paths(result, new Stack<>(), nums, 0);

            return result;
        }

        private void paths(List<List<Integer>> result, Stack<Integer> steps, int[] nums, int position) {
            System.out.print("steps = " + steps + ", positon = " + position + ", maxstep = " + nums[position]);
            if (position == nums.length-1) {
                System.out.print("\t ==> path = " + steps);
                result.add(new ArrayList<>(steps));
                return;
            }

            for (int step = 1; step <= nums[position]; step ++) {
                System.out.println(", step = " + step);
                steps.push(step);
                paths(result, steps, nums, position+step);
                steps.pop();
            }
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {2, 3, 1, 1, 4},
                    {3, 2, 1, 0, 4},
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                List<List<Integer>> paths = new JumpPaths().jumpPaths(input);
                System.out.println("\npaths = " + paths);
                System.out.println("----------------------");
            }
        }
    }
}
