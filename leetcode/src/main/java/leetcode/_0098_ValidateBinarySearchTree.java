package leetcode;

import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.Stack;

/**
 * @No          98
 * @problem     Validate Binary Search Tree
 * @level       Medium
 * @desc        验证二叉搜索树
 * @author      liyazhou1
 * @date        2019/09/30
 *
 * <pre>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's val.
 * The right subtree of a node contains only nodes with keys greater than the node's val.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 *
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * </pre>
 */
public class _0098_ValidateBinarySearchTree {


    /**
     * Note
     *
     * Thought
     *      非递归中序遍历，使用栈
     *
     * Challenge
     *      基本功
     *
     * Algorithm
     *      1. 非递归中序遍历
     *          比较前一个元素的值pre与当前元素的值curr的大小，若 pre >= curr 则返回false；
     *      2. 遍历结束表示没有返回false，则返回true，即当前二叉树是BST。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {


        public boolean isValidBST(TreeNode root) {

            if (root == null) {
                return true;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            long pre = Long.MIN_VALUE;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();
                if (curr.val <= pre) {
                    return false;
                }
                pre = curr.val;
                curr = curr.right;
            }
            return true;
        }


        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithThreeLevel(3,
                    1, 4,
                    0, 2, 2, 5);
            TreeUtil.visitByLevel(root);
            boolean result = new Solution().isValidBST(root);
            System.out.println("result = " + result);
            System.out.println("------------------");

            TreeNode root1 = TreeUtil.generateTreeWithThreeLevel(3,
                    1, 5,
                    0, 2, 4, 6);
            TreeUtil.visitByLevel(root1);
            boolean result1 = new Solution().isValidBST(root1);
            System.out.println("result = " + result1);
            System.out.println("------------------");

            TreeNode root2 = TreeUtil.generateTreeWithThreeLevel(1,
                    1, null,
                    null, null, null, null);
            TreeUtil.visitByLevel(root2);
            boolean result2 = new Solution().isValidBST(root2);
            System.out.println("result = " + result2);

        }
    }

    /**
     * Note
     *      note
     *
     * Thought
     *      递归
     *
     * Challenge
     *      交叉传递上下边界
     *
     * Algorithm
     *      1.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution1 {

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean validateBST(TreeNode root, int lower, int upper) {
            if (root == null) {
                return true;
            }

            if (root.val <= lower || root.val >= upper) {
                return false;
            }

            return validateBST(root.left, lower, root.val) && validateBST(root.right, root.val, upper);
        }


        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithThreeLevel(3,
                    1, 4,
                    0, 2, 2, 5);
            TreeUtil.visitByLevel(root);
            boolean result = new Solution1().isValidBST(root);
            System.out.println("result = " + result);
            System.out.println("------------------");

            TreeNode root1 = TreeUtil.generateTreeWithThreeLevel(3,
                    1, 5,
                    0, 2, 4, 6);
            TreeUtil.visitByLevel(root1);
            boolean result1 = new Solution1().isValidBST(root1);
            System.out.println("result = " + result1);
            System.out.println("------------------");

            TreeNode root2 = TreeUtil.generateTreeWithThreeLevel(1,
                    1, null,
                    null, null, null, null);
            TreeUtil.visitByLevel(root2);
            boolean result2 = new Solution1().isValidBST(root2);
            System.out.println("result = " + result2);

        }
    }
}
