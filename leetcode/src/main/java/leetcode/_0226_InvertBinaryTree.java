package leetcode;

import util.TreeNode;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/9/7
 */
public class _0226_InvertBinaryTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                invertTree(root.left);
                invertTree(root.right);
            }
            return root;
        }
    }

}
