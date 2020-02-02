package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/26.
 * 面试题 18：树的子结构
 *
 * 题目：
 *      输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
 *      二叉树的定义如下：
 *
 * 问题：
 *      1. 树中的指针操作
 *      2. 边界条件的检查
 *
 * 思路：
 *      1. 递归
 *      2. 第一，判断 A 的根结点和 B 的根结点是否相等
 *         如果不相等，判断 A 的左孩子和 B 的根结点是否相等
 *         如果不相等，判断 A 的右孩子和 B 的根结点是否相等
 *         递归执行，直到找到与 B 的根结点相等的结点 R
 *
 *         第二，判断 B 的左右孩子结点和 R 的左右孩子结点是否分别相等
 *         如果不相等，返回 false
 *         如果相等，则递归判断对应的后代结点是否相等
 *
 */

class TreeNode18 {
    int value;
    TreeNode18 left;
    TreeNode18 right;

    public TreeNode18(){}
    public TreeNode18(int value){ this.value = value; }
    public void setChildren(TreeNode18 left, TreeNode18 right){
        this.left = left;
        this.right = right;
    }
}

public class Test18 {

    /**
     * 判断一个树中是否包含另一个树的结构
     * @param root1 树1的根结点
     * @param root2 树2的根结点
     * @return 包含返回 true，不包含返回 false
     */
    public static boolean hasSubtree(TreeNode18 root1, TreeNode18 root2){
        // if (root1 == null || root2 == null) throw new RuntimeException("Invalid input.");

        boolean contains = false;
        if (root1 != null && root2 != null){
            // 递归终止条件，
            // 找到和第二棵树的根结点root2相等的结点
            // 判断以当前结点为根结点的子树是否包含以 root2 为根结点的树
            if (root1.value == root2.value) contains = contains(root1, root2);

            // 如果当前结点和root2 "不相等"（以当前结点为根结点的子树不包含以 root2 为根结点的树），
            // 则判断左孩子结点和 root2 是否相等
            if (!contains) contains = hasSubtree(root1.left, root2);
            // 如果当前结点和root2 "不相等"（以当前结点为根结点的子树不包含以 root2 为根结点的树），
            // 则判断右孩子结点和 root2 是否相等
            if (!contains) contains = hasSubtree(root1.right, root2);
        }

        return contains;
    }

    /**
     * 判断一个树中是否包含另一个树的结构，其中两个树的的根结点相等
     * @param root1 树 1 的根结点
     * @param root2 树 2 的根结点
     * @return 包含返回 true， 不包含返回 false
     */
    private static boolean contains(TreeNode18 root1, TreeNode18 root2){
        // 1. 递归终止条件
        if (root2 == null) return true;   // 树 2 遍历结束
        if (root1 == null) return false;  // 树 1 遍历结束，而树 2 还没有遍历结束
        if (root1.value != root2.value) return false;  // 存在对应的结点不相等的情况

        // 2. 递归操作
        return contains(root1.left, root2.left) && contains(root1.right, root2.right);
    }

    public static void main(String[] args){
        TreeNode18 root1 = generateTree1();
        TreeNode18 root2 = generateTree2();

        boolean contains = Test18.hasSubtree(root1, root2);
        System.out.println(contains);
    }

    private static TreeNode18 generateTree1() {
        TreeNode18 root0 = new TreeNode18(8);
        TreeNode18 root1 = new TreeNode18(8);
        TreeNode18 root2 = new TreeNode18(7);
        TreeNode18 root3 = new TreeNode18(9);
        TreeNode18 root4 = new TreeNode18(2);
        TreeNode18 root5 = new TreeNode18(4);
        TreeNode18 root6 = new TreeNode18(7);

        root0.setChildren(root1, root2);
        root1.setChildren(root3, root4);
        root4.setChildren(root5, root6);

        return root0;
    }

    private static TreeNode18 generateTree2() {
        TreeNode18 root0 = new TreeNode18(8);
        TreeNode18 root1 = new TreeNode18(9);
        TreeNode18 root2 = new TreeNode18(3);

        root0.setChildren(root1, root2);

        return root0;
    }

}
