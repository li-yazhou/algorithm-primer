package algorithm.foroffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liyazhou on 2017/5/27.
 * 面试题19：二叉树的镜像
 *
 * 题目：
 *      请完成一个函数，输入一个二叉树，该函数输出它们的镜像。
 *
 * 问题：
 *      1. 前序遍历二叉树，递归
 *      2. 树中的指针操作
 *
 * 思路：
 *      1. 前序遍历二叉树
 *          如果当前结点有两个子结点，则交换它们的位置
 */


class TreeNode19{
    int value;
    TreeNode19 left;
    TreeNode19 right;

    public TreeNode19(int value){ this.value = value; }
    public void setChildren(TreeNode19 left, TreeNode19 right){
        this.left = left;
        this.right = right;
    }
}


public class Test19 {

    public static void mirrorOfBinTree(TreeNode19 root){
        // 递归终止条件
        if (root == null) return;

        // 针对本次递归的操作
        TreeNode19 tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        mirrorOfBinTree(root.left);
        mirrorOfBinTree(root.right);
    }


    public static void main(String[] args){
        TreeNode19 root = generateTree1();
        levelVisit(root);
        inorderVisit(root);
        System.out.println();
        mirrorOfBinTree(root);
        levelVisit(root);
        inorderVisit(root);

    }

    private static void inorderVisit(TreeNode19 root){
        if (root == null) return;
        inorderVisit(root.left);
        System.out.print(root.value + "-");
        inorderVisit(root.right);
    }


    private static void levelVisit(TreeNode19 root){
        if (root == null) return;
        Queue<TreeNode19> queue = new LinkedList<>();
        queue.add(root);  // queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode19 currNode = queue.poll();
            if (currNode.left != null)  queue.add(currNode.left); // queue.offer(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
            System.out.print(currNode.value + "-");
        }
        System.out.println();
    }

    private static TreeNode19 generateTree1() {
        TreeNode19 root0 = new TreeNode19(8);
        TreeNode19 root1 = new TreeNode19(6);
        TreeNode19 root2 = new TreeNode19(10);
        TreeNode19 root3 = new TreeNode19(5);
        TreeNode19 root4 = new TreeNode19(7);
        TreeNode19 root5 = new TreeNode19(9);
        TreeNode19 root6 = new TreeNode19(11);

        root0.setChildren(root1, root2);
        root1.setChildren(root3, root4);
        root2.setChildren(root5, root6);
        // root0.left = root1;
        // root1.left = root2;

        return root0;
    }

}




