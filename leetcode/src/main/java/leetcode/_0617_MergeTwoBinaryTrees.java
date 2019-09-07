package leetcode;

import org.junit.Test;
import util.TreeFactory;
import util.TreeNode;
import util.TreeVisitor;

/**
 * @author liyazhou1
 * @date 2019/9/7
 */
public class _0617_MergeTwoBinaryTrees {


    private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        /* 合并根节点 */
        t1.val += t2.val;
        /* 递归合并左右子树 */
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    @Test
    public void test01() {
        TreeNode tree1 = TreeFactory.generateTreeWithThreeLevel(
                1,
                3, 2,
                5, null, null, null
        );
        TreeNode tree2 = TreeFactory.generateTreeWithThreeLevel(
                2,
                1, 3,
                null, 4, null, 7
        );
        TreeVisitor.visitByLevel(tree1);
        System.out.println();
        TreeVisitor.visitByLevel(tree2);
        System.out.println();
        mergeTrees(tree1, tree2);
        TreeVisitor.visitByLevel(tree1);
        System.out.println();
    }


}
