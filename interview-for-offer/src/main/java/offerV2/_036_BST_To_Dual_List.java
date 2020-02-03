package offerV2;

import offerV2.common.TreeNode;

/**
 * @No          v2-036,v1-027
 * @problem     二叉搜索树和双向链表
 * @tag         二叉搜索树、双向链表
 * @author      liyazhou
 * @date        2017/5/28
 *
 * <pre>
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *      比如输入下图中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *
 *                      10
 *                    /    \
 *                  6       14
 *                /  \     /  \
 *               4    8   12  16
 *
 *        4 === 6 === 8 === 10 === 12 === 14 === 16
 * </pre>
 */
public class _036_BST_To_Dual_List {


    /**
     * Note
     *
     * Thought
     *      1. 中序遍历二叉树
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        TreeNode pre = null;
        TreeNode head = null;

        public TreeNode convert(TreeNode root) {
            inOrder(root);
            return head;
        }


        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);

            node.left = pre;
            if (pre != null) {
                pre.right = node;
            }
            pre = node;
            if (head == null) {
                head = node;
            }

            inOrder(node.right);
        }
    }
}
