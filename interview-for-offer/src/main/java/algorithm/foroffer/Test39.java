package algorithm.foroffer;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-05-31 21:40
 *
 * 面试题39：二叉树的深度
 *
 * 题目一：
 *      输入一棵二叉树的根结点。求该树的深度。从根结点到叶结点依次经过的结点
 *      （含根、叶结点）形成的树的一条路径，最长路径的长度为树的深度。
 *
 * 题目二：
 *      输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 *      如果某二叉树中的任意结点的左右子树的深度相差不超过 1， 那么它就是一棵平衡二叉树。
 *      例如，下图中的二叉树就是一棵平衡二叉树。
 *                      1
 *                    /   \
 *                  2      3
 *                /  \      \
 *              4     5      6
 *                   /
 *                  7
 *
 * 考查点：
 *      1. 二叉树的遍历
 *
 * 思路：
 *      1. 从叶子节点递归到根结点，求出一条路径的长度
 */

/*
class BinTreeNode{
    int         value;
    BinTreeNode left;
    BinTreeNode right;

    public BinTreeNode(int value){ this.value = value; }
    public void setChildren(algorithm.foroffer.BinTreeNode _left, algorithm.foroffer.BinTreeNode _right){
        left = _left;
        right = _right;
    }
}
*/

public class Test39 {

    /**
     * 计算二叉树的深度
     * @param root 二叉树的根结点
     * @return 二叉树的深度
     */
    public int treeDepth(BinTreeNode27 root){
        if (root == null) return 0;

        int leftDepth = treeDepth(root.left) + 1;
        int rightDepth = treeDepth(root.right) + 1;

        int depth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return depth;
    }


    /**
     * 判断一个二叉树是否是平衡二叉树
     * @param root 二叉树的根结点
     * @return 是，返回 true，否则，返回 false
     */
    public boolean isBalancedBinTree(BinTreeNode27 root){
        // 递归终止条件一，遍历到叶子结点
        if (root == null) return true;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        int diff = leftDepth - rightDepth;
        // 递归终止条件二，存在结点的左右子树的深度相差超过 1
        if (diff > 1 || diff < -1) return false;
        return isBalancedBinTree(root.left) && isBalancedBinTree(root.right);
        // return !((diff > 1 || diff < -1)) && isBalancedBinTree(root.left) && isBalancedBinTree(root.right);
    }


    /**
     * 判断一个二叉树是否是平衡二叉树
     * @param root 二叉树的根结点
     * @return 是，返回 true，否则，返回 false
     */
    public boolean isBalancedBinTree2(BinTreeNode27 root){
        int[] depth = {0};
        return isBalancedBinTree(root, depth);
    }


    private boolean isBalancedBinTree(BinTreeNode27 root, int[] depth){
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] leftDepth = {0};
        int[] rightDepth = {0};
        if (isBalancedBinTree(root.left, leftDepth) && isBalancedBinTree(root.right, rightDepth)){
            int diff = leftDepth[0] - rightDepth[0];
            if (diff >= -1 && diff <= 1){
                depth[0] = 1 + (leftDepth[0] > rightDepth[0] ? leftDepth[0] : rightDepth[0]);
                return true;
            }
        }
        return false;
    }

    /**
     * 测试二叉树的深度
     *                1
     *              /   \
     *            2      3
     *          /  \      \
     *        4     5      6
     *             /
     *            7
     */
    @Test
    public void test1(){
        BinTreeNode27 node1 = new BinTreeNode27(1);
        BinTreeNode27 node2 = new BinTreeNode27(2);
        BinTreeNode27 node3 = new BinTreeNode27(3);
        BinTreeNode27 node4 = new BinTreeNode27(4);
        BinTreeNode27 node5 = new BinTreeNode27(5);
        BinTreeNode27 node6 = new BinTreeNode27(6);
        BinTreeNode27 node7 = new BinTreeNode27(7);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, node5);
        node3.setChildren(null, node6);
        node5.setChildren(node7, null);
        int depth = treeDepth(node1);
        System.out.printf("depth = %d", depth);
    }

    /**
     * 测试二叉树的深度
     *                  1
     *                 /
     *                2
     *               /
     *              3
     *             /
     *            4
     *           /
     *          5
     */
    @Test
    public void test2(){
        BinTreeNode27 node1 = new BinTreeNode27(1);
        BinTreeNode27 node2 = new BinTreeNode27(2);
        BinTreeNode27 node3 = new BinTreeNode27(3);
        BinTreeNode27 node4 = new BinTreeNode27(4);
        BinTreeNode27 node5 = new BinTreeNode27(5);

        node1.setChildren(node2, null);
        node2.setChildren(node3, null);
        node3.setChildren(node4, null);
        node4.setChildren(node5, null);
        int depth = treeDepth(node1);
        System.out.printf("depth = %d", depth);
    }


    /**
     * 测试二叉树的深度
     *         1
     *          \
     *           2
     *            \
     *             3
     *              \
     *               4
     *                \
     *                 5
     */
    @Test
    public void test3(){
        BinTreeNode27 node1 = new BinTreeNode27(1);
        BinTreeNode27 node2 = new BinTreeNode27(2);
        BinTreeNode27 node3 = new BinTreeNode27(3);
        BinTreeNode27 node4 = new BinTreeNode27(4);
        BinTreeNode27 node5 = new BinTreeNode27(5);

        node1.setChildren(null, node2);
        node2.setChildren(null, node3);
        node3.setChildren(null, node4);
        node4.setChildren(null, node5);
        int depth = treeDepth(node1);
        System.out.printf("depth = %d", depth);
    }

    /**
     * 测试是否是平衡二叉树
     *              1
     *            /   \
     *          2      3
     *        /  \      \
     *      4     5      6
     *           /
     *          7
     */
    @Test
    public void test11(){
        BinTreeNode27 node1 = new BinTreeNode27(1);
        BinTreeNode27 node2 = new BinTreeNode27(2);
        BinTreeNode27 node3 = new BinTreeNode27(3);
        BinTreeNode27 node4 = new BinTreeNode27(4);
        BinTreeNode27 node5 = new BinTreeNode27(5);
        BinTreeNode27 node6 = new BinTreeNode27(6);
        BinTreeNode27 node7 = new BinTreeNode27(7);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, node5);
        node3.setChildren(null, node6);
        node5.setChildren(node7, null);

        System.out.println(isBalancedBinTree(node1));
        System.out.println(isBalancedBinTree2(node1));
    }

    /**
     * 测试二叉树的深度
     *                  1
     *                 /
     *                2
     *               /
     *              3
     *             /
     *            4
     *           /
     *          5
     */
    @Test
    public void test12(){
        BinTreeNode27 node1 = new BinTreeNode27(1);
        BinTreeNode27 node2 = new BinTreeNode27(2);
        BinTreeNode27 node3 = new BinTreeNode27(3);
        BinTreeNode27 node4 = new BinTreeNode27(4);
        BinTreeNode27 node5 = new BinTreeNode27(5);

        node1.setChildren(node2, null);
        node2.setChildren(node3, null);
        node3.setChildren(node4, null);
        node4.setChildren(node5, null);
        System.out.println(isBalancedBinTree(node1));
        System.out.println(isBalancedBinTree2(node1));
    }

}




