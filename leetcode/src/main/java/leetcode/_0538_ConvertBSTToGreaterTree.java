package leetcode;

import util.TreeUtil.TreeNode;
/**
 * @No
 * @problem
 * @level
 * @desc
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * </pre>
 */
public class _0538_ConvertBSTToGreaterTree {


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
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public TreeNode convertBST(TreeNode root) {
            inorderVisit(root, new int[]{0});
            return root;
        }

        private void inorderVisit(TreeNode root, int[] rightSum) {
            if (root == null) {
                return;
            }
            inorderVisit(root.right, rightSum);
            root.val += rightSum[0];
            rightSum[0] = root.val;
            inorderVisit(root.left, rightSum);
        }
    }
}
