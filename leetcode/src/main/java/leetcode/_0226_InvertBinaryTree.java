package leetcode;

import util.TreeUtil.TreeNode;

/**
 * @No          226
 * @problem     Invert Binary Tree
 * @level       Easy
 * @desc        翻转二叉树
 * @author      liyazhou1
 * @date        2019/9/7
 *
 * <pre>
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 * </pre>
 */
public class _0226_InvertBinaryTree {


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

        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                invertTree(root.left);
                invertTree(root.right);
            }
            return root;
        }
    }

}
