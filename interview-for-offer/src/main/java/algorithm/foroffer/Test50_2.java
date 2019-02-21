package algorithm.foroffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-05 21:23
 */
public class Test50_2 {

    /**
     * 找根结点到目标结点的路径
     * @param root 树的根结点
     * @param target 树中的一个结点
     * @param path 从根结点到目标结点的路径
     * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
     */
    public boolean getNodePath(TreeNode root, TreeNode target, List<TreeNode> path){
        // 添加当前结点
        path.add(root);
        System.out.print(root.value + "\t");  //0	1	3	5	6	4	7

        if (root == target) return true;

        boolean found = false;

        // 处理孩子结点
        for (TreeNode child : root.children){
            found = getNodePath(child, target, path);
            if (found) break;
        }

        // 以当前结点为根结点的子树中，不存在目标结点，则从路径中删除该结点
        if (!found) path.remove(path.size()-1);

        return found;
    }



    @Test
    public void test(){
        TreeNode[] nodes = generateTree();
        TreeNode root = nodes[0];
        TreeNode target1 = nodes[1];

        List<TreeNode> path1 = new ArrayList<>();
        getNodePath(root, target1, path1);
        System.out.println();
        for(TreeNode node : path1) System.out.print(node.value + "\t");
        System.out.println();
    }


    /**
     *               0
     *              / \
     *            1    2
     *          /  \
     *         3    4
     *       / \   / | \
     *      5  6  7  8  9
     *
     */
    private TreeNode[] generateTree() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node0.addChildren(node1, node2);
        node1.addChildren(node3, node4);
        node3.addChildren(node5, node6);
        node4.addChildren(node7, node8, node9);

        return new TreeNode[]{node0, node7};
    }

}

