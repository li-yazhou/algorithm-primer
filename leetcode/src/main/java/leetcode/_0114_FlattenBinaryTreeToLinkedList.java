package leetcode;

import util.TreeUtil;
import util.TreeUtil.TreeNode;

/**
 * @No          114
 * @problem     Flatten Binary Tree to Linked List
 * @level       Medium
 * @desc        二叉树展开为链表
 * @author      liyazhou1
 * @date        2019/10/01
 *
 * <pre>
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * </pre>
 */
public class _0114_FlattenBinaryTreeToLinkedList {


    /**
     * Note
     *
     * Thought
     *      二叉树的先序遍历
     *
     * Challenge
     *      旋转链表
     *
     * Algorithm
     *      1. 设置curr指向root结点；
     *      2. while (curr != null)
     *              若curr存在左孩子结点
     *                  找到其最右孩子结点rightmost；
     *                  令rightmost指向curr的右孩子结点；
     *                  令当前结点curr的右孩子指向其左孩子结点；
     *                  令当前结点curr的左孩子结点为null；
     *              令curr指向其右孩子结点；
     *      3. 结束。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode rightmost = curr.left;
                    while (rightmost.right != null) {
                        rightmost = rightmost.right;
                    }
                    rightmost.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }
                curr = curr.right;
            }
        }

        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithThreeLevel(1,
                    2, 5,
                    3, 4, 6, 7);
            TreeUtil.visitByLevel(root);

            new Solution().flatten(root);

            TreeUtil.visitByLevel(root);
            TreeNode curr = root;
            while (curr != null) {
                System.out.print(curr.val + "\t");
                curr = curr.right;
            }

        }
    }
}
