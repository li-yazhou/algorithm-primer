package offerV2;

import offerV2.common.TreeNode;

/**
 * @No          v2-028,v1-059
 * @problem     对称的二叉树
 * @tag         二叉树、递归
 * @author      liyazhou1
 * @date        2017-06-18
 *
 * <pre>
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。
 *      如果一棵二叉树和它的镜像一样，那么它是对称的。
 *      例如，下图中第一棵二叉树是对称的，另外两棵不是。
 *             8                  8                 7
 *           /   \              /   \             /   \
 *          6     6            6     9           7     7
 *         / \   / \          / \   / \         / \   /
 *        5  7  7   5        5  7  7   5       7  7  7
 * </pre>
 */
public class _028_Symmetrical_BinTree {


    /**
     * Note
     *
     * Thought
     *      1. 二叉树前序遍历的应用，先遍历左子树的前序遍历和先遍历右子树的前序遍历
     *      2. 对于像第三棵树这样的特殊情况，需要考虑叶子结点的孩子 null 才能，这一点至关重要
     *
     * Algorithm
     *      1.二叉树的前序遍历和对称前序遍历
     */
    private static class Solution {

        public boolean isSymmetrical (TreeNode root){
            return isSymmetrical (root, root);
        }

        public boolean isSymmetrical (TreeNode root1, TreeNode root2){
            if (root1 == null && root2 == null) return true;  // 唯一正确的出口

            // 一般情况下，不这么表示两者只有一个为空，但有上一句的限制，则可以使用
            if (root1 == null || root2 == null) return false;

            if (root1.val != root2.val) return false;

            return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
        }
    }
}
