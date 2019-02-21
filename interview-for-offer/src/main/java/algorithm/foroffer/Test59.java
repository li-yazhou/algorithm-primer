package algorithm.foroffer;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 19:48
 *
 * 面试题59：对称的二叉树
 *
 * 题目：
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。
 *      如果一棵二叉树和它的镜像一样，那么它是对称的。
 *      例如，下图中第一棵二叉树是对称的，另外两棵不是。
 *             8                  8                 7
 *           /   \              /   \             /   \
 *          6     6            6     9           7     7
 *         / \   / \          / \   / \         / \   /
 *        5  7  7   5        5  7  7   5       7  7  7
 *
 * 考查点：
 *      1. 二叉树前序遍历的应用，先遍历左子树的前序遍历和先遍历右子树的前序遍历
 *      2. 对于像第三棵树这样的特殊情况，需要考虑叶子结点的孩子 null 才能，这一点至关重要
 *
 * 思路：
 *      1.二叉树的前序遍历和对称前序遍历
 *
 */

class BinTreeNode59{
    int value;
    BinTreeNode59 left;
    BinTreeNode59 right;

    public BinTreeNode59 (int _value){ value = _value; }
    public void setChildren (BinTreeNode59 _left, BinTreeNode59 _right){
        left = _left;
        right = _right;
    }
}

public class Test59 {

    public boolean isSymmetrical (BinTreeNode59 root){
        return isSymmetrical (root, root);
    }

    public boolean isSymmetrical (BinTreeNode59 root1, BinTreeNode59 root2){
        if (root1 == null && root2 == null) return true;  // 唯一正确的出口

        // 一般情况下，不这么表示两者只有一个为空，但有上一句的限制，则可以使用
        if (root1 == null || root2 == null) return false;

        if (root1.value != root2.value) return false;

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }


    @Test
    /**
     *             8
     *           /   \
     *          6     6
     *         / \   / \
     *        5  7  7   5
     */
    public void test(){
        BinTreeNode59 node0 = new BinTreeNode59(8);
        BinTreeNode59 node1 = new BinTreeNode59(6);
        BinTreeNode59 node2 = new BinTreeNode59(6);
        BinTreeNode59 node3 = new BinTreeNode59(5);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);
        BinTreeNode59 node6 = new BinTreeNode59(5);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        System.out.println(isSymmetrical(node0));
    }

    @Test
    /**
     *          8
     *        /   \
     *       6     9
     *      / \   / \
     *     5  7  7   5
     */
    public void test1(){
        BinTreeNode59 node0 = new BinTreeNode59(8);
        BinTreeNode59 node1 = new BinTreeNode59(6);
        BinTreeNode59 node2 = new BinTreeNode59(9);
        BinTreeNode59 node3 = new BinTreeNode59(5);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);
        BinTreeNode59 node6 = new BinTreeNode59(5);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        System.out.println(isSymmetrical(node0));
    }

    @Test
    /**
     *          7
     *        /   \
     *       7     7
     *      / \   /
     *     7  7  7
     */
    public void test2(){
        BinTreeNode59 node0 = new BinTreeNode59(7);
        BinTreeNode59 node1 = new BinTreeNode59(7);
        BinTreeNode59 node2 = new BinTreeNode59(7);
        BinTreeNode59 node3 = new BinTreeNode59(7);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, null);

        System.out.println(isSymmetrical(node0));
    }


}
