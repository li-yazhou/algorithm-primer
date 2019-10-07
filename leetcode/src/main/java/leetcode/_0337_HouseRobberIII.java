package leetcode;

import util.TreeUtil;
import util.TreeUtil.TreeNode;
/**
 * @No          337
 * @problem     House Robber III
 * @level       Medium
 * @desc        打家劫舍III
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * </pre>
 */
public class _0337_HouseRobberIII {


    /**
     * Note
     *
     * Thought
     *      DFS
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

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int val = 0;
                if (root.left != null) {
                    val += rob(root.left.left) + rob(root.left.right);
                }
                if (root.right != null) {
                    val += rob(root.right.left) + rob(root.right.right);
                }
                int robRoot = root.val + val;
                int notRobRoot = rob(root.left) + rob(root.right);
                return Math.max(robRoot, notRobRoot);
            }
        }

        public static void main(String[] args) {
            TreeNode root = null;
            int max = -1;

            root = TreeUtil.generateTreeWithThreeLevel(3,
                    2, 3,
                    null, 3, null, 1
            );
            TreeUtil.visitByLevel(root);
            max = new Solution().rob(root);
            System.out.println("max = " + max);
            System.out.println("----------------------");

            root = TreeUtil.generateTreeWithThreeLevel(3,
                    4, 5,
                    1, 3, null, 1
            );
            TreeUtil.visitByLevel(root);
            max = new Solution().rob(root);
            System.out.println("max = " + max);
        }
    }
}
