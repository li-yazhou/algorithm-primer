package util;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/9/7
 */
public class TreeFactory {

    public static TreeNode generateTreeWithThreeLevel(
                                        Integer arg11,
                                        Integer arg21, Integer arg22,
                                        Integer arg31, Integer arg32, Integer arg33, Integer arg34) {
        TreeNode node1_1 = null;
        TreeNode node2_1 = null;
        TreeNode node2_2 = null;
        TreeNode node3_1 = null;
        TreeNode node3_2 = null;
        TreeNode node3_3 = null;
        TreeNode node3_4 = null;

        if (arg11 != null) node1_1 = new TreeNode(arg11);
        if (arg21 != null) node2_1 = new TreeNode(arg21);
        if (arg22 != null) node2_2 = new TreeNode(arg22);
        if (arg31 != null) node3_1 = new TreeNode(arg31);
        if (arg32 != null) node3_2 = new TreeNode(arg32);
        if (arg33 != null) node3_3 = new TreeNode(arg33);
        if (arg34 != null) node3_4 = new TreeNode(arg34);

        if (node1_1 != null) {
            node1_1.left = node2_1;
            node1_1.right = node2_2;
        }

        if (node2_1 != null) {
            node2_1.left = node3_1;
            node2_1.right = node3_2;
        }

        if (node2_2 != null) {
            node2_2.left = node3_3;
            node2_2.right = node3_4;
        }
        return node1_1;
    }
}
