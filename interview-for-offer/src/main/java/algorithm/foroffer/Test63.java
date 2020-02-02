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


class BinTreeNode63 {
    int value;
    BinTreeNode27 left;
    BinTreeNode27 right;
    public BinTreeNode63(int _value){ value = _value; }
    public void setChildren(BinTreeNode27 _left, BinTreeNode27 _right){
        left = _left;
        right = _right;
    }
}


public class Test63 {

    public BinTreeNode27 kthNode(BinTreeNode27 root, int[] k){
        BinTreeNode27 kthNode = null;
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
        BinTreeNode27 node8 = new BinTreeNode27(8);
        BinTreeNode27 node6 = new BinTreeNode27(6);
        BinTreeNode27 node10 = new BinTreeNode27(10);
        BinTreeNode27 node5 = new BinTreeNode27(5);
        BinTreeNode27 node7 = new BinTreeNode27(7);
        BinTreeNode27 node9 = new BinTreeNode27(9);
        BinTreeNode27 node11 = new BinTreeNode27(11);

        node8.setChildren(node6, node10);
        node6.setChildren(node5, node7);
        node10.setChildren(node9, node11);

        BinTreeNode27 node = kthNode(node8, new int[]{3});
        System.out.println(node.value);
    }
}
