package leetcode;

import org.junit.Test;
import util.TreeUtil;
import util.TreeUtil.TreeNode;

/**
 * @No          617
 * @problem     Merge Two Binary Trees
 * @level       Easy
 * @desc        合并二叉树
 * @author      liyazhou1
 * @date        2019/9/7
 *
 * <pre>
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 *
 * Note: The merging process must start from the root nodes of both trees.
 * </pre>
 */
public class _0617_MergeTwoBinaryTrees {


    /**
     * Note
     *
     * Thought
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) return t2;
            if (t2 == null) return t1;
            /* 合并根节点 */
            t1.val += t2.val;
            /* 递归合并左右子树 */
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }


        @Test
        public void test01() {
            TreeUtil.TreeNode tree1 = TreeUtil.generateTreeWithThreeLevel(
                    1,
                    3, 2,
                    5, null, null, null
            );
            TreeUtil.TreeNode tree2 = TreeUtil.generateTreeWithThreeLevel(
                    2,
                    1, 3,
                    null, 4, null, 7
            );
            TreeUtil.visitByLevel(tree1);
            System.out.println();
            TreeUtil.visitByLevel(tree2);
            System.out.println();
            mergeTrees(tree1, tree2);
            TreeUtil.visitByLevel(tree1);
            System.out.println();
        }
    }

}
