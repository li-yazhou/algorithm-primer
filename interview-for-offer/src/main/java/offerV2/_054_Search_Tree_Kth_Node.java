package offerV2;

import offerV2.common.TreeNode;

/**
 * @No          v2-054,v1-063
 * @problem     二叉搜索树的第 k 个结点
 * @tag         二叉搜索树、中序遍历
 * @author      liyazhou
 * @date        2017-06-08
 *
 * <pre>
 *      给定一棵二叉搜索树，请找出其中的第 k 大的结点。
 *      例如下面的二叉树中，按结点数值大小升序顺序，第三个结点的值是 7。
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 * </pre>
 */
public class _054_Search_Tree_Kth_Node {


    /**
     * Note
     *
     * Thought
     *      1. 二叉搜索树
     *      2. 二叉树的中序遍历
     *      3. 递归，递归中状态变量的设置
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        private TreeNode ret = null;
        private int count = 0;


        public TreeNode kthNodeOfSearchTree(TreeNode root, int k) {
            inOrder(root, k);
            return ret;
        }


        private void inOrder(TreeNode node, int k) {
            if (node == null) {
                return;
            }
            inOrder(node.left, k);

            count ++;
            if (count == k) {
                ret = node;
                return;
            }

            inOrder(node.right, k);
        }


    }
}
