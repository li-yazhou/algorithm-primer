package algorithm.foroffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题23：从上往下打印二叉树
 *
 * 题目：
 *      从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 *      例如输入下图的二叉树，则依次打印出 8、6、10、5、7、9、11.
 *                  8
 *                /   \
 *              6      10
 *            /  \    /  \
 *           5   7   9   11
 *
 * 问题：
 *      1. 层次遍历二叉树
 *
 * 思路：
 *      1. 层次遍历二叉树，是广度优先搜索，需要使用队列
 *      2. 创建队列，并把根结点入队
 *         循环：队列不为空
 *              队列的首元素出队，并访问该元素
 *              如果当前元素的左孩子不为空，则入队
 *              如果当前元素的右孩子不为空，则入队
 */

class TreeNode23{
    int value;
    TreeNode23 left;
    TreeNode23 right;

    public TreeNode23(int value){ this.value = value; }

    public void setChildren(TreeNode23 left, TreeNode23 right) {
        this.left = left;
        this.right = right;
    }
}

public class Test23 {

    /**
     * 层次遍历二叉树
     * @param root 二叉树的根结点
     */
    public static void levelVisitTree(TreeNode23 root){
        if (root == null) return;

        Queue<TreeNode23> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()){
        for (queue.offer(root); !queue.isEmpty();){
            TreeNode23 currNode = queue.poll();
            System.out.print(currNode.value + "\t");

            if (currNode.left != null) queue.offer(currNode.left);
            if (currNode.right != null) queue.offer(currNode.right);
        }
    }

    public static void main(String[] args){
        TreeNode23 root = generateTree();
        Test23.levelVisitTree(root);
    }

    private static TreeNode23 generateTree() {
        TreeNode23 treeNode0 = new TreeNode23(8);

        TreeNode23 treeNode1 = new TreeNode23(6);
        TreeNode23 treeNode2 = new TreeNode23(10);

        TreeNode23 treeNode3 = new TreeNode23(5);
        TreeNode23 treeNode4 = new TreeNode23(7);
        TreeNode23 treeNode5 = new TreeNode23(9);
        TreeNode23 treeNode6 = new TreeNode23(11);

        treeNode0.setChildren(treeNode1, treeNode2);
        treeNode1.setChildren(treeNode3, treeNode4);
        treeNode2.setChildren(treeNode5, treeNode6);

        return treeNode0;
    }


}
