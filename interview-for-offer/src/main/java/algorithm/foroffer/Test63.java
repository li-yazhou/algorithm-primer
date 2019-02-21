package algorithm.foroffer;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-08 19:42
 * 面试题63：二叉搜索树的第 k 个结点
 *
 * 题目：
 *      给定一棵二叉搜索树，请找出其中的第 k 大的结点。
 *      例如下面的二叉树中，按结点数值大小升序顺序，第三个结点的值是 7。
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 *
 * 考查点：
 *      1. 二叉搜索树
 *      2. 二叉树的中序遍历
 *      3. 递归，递归中状态变量的设置
 */


class BinTreeNode{
    int value;
    BinTreeNode left;
    BinTreeNode right;
    public BinTreeNode(int _value){ value = _value; }
    public void setChildren(BinTreeNode _left, BinTreeNode _right){
        left = _left;
        right = _right;
    }
}


public class Test63 {

    public BinTreeNode kthNode(BinTreeNode root, int[] k){
        BinTreeNode kthNode = null;
        if (root.left != null) kthNode = kthNode(root.left, k);  // 左子树的遍历
        // System.out.println("--------" + k[0]);
        if (kthNode == null){  // 中序遍历的操作
            k[0] --;
            if (k[0] == 0) kthNode = root;
        }
        if (kthNode == null && root.right != null)  // 右子树的遍历
            kthNode = kthNode(root.right, k);
        return kthNode;
    }


    @Test
    public void test(){
        BinTreeNode node8 = new BinTreeNode(8);
        BinTreeNode node6 = new BinTreeNode(6);
        BinTreeNode node10 = new BinTreeNode(10);
        BinTreeNode node5 = new BinTreeNode(5);
        BinTreeNode node7 = new BinTreeNode(7);
        BinTreeNode node9 = new BinTreeNode(9);
        BinTreeNode node11 = new BinTreeNode(11);

        node8.setChildren(node6, node10);
        node6.setChildren(node5, node7);
        node10.setChildren(node9, node11);

        BinTreeNode node = kthNode(node8, new int[]{3});
        System.out.println(node.value);
    }
}
