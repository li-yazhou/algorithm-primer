package algorithm.foroffer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-08 17:24
 *
 * 面试题60：把二叉树打印为多行
 *
 * 题目：
 *      从上到下按层打印二叉树，同一层的结点按从左到右顺序打印，
 *      每一层打印到一行。例如下面的二叉树的结果为：
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 *
 *       结果为：
 *       8
 *       6 10
 *       5 7 9 11
 *
 * 考查点：
 *      1. 树的层次遍历，属于广度优先遍历，使用的数据结构是队列
 *
 * 思路：
 *      1. 队列，
 *      2. 两个辅助变量，一个变量保存当前层还没有打印的结点数，
 *         另一个变量保存下一层结点的数目
 *
 */

class BinTreeNode{
    int value;
    BinTreeNode27 left;
    BinTreeNode27 right;
    public BinTreeNode(int _value){ value = _value; }
    public void setChildren(BinTreeNode27 _left, BinTreeNode27 _right){
        left = _left;
        right = _right;
    }
}

public class Test60 {

    public void printBinTree(BinTreeNode27 root){
        if (root == null) return;

        Queue<BinTreeNode27> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int thisLevel = 1;

        while (!queue.isEmpty()){
            BinTreeNode27 currNode = queue.poll();

            if (currNode.left != null){
                queue.offer(currNode.left);
                nextLevel ++;
            }

            if (currNode.right != null){
                queue.offer(currNode.right);
                nextLevel ++;
            }


            System.out.print(currNode.value + "\t");
            thisLevel --;

            if (thisLevel == 0){
                System.out.println();
                thisLevel = nextLevel;
                nextLevel = 0;
            }
        }
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

        printBinTree(node8);
    }
}
