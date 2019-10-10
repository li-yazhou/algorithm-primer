package leetcode;

import util.TreeUtil.TreeNode;
/**
 * @No          437
 * @problem     Path Sum III
 * @level       Easy
 * @desc        路径总和III
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * </pre>
 */
public class _0437_PathSumIII {


    /**
     * Note
     *
     * Thought
     *      递归
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

        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return pathNum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int pathNum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            sum -= root.val;
            int num = sum == 0 ? 1 : 0;
            return num + pathNum(root.left, sum) + pathNum(root.right, sum);
        }
    }
}
