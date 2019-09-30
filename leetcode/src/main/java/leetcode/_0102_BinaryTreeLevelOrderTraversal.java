package leetcode;

import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @No          102
 * @problem     Binary Tree Level Order Traversal
 * @level       Medium
 * @desc        二叉树的层次遍历
 * @author      liyazhou1
 * @date        2019/09/30
 *
 * <pre>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * </pre>
 */
public class _0102_BinaryTreeLevelOrderTraversal {


    /**
     * Note
     *
     * Thought
     *      队列
     *
     * Challenge
     *      使用两个整数表示当前行元素的个数、下一行元素的个数
     *
     * Algorithm
     *      1.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int currLevelNum = 1;
            int nextLevelNum = 0;
            LinkedList<Integer> currLineResult = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode head = queue.poll();

                if (head.left != null) {
                    queue.offer(head.left);
                    nextLevelNum ++;
                }

                if (head.right != null) {
                    queue.offer(head.right);
                    nextLevelNum ++;
                }

                currLineResult.add(head.val);
                currLevelNum --;
                if (currLevelNum == 0) {
                    result.add(currLineResult);
                    currLineResult = new LinkedList<>();

                    currLevelNum = nextLevelNum;
                    nextLevelNum = 0;
                }
            }
            return result;
        }

        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithThreeLevel(1,
                    2, 3,
                    4, 5, 6, 7);
            List<List<Integer>> levelOrder = new Solution().levelOrder(root);
            System.out.println("levelOrder = \n" + levelOrder);
        }
    }
}
