package algorithm.foroffer;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 15:32
 *
 * 面试题58：二叉树的下一个结点
 *
 * 题目：
 *      给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *      树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 *      例如，下图的中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
 *                  0
 *                /   \
 *               1     2
 *              / \   / \
 *             3  4  5   6
 *               / \
 *              7   8
 *
 *
 * 考查点：
 *      1. 二叉树的遍历
 *
 * 思路：
 *      1. 中序遍历序列，
 *         当前结点有右孩子，则其右子树的最左子结点即是下一个结点
 *         当前结点没有右孩子，而且是其父结点的左孩子，则其父结点即是下一个结点
 *         当前结点没有左孩子，而且是其父结点的右孩子，则其从下往上的祖先结点中是左孩子的结点即是下一个结点，可能不存在
 *
 */

class Node58{
    int value;
    Node58 parent;
    Node58 left;
    Node58 right;

    public Node58(int _value){ value = _value; }
    public void setParentAndChildren(Node58 _parent, Node58 _left, Node58 _right){
        parent = _parent;
        left = _left;
        right = _right;
    }
    @Override
    public String toString(){
        return String.format("value = %s", value);
    }
}

public class Test58 {

    public Node58 nextNode(Node58 node){
        if (node == null) return null;
        Node58 next = null;

        if (node.right != null){   // 当前结点有右孩子，则下一个结点是其右子树的最左子结点
            Node58 currNode = node.right;
            for (; currNode.left != null; currNode = currNode.left);
            next = currNode;
        } else if (node.parent != null){ // 当前结点没有右孩子，但存在父结点
            Node58 parentNode = node.parent;   // 初始默认当前结点是其父结点的左孩子，则下一个结点就是其父结点
            Node58 currNode = node;
            // 若当前结点是父结点的右孩子，则一直向上遍历，直到遇到其祖先结点是一个左孩子的情况
            // 该祖先结点的父结点的左子树已被遍历完成，则中序遍历的下一个结点就是其父结点
            while (parentNode != null && currNode == parentNode.right){
                currNode = parentNode;
                parentNode = parentNode.parent;
            }
            next = parentNode;
        }

        return next;
    }


    @Test
    /**
     *                  0
     *                /   \
     *               1     2
     *              / \   / \
     *             3  4  5   6
     *               / \
     *              7   8
     *
     * 其中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
     */
    public void test(){
        Node58 node0 = new Node58(0);
        Node58 node1 = new Node58(1);
        Node58 node2 = new Node58(2);
        Node58 node3 = new Node58(3);
        Node58 node4 = new Node58(4);
        Node58 node5 = new Node58(5);
        Node58 node6 = new Node58(6);
        Node58 node7 = new Node58(7);
        Node58 node8 = new Node58(8);

        node0.setParentAndChildren(null, node1, node2);
        node1.setParentAndChildren(node0, node3, node4);
        node2.setParentAndChildren(node0, node5, node6);
        node3.setParentAndChildren(node1, null, null);
        node4.setParentAndChildren(node1, node7, node8);
        node5.setParentAndChildren(node2, null, null);
        node6.setParentAndChildren(node2, null, null);
        node7.setParentAndChildren(node4, null, null);
        node8.setParentAndChildren(node4, null, null);

        System.out.println(0 + " -> " + nextNode(node0));
        System.out.println(1 + " -> " + nextNode(node1));
        System.out.println(2 + " -> " + nextNode(node2));
        System.out.println(3 + " -> " + nextNode(node3));
        System.out.println(4 + " -> " + nextNode(node4));
        System.out.println(5 + " -> " + nextNode(node5));
        System.out.println(6 + " -> " + nextNode(node6));
        System.out.println(7 + " -> " + nextNode(node7));
        System.out.println(8 + " -> " + nextNode(node8));

        /**
         0 -> value = 5
         1 -> value = 7
         2 -> value = 6
         3 -> value = 1
         4 -> value = 8
         5 -> value = 2
         6 -> null
         7 -> value = 4
         8 -> value = 0
         */
    }
}
