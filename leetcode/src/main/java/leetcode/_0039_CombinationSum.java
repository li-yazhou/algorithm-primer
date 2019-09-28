package leetcode;

import java.util.*;

/**
 * @No      39
 * @problem Combination Sum
 * @level   Medium
 * @desc    组合总和
 * @author  liyazhou1
 * @date    2019/9/28
 *
 * <pre>
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * </pre>
 */
public class _0039_CombinationSum {


    /**
     * Thought
     *      回溯法，递归 + 重置状态 + 剪枝
     *          减法求解
     *          加法求解
     *
     * Challenge
     *      避免重复的解，如 [2, 2, 3] 与 [3, 2, 2] 它们是同一种解
     *
     * Algorithm
     *      1. 对候选项排序；
     *      2. 遍历候选项
     *          递归结束条件为 target == 0，此时将候选解序列添加到结果集中，并返回；
     *          若当前元素大于当前目标值，则跳过；若当前元素比候选解序列中的最后一个元素小，则跳过（为了避免重复解）；
     *          将当前元素添加到候选解序列中，将当前目标值减去当前元素，递归；
     *          将当前元素冲候选解序列中弹出来；
     */
    private static class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return result;
            }
            // 排序，加上剪枝操作，可以避免重复的解，如 [2, 2, 3] 与 [3, 2, 2]
            Arrays.sort(candidates);
            backtrack(result, new Stack<>(), candidates, target);
            return result;
        }

        private void backtrack(List<List<Integer>> result, Stack<Integer> solution, int[] candidates, int target) {
            if (target == 0) {
                result.add(new ArrayList<>(solution));
                return;
            }
            for (int i = 0; i < candidates.length; i ++) {
                int element = candidates[i];
                // 剪枝操作
                // 若当前元素为比target大，则停止递进
                // 若当前元素比序列中的最后一个元素小，则停止递进，这种情况是为了避免重复的解，如 [2, 2, 3] 与 [3, 2, 2]
                if (element > target
                        || (!solution.isEmpty() && element < solution.peek())) {
                    continue;
                }
                // 递进
                solution.push(element);
                backtrack(result, solution, candidates, target-element);
                // 恢复状态，恢复到递进前的状态
                solution.pop();
            }
        }

        public static void main(String[] args) {
            int[][][] inputs = {
                    {
                            {2, 3, 6, 7},
                            {7}
                    },
                    {
                            {2, 3, 5},
                            {8}
                    }
            };
            for (int[][] input: inputs) {
                int[] candidates = input[0];
                int target = input[1][0];
                System.out.printf("candidates = %s, target = %d \n", Arrays.toString(candidates), target);
                List<List<Integer>> result = new Solution().combinationSum(candidates, target);
                for (List<Integer> solution: result) {
                    System.out.println("solution = " + solution);
                }
                System.out.println("-------------------");
            }
        }
    }
}
