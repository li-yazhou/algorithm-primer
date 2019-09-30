package leetcode;



import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @No          94
 * @problem     Binary Tree Inorder Traversal
 * @level       Medium
 * @desc        二叉树的中序遍历
 * @author      liyazhou1
 * @date        2019/09/29
 *
 * <pre>
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * </pre>
 */
public class _0094_BinaryTreeInorderTraversal {


    /**
     * Note
     *
     * Thought
     *      莫里斯中序遍历
     *          根节点右旋遍历法
     *          每一步右旋之后的二叉树的中序遍历结果与原二叉树的中序遍历结果相同
     *
     * Challenge
     *      指针控制
     *
     * Algorithm
     *      1. 参数校验，若root为空，则返回空List；
     *      2. while (root != null)
     *              若根结点存在左孩子结点，则将该左孩子结点作为新的根结点，并将旧根结点作为新根结点的最右孩子结点的右孩子；
     *              若根结点不存在左孩子结点，则将当前根结点保存到List中，并将当前结点的右孩子结点作为新的根结点；
     *      3. 返回List，即结果集。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            if (root == null) {
                return inorder;
            }

            while (root != null) {
                if (root.left != null) {
                    TreeNode oldRoot = root;
                    TreeNode right = oldRoot.left;

                    while (right.right != null) {
                        right = right.right;
                    }
                    right.right = oldRoot;
                    root = oldRoot.left;
                    oldRoot.left = null;
                } else {
                    inorder.add(root.val);
                    root = root.right;
                }
            }

            return inorder;
        }


        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithLevel(1,
                    2, 3,
                    4, 5, 6, 7,
                    8, 9, 10, 11, 12, 13, 14, 15
            );

            TreeUtil.visitByLevel(root);

            List<Integer> result = new Solution().inorderTraversal(root);
            System.out.println("result = " + result);
        }
    }

    /**
     * Note
     *
     * Thought
     *      二叉树的中序遍历
     *          递归法
     *          使用栈
     *          莫里斯中序遍历，需要修改树的结构
     *
     * Challenge
     *
     *
     * Algorithm
     *      莫里斯中序遍历
     *      1. 若当前结点没有左孩子结点，则访问该结点
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution2 {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            if (root == null) {
                return inorder;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                inorder.add(curr.val);
                curr = curr.right;
            }

            return inorder;
        }


        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithLevel(1,
                    2, 3,
                    4, 5, 6, 7,
                    9, 10, 11, 12, 13, 14, 15, 16
            );

            TreeUtil.visitByLevel(root);

            List<Integer> result = new Solution2().inorderTraversal(root);
            System.out.println("result = " + result);
        }
    }


    /**
     * Note
     *
     * Thought
     *      二叉树的中序遍历，递归法
     *
     * Challenge
     *
     *
     * Algorithm
     *      1. 若当前结点为空，则返回；
     *      2. 若当前结点的左孩子结点为空，则递归递进该孩子结点；
     *      3. 访问当前结点；
     *      4. 若当前结点的右孩子结点为空，则递归递进该孩子结点
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution1 {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();

            inorderTraversal(inorder, root);

            return inorder;
        }

        private void inorderTraversal(List<Integer> inorder, TreeNode root) {
            if (root == null) {
                return;
            }

            inorderTraversal(inorder, root.left);

            inorder.add(root.val);

            inorderTraversal(inorder, root.right);
        }

        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithLevel(1,
                    2, 3,
                    4, 5, 6, 7,
                    9, 10, 11, 12, 13, 14, 15, 16
            );

            TreeUtil.visitByLevel(root);

            List<Integer> result = new Solution1().inorderTraversal(root);
            System.out.println("result = " + result);
        }
    }

}
