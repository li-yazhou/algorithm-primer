package leetcode;

import util.TreeUtil.TreeNode;
/**
 * @No          110
 * @problem     Balanced Binary Tree
 * @level       Medium
 * @desc        平衡二叉树
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Return true.
 *
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * Return false.
 * </pre>
 */
public class _0110_BalancedBinaryTree {


    /**
     * Note
     *
     * Thought
     *      递归
     *          算法基础是递归二叉树的深度
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

        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;

            int l = depth(root.left);
            int r = depth(root.right);

            if (Math.abs(l-r) > 1) return false;
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int depth(TreeNode root){
            if (root == null) return 0;
            int l = depth(root.left);
            int r = depth(root.right);
            return Math.max(l, r) + 1;
        }
    }
}
