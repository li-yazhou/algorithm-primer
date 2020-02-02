package offerV2;

import offerV2.common.TreeNode;

/**
 * @No          v2-027,v1-019
 * @problem     二叉树的镜像
 * @tag         二叉树、递归
 * @author      liyazhou1
 * @date        2017/5/27
 *
 * <pre>
 * 请完成一个函数，输入一个二叉树，该函数输出它们的镜像。
 * </pre>
 */
public class _027_Mirror_BinTree {


    /**
     * Note
     *
     * Thought
     *      1. 前序遍历二叉树，递归
     *      2. 树中的指针操作
     *
     * Algorithm
     *      1. 前序遍历二叉树
     *          如果当前结点有两个子结点，则交换它们的位置
     */
    private static class Solution {
        public static void mirrorOfBinTree(TreeNode root){
            // 递归终止条件
            if (root == null) return;

            // 针对本次递归的操作
            TreeNode tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;

            mirrorOfBinTree(root.left);
            mirrorOfBinTree(root.right);
        }
    }
}
