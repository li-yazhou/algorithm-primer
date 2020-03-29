package problem.tree;

import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @problem     二叉树的俯视图
 * @tag         二叉树
 * @author      liyazhou1
 * @date        2020/03/29
 *
 * <pre>
 *
 *      二叉树的俯视图，从左到右打印节点的值
 *            1
 *           / \
 *          2   3
 *          \    \
 *           4    5
 *
 *      打印【2, 1, 3, 5，因为节点4在节点1的正下方，俯视图看不到节点4，所以不打印节点4.
 *
 * </pre>
 */
public class TreeViewFromTop {


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
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        private Integer[] memo = null;

        public List<Integer> treePlanform(TreeNode root) {
            if (root == null) {
                Collections.emptyList();
            }

            int len = depth(root) * 2;
            memo = new Integer[len];

            int indexForRoot = len / 2;
            dfs(root, indexForRoot);

            List<Integer> result = new ArrayList<>();
            for (Integer element : memo) {
                if (element != null) {
                    result.add(element);
                }
            }
            return result;
        }

        private void dfs(TreeNode root, int index) {
            if (root == null) {
                return;
            }
            System.out.println("node = " + root.val + ", index = " + index);

            if (memo[index] == null) {
                memo[index] = root.val;
            }

            dfs(root.left, index-1);
            dfs(root.right, index+1);
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }


        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithLevel(
                    1,
                    2, 3,
                    null, 4, null, 5
            );

            TreeUtil.visitByLevel(root);

            List<Integer> result = new Solution().treePlanform(root);
            System.out.println("result = " + result);

            TreeNode root1 = TreeUtil.generateTreeWithLevel(
                    1,
                    2, 3,
                    4, 5, 6, 7
            );

            TreeUtil.visitByLevel(root1);

            List<Integer> result1 = new Solution().treePlanform(root1);
            System.out.println("result1 = " + result1);
        }

    }
}
