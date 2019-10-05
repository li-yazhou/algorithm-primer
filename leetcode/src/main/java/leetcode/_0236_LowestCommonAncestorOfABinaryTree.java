package leetcode;

import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @No          236
 * @problem     Lowest Common Ancestor of a Binary Tree
 * @level       Medium
 * @desc        二叉树的最近公共祖先
 * @author      liyazhou1
 * @date        2019/10/04
 *
 * <pre>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *                3
 *              /  \
 *            5     1
 *          / \    / \
 *         6   2  0  8
 *            / |
 *           7  4
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 * </pre>
 */
public class _0236_LowestCommonAncestorOfABinaryTree {


    /**
     * Note
     *
     * Thought
     *      转化问题为，查找两条链表中最后一个相同的结点
     *
     * Challenge
     *      查找树中两个结点之间的路径
     *
     * Algorithm
     *      1. 分别查找根节点到两个结点之间的路径；
     *      2. 查找两路径中最后一个相同的结点；
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> p1 = new ArrayList<>();
            List<TreeNode> p2 = new ArrayList<>();

            nodeToNodePath(root, p, p1);
            nodeToNodePath(root, q, p2);
            // printList(p1);
            // printList(p2);

            int i = 1;
            for (; i < p1.size() && i < p2.size(); i ++) {
                // 存在不相同的结点
                if (p1.get(i-1) == p2.get(i-1) && p1.get(i) != p2.get(i)) {
                    return p1.get(i - 1);
                }
            }
            // 不存在不同的结点，两个链表长度不等
            if (i == p1.size() || i == p2.size()) {
                if (p1.get(i-1) == p2.get(i-1)) {
                    return p1.get(i-1);
                }
            }

            return null;
        }


        private boolean nodeToNodePath(TreeNode start, TreeNode end, List<TreeNode> path) {
            path.add(start);

            if (start == end) {
                return true;
            }

            boolean found = false;
            if (start != null) {
                found = nodeToNodePath(start.left, end, path) || nodeToNodePath(start.right, end, path);
            }

            if (!found) {
                path.remove(path.size()-1);
            }
            return found;
        }

        private static void printList(List<TreeNode> list) {
            for (int i = 0; i < list.size(); i ++) {
                System.out.print(list.get(i).val + "\t");
            }
            System.out.println();
        }
        public static void main(String[] args) {
            TreeUtil.generateTreeWithLevel(3,
                    5, 1,
                    6, 2, 0, 8,
                    null, null, 7, 4, null, null, null, null
            );

            TreeNode node11 = new TreeNode(3);
            TreeNode node21 = new TreeNode(5);
            TreeNode node22 = new TreeNode(1);
            TreeNode node31 = new TreeNode(6);
            TreeNode node32 = new TreeNode(2);
            TreeNode node33 = new TreeNode(0);
            TreeNode node34 = new TreeNode(8);
            TreeNode node43 = new TreeNode(7);
            TreeNode node44 = new TreeNode(4);

            node11.left = node21;
            node11.right = node22;
            node21.left = node31;
            node21.right = node32;
            node22.left = node33;
            node22.right = node34;
            node32.left = node43;
            node32.right = node44;


            List<TreeNode> path = new ArrayList<>();
            new Solution().nodeToNodePath(node11, node44, path);
            printList(path);

            TreeNode commonNode = new Solution().lowestCommonAncestor(node11, node21, node44);
            System.out.println("commonNode = " + commonNode.val);
        }

    }
}
