package offerV2;

import offerV2.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @No          v2-034,v1-025
 * @problem     二叉树中和为某一值的路径
 * @tag         二叉树、递归
 * @author      liyazhou1
 * @date        2017/5/28
 *
 * <pre>
 *      输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *      从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。二叉树的定义如下：
 * </pre>
 */
public class _034_Find_Path_Sum_In_BinTree {


    /**
     * Note
     *
     * Thought
     *      1. 前序遍历二叉树
     *      2. 栈
     *
     * Algorithm
     *      1. 前序遍历二叉树，并把当前结点的值入栈
     *         如果当前结点是叶子结点，判断栈中的所有元素之和是否为指定值，如果是，则输出该路径，否则不操作
     *         如果当前结点的左孩子不是叶子结点，则前序遍历以该结点的左孩子为根结点的子树
     *         如果当前结点的右孩子不是叶子结点，则前序遍历以该结点的右孩子为根结点的子树
     *
     *         在返回到父结点之前，在路径上删除当前节点（从栈中弹出该结点）
     */

    private static class Solution {

        private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        public void findPath(TreeNode root, int target){
            if (root == null) return;
            Stack<Integer> stack = new Stack<>();
            findPath(root, stack, target);
        }

        /**
         * 查找符合条件的路径
         * 前序遍历二叉树
         * @param root 二叉树的根结点
         * @param stack 存储结点的值
         * @param target 路径上各个元素之和的期望值
         */
        private void findPath(TreeNode root, Stack<Integer> stack, int target){
            // 前序遍历的操作
            stack.push(root.val);

            // 当前结点为叶子结点时，判断从根结点到该叶子结点的路径上所有元素的值之和
            if (root.left == null && root.right == null){
                int sum = 0;
                // for(int i = 0; i < stack.size(); i++) sum += stack.get(i);
                for (int value : stack) {
                    sum += value;
                }
                if (sum == target) {
                    ret.add(new ArrayList<Integer>(stack));
                    System.out.println(stack);
                }
            }

            // 对当前结点的左孩子的递归操作
            if (root.left != null) findPath(root.left, stack, target);
            // 对当前结点的右孩子的递归操作
            if (root.right != null) findPath(root.right, stack, target);

            // 返回到父结点之前，在路径上删除当前结点
            stack.pop();
        }
    }



    private static class Solution2 {

        private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
            backtracking(root, target, new ArrayList<Integer>());
            return ret;
        }

        private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
            if (node == null) {
                return;
            }

            path.add(node.val);
            target -= node.val;
            if (target == 0 && node.left == null && node.right == null) {
                ret.add(new ArrayList<Integer>(path));
            } else {
                backtracking(node.left, target, path);
                backtracking(node.right, target, path);
            }
            path.remove(path.size()-1);
        }
    }
}
