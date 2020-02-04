package offerV2;

import offerV2.common.TreeNode;

/**
 * @No          v2-055,v1-039
 * @problem     平衡二叉树
 * @tag         二叉树、二叉树的遍历
 * @author      liyazhou
 * @date        2017-05-31
 *
 * <pre>
 *      输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 *      如果某二叉树中的任意结点的左右子树的深度相差不超过 1， 那么它就是一棵平衡二叉树。
 *      例如，下图中的二叉树就是一棵平衡二叉树。
 *                      1
 *                    /   \
 *                  2      3
 *                /  \      \
 *              4     5      6
 *                   /
 *                  7
 * </pre>
 */
public class _055_Balance_Tree_Check {


    /**
     * Note
     *
     * Thought
     *      1. 从叶子节点递归到"根结点"，求出一条路径的长度
     *
     * Algorithm
     *      1.
     *      2.
     */
    private static class Solution {


        public int depthOfBinTree(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int left = depthOfBinTree(root.left);
            int right = depthOfBinTree(root.right);

            return Math.max(left, right) + 1;
        }

        /**
         * 判断一个二叉树是否是平衡二叉树
         */
        public boolean isBalancedBinTree(TreeNode root){
            // 递归终止条件一，遍历到叶子结点
            if (root == null) return true;

            int left = depthOfBinTree(root.left);
            int right = depthOfBinTree(root.right);

            // 递归终止条件二，存在结点的左右子树的深度相差超过 1
            if (Math.abs(left - right) > 1) {
                return false;
            }
            return isBalancedBinTree(root.left) && isBalancedBinTree(root.right);
        }




        // 存在一个反例即为非平衡二叉树
        private boolean isBalanced = true;
        public boolean checkBalancedTree(TreeNode root) {
            checkSubTreeDepth(root);
            return isBalanced;
        }

        private int checkSubTreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = checkSubTreeDepth(root.left);
            int right = checkSubTreeDepth(root.right);
            if (Math.abs(left - right) > 1) {
                isBalanced = false;
                return -1;
            }
            return Math.max(left, right) + 1;
        }

    }
}
