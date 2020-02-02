package offerV2;


import offerV2.common.TreeNode;

/**
 * @No          v2-0
 * @problem     树的子结构
 * @tag         二叉树、递归
 * @author      liyazhou1
 * @date        2017/5/26
 *
 * <pre>
 *      输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
 *      二叉树的定义如下：
 * </pre>
 */
public class _026_Sub_Tree {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 递归
     *      2. 第一，判断 A 的根结点和 B 的根结点是否相等
     *         如果不相等，判断 A 的左孩子和 B 的根结点是否相等
     *         如果不相等，判断 A 的右孩子和 B 的根结点是否相等
     *         递归执行，直到找到与 B 的根结点相等的结点 R
     *
     *         第二，判断 B 的左右孩子结点和 R 的左右孩子结点是否分别相等
     *         如果不相等，返回 false
     *         如果相等，则递归判断对应的后代结点是否相等
     */
    private static class Solution {

        /**
         * 判断一个树中是否包含另一个树的结构，其中两个树的的根结点相等
         * @param root1 树 1 的根结点
         * @param root2 树 2 的根结点
         * @return 包含返回 true， 不包含返回 false
         */
        private static boolean contains(TreeNode root1, TreeNode root2){
            // 1. 递归终止条件
            if (root2 == null) return true;   // 树 2 遍历结束
            if (root1 == null) return false;  // 树 1 遍历结束，而树 2 还没有遍历结束
            if (root1.val != root2.val) return false;  // 存在对应的结点不相等的情况

            // 2. 递归操作
            return contains(root1.left, root2.left) && contains(root1.right, root2.right);
        }


        /**
         * 判断一个树中是否包含另一个树的结构
         * @param root1 树1的根结点
         * @param root2 树2的根结点
         * @return 包含返回 true，不包含返回 false
         */
        public static boolean hasSubtree(TreeNode root1, TreeNode root2){
            // if (root1 == null || root2 == null) throw new RuntimeException("Invalid input.");

            boolean contains = false;
            if (root1 != null && root2 != null){
                // 递归终止条件，
                // 找到和第二棵树的根结点root2相等的结点
                // 判断以当前结点为根结点的子树是否包含以 root2 为根结点的树
                if (root1.val == root2.val) contains = contains(root1, root2);

                // 如果当前结点和root2 "不相等"（以当前结点为根结点的子树不包含以 root2 为根结点的树），
                // 则判断左孩子结点和 root2 是否相等
                if (!contains) contains = hasSubtree(root1.left, root2);
                // 如果当前结点和root2 "不相等"（以当前结点为根结点的子树不包含以 root2 为根结点的树），
                // 则判断右孩子结点和 root2 是否相等
                if (!contains) contains = hasSubtree(root1.right, root2);
            }

            return contains;
        }
    }
}
