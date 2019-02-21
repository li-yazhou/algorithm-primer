package algorithm.foroffer;

import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题25：二叉树中和为某一值的路径
 *
 * 题目：
 *      输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *      从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。二叉树的定义如下：
 *
 * 问题：
 *      1. 前序遍历二叉树
 *      2. 栈
 *
 * 思路：
 *      1. 前序遍历二叉树，并把当前结点的值入栈
 *         如果当前结点是叶子结点，判断栈中的所有元素之和是否为指定值，如果是，则输出该路径，否则不操作
 *         如果当前结点的左孩子不是叶子结点，则前序遍历以该结点的左孩子为根结点的子树
 *         如果当前结点的右孩子不是叶子结点，则前序遍历以该结点的右孩子为根结点的子树
 *
 *         在返回到父结点之前，在路径上删除当前节点（从栈中弹出该结点）
 *
 */

class TreeNode25{
    int value;
    TreeNode25 left;
    TreeNode25 right;
    public TreeNode25(int value){ this.value = value; }
    public void setChildren(TreeNode25 left, TreeNode25 right){
        this.left = left;
        this.right = right;
    }
}

public class Test25 {

    public static void findPath(TreeNode25 root, int expectedSum){
        if (root == null) return;
        Stack<Integer> stack = new Stack<>();
        findPath(root, stack, expectedSum);
    }

    /**
     * 查找符合条件的路径
     * 前序遍历二叉树
     * @param root 二叉树的根结点
     * @param stack 存储结点的值
     * @param expectedSum 路径上各个元素之和的期望值
     */
    private static void findPath(TreeNode25 root, Stack<Integer> stack, int expectedSum){
        // 前序遍历的操作
        stack.push(root.value);
        // 当前结点为叶子结点时，判断从根结点到该叶子结点的路径上所有元素的值之和
        if (root.left == null && root.right == null){
            int sum = 0;
            // for(int i = 0; i < stack.size(); i++) sum += stack.get(i);
            for (int value : stack) sum += value;
            if (sum == expectedSum) System.out.println(stack);
        }

        // 对当前结点的左孩子的递归操作
        if (root.left != null) findPath(root.left, stack, expectedSum);
        // 对当前结点的右孩子的递归操作
        if (root.right != null) findPath(root.right, stack, expectedSum);

        // todo, 返回到父结点之前，在路径上删除当前结点
        stack.pop();
    }

    public static void main(String[] args){
        TreeNode25 root = generateTree();
        findPath(root, 22);
    }

    private static TreeNode25 generateTree() {
        TreeNode25 node0 = new TreeNode25(10);
        TreeNode25 node1 = new TreeNode25(5);
        TreeNode25 node2 = new TreeNode25(12);
        TreeNode25 node3 = new TreeNode25(4);
        TreeNode25 node4 = new TreeNode25(7);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);

        return node0;
    }
}
