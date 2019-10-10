package leetcode;

import util.TreeUtil.TreeNode;
/**
 * @No          543
 * @problem     Diameter of Binary Tree
 * @level       Easy
 * @desc        二叉树的直径
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * </pre>
 */
public class _0543_DiameterOfBinaryTree {


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

        private int max = -1;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int diameter = depth(root.left) + depth(root.right);
            max = Math.max(diameter, max);
            diameterOfBinaryTree(root.left);
            diameterOfBinaryTree(root.right);
            return max;
        }


        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }



        int maxVal = 0;
        public int diameterOfBinaryTree1(TreeNode root) {
            maxDepth(root);
            return maxVal;
        }

        private int maxDepth(TreeNode root){
            if (root == null) return 0;
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            maxVal = Math.max(maxVal, l+r);
            return Math.max(l, r) + 1;
        }
    }
}
