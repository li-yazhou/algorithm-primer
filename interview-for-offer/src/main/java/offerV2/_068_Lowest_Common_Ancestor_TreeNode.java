package offerV2;

import offerV2.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @No          v2-068,v1-050
 * @problem     树中两个节点的最低公共祖先节点
 * @tag         二叉树、递归
 * @author      liyazhou
 * @date        2017-06-04
 *
 * <pre>
 *  树中两个结点的最低公共祖先
 * </pre>
 */
public class _068_Lowest_Common_Ancestor_TreeNode {


    /**
     * Note
     *
     * Thought
     *      1. 树的遍历
     *      2. 知识迁移能力，将问题转化为已有解决方法的问题
     *
     * Algorithm
     *      1. 遍历树，找到根结点到指定结点的路径，是单向链表
     *      2. 从头到尾找到两条单向链表的最后一个公共结点
     *
     *
     *               0
     *              / \
     *            1    2
     *          /  \
     *         3    4
     *       / \   / | \
     *      5  6  7  8  9
     */
    private static class Solution {


        /**
         * 二叉搜索树中两个节点的第一个公共节点
         *
         * 二叉搜索树中，节点p、q的第一个公共祖先节点满足 node.val >= p.val && node.val <= q.val (if p.val <= q.val)
         */
        public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return root;
            }

            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestorForBST(root.left, p, q);
            }

            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestorForBST(root.right, p, q);
            }

            return root;
        }



        /**
         * 找根结点到目标结点的路径
         * @param path 从根结点到目标结点的路径
         * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
         */
        private boolean getNodePath(TreeNode root, TreeNode target, List<TreeNode> path){
            // 添加当前结点
            path.add(root);

            if (root == target) return true;

            boolean found = false;

            // 处理孩子结点
            found = getNodePath(root.left, target, path) || getNodePath(root.right, target, path);

            if (!found) path.remove(path.size()-1);

            return found;
        }


        /**
         * 找两个链表的最后一个相同的结点
         * @return 两个链表的最后一个相同的结点
         */
        private TreeNode getLastCommonNode(List<TreeNode> head1, List<TreeNode> head2){
            for (int i = 1; i < head1.size() && i < head2.size(); i ++){
                if (head1.get(i).val != head2.get(i).val
                        && head1.get(i-1).val == head2.get(i-1).val) {
                    return head1.get(i - 1);
                }
            }
            return null;
        }


        /**
         * 根据树的根结点和树中的两个结点，找到这两个结点的最低公共祖先结点
         * @param root 树的根结点
         * @return 两个结点的最低公共祖先结点
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) return null;

            List<TreeNode> path1 = new ArrayList<>();
            List<TreeNode> path2 = new ArrayList<>();
            getNodePath(root, p, path1);
            getNodePath(root, q, path2);

            return getLastCommonNode(path1, path2);
        }
    }
}
