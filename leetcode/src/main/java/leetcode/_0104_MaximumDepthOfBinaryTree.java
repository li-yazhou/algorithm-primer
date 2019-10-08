package leetcode;

/**
 * @No          104
 * @problem     Maximum Depth of Binary Tree
 * @level       Easy
 * @desc        二叉树的最大深度
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 * </pre>
 */
public class _0104_MaximumDepthOfBinaryTree {


    /**
     * Note
     *
     * Thought
     *      二叉树的最大深度
     *          方法一，递归
     *          方法二，层次遍历
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

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return Math.max(left, right)+1;
        }

        public int maxDepth0(TreeNode root) {
            if (root  == null) return 0;
            int leftDepth = maxDepth(root.left) + 1;
            int rightDepth = maxDepth(root.right) + 1;
            return leftDepth > rightDepth ? leftDepth : rightDepth;
        }
    }
}
