package leetcode;

import util.TreeUtil;
import util.TreeUtil.TreeNode;

/**
 * @No          124
 * @problem     Binary Tree Maximum Path Sum
 * @level       Hard
 * @desc        二叉树的最大路径和
 * @author      liyazhou1
 * @date        2019/10/01
 *
 * <pre>
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
 * </pre>
 */
public class _0124_BinaryTreeMaximumPathSum {


    /**
     * Note
     *
     * Thought
     *
     *
     * Challenge
     *      递归返回条件和递归递进条件
     *
     * Algorithm
     *      1. A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps.
     *          Once it goes down, it can't go up. Each path has a highest node,
     *          which is also the lowest common ancestor of all other nodes on the path.
     *      2. A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum
     *          with highest node is the input node, update maximum if necessary (2) returns the maximum sum of the path
     *          that can be extended to input node's parent.
     *      @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java">leetcode discuss reference</a>
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        int maxValue = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxPathDown(root);
            return maxValue;
        }

        private int maxPathDown(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // 当前结点左分支的最大和
            int leftSum = Math.max(maxPathDown(root.left), 0);

            // 当前结点右分支的最大和
            int rightSum = Math.max(maxPathDown(root.right), 0);

            maxValue = Math.max(maxValue, root.val+leftSum+rightSum);

            return Math.max(leftSum, rightSum) + root.val;
        }

        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithThreeLevel(-20,
                    9, 20,
                    null, null, 15, 7);
            TreeUtil.visitByLevel(root);
            int result = new Solution().maxPathSum(root);
            System.out.println("result = " + result);
        }
    }
}
