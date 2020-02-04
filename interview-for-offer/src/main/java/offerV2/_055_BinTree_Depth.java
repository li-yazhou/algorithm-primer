package offerV2;

import offerV2.common.TreeNode;

/**
 * @No          v2-055,v1-039
 * @problem     二叉树的深度
 * @tag         二叉树、二叉树的遍历
 * @author      liyazhou
 * @date        2017-05-31
 *
 * <pre>
 *      输入一棵二叉树的根结点。求该树的深度。从根结点到叶结点依次经过的结点
 *      （含根、叶结点）形成的树的一条路径，最长路径的长度为树的深度。
 * </pre>
 */
public class _055_BinTree_Depth {


    /**
     * Note
     *
     * Thought
     *      方法一，递归
     *      方法二，层次遍历
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
    }
}
