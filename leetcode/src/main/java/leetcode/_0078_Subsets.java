package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @No          78
 * @problem     Subsets
 * @tag         位运算
 * @level       Medium
 * @desc        子集
 * @author      liyazhou1
 * @date        2019/10/01
 *
 * <pre>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </pre>
 */
public class _0078_Subsets {


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
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int count = 1 << nums.length;
            for (int i = 0; i < count; i ++) {
                int flag = i;
                List<Integer> solution = new ArrayList<>();
                for (int j = 0; j < nums.length; j ++) {
                    if ((flag & 1) == 1) {
                        solution.add(nums[j]);
                    }
                    flag = flag >> 1;
                }
                result.add(solution);
            }
            return result;
        }
    }


    /**
     * leetcode-0078，所有子集的求解，剪枝树
     */
    private static class Solution1 {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrace(new Stack<>(), 0, nums);
            return result;
        }


        private void backtrace(Stack<Integer> solution, int start, int[] nums) {
            if (start >= nums.length) {
                System.out.println("----------");
                return;
            }
            for (int i = start; i < nums.length; i ++) {
                solution.push(nums[i]);
                result.add(new ArrayList<>(solution));

                System.out.println("in i = " + i + ", solution = " + solution + ", start = " + start);
                start += 1;
                backtrace(solution, start, nums);

                solution.pop();
                System.out.println("out i = " + i + ", solution = " + solution + ", start = " + start);
            }
        }


        public static void main(String[] args) {
            int[] input = {0, 1, 2, 3};
            List<List<Integer>> result = new Solution1().subsets(input);
            System.out.println("result = " + result);
        }
    }


    /**
     * leetcode-0078，所有子集的求解，0-1二叉树求解子集
     */
    private static class Solution2 {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrace(new ArrayList<Integer>(), 0, nums);
            return result;
        }


        private void backtrace(List<Integer> solution, int start, int[] nums) {
            if (start == nums.length) {
                result.add(new ArrayList<>(solution));
                System.out.println("----------");
                return;
            }

            List<Integer> nottaken = new ArrayList<>(solution);
            List<Integer> taken = new ArrayList<>(solution);
            taken.add(nums[start]);
            start += 1;
            backtrace(nottaken, start, nums);
            backtrace(taken, start, nums);
        }


        public static void main(String[] args) {
            int[] input = {0, 1, 2};
            List<List<Integer>> result = new Solution2().subsets(input);
            System.out.println("result = " + result);
        }
    }
}
