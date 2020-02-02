package algorithm.foroffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 21:26
 * 面试题 50：树中两个结点的最低公共祖先
 *
 * 考查点：
 *      1. 树的遍历
 *      2. 知识迁移能力，将问题转化为已有解决方法的问题
 *
 * 思路：
 *      1. 遍历树，找到根结点到指定结点的路径，是单向链表
 *      2. 从头到尾找到两条单向链表的最后一个公共结点
 *
 *
 *               0
 *              / \
 *            1    2
 *          /  \
 *         3    4
 *       / \   / | \
 *      5  6  7  8  9
 *
 */

class TreeNode50{
    int             value;
    List<TreeNode50> children = new ArrayList<>();
    public TreeNode50(int _value){ value = _value; }
    public void addChild(TreeNode50 child){ children.add(child); }
    public void addChildren(TreeNode50... children){
        for (TreeNode50 child : children) this.children.add(child);
    }
}

public class Test50 {

    /**
     * 找根结点到目标结点的路径
     * @param root 树的根结点
     * @param target 树中的一个结点
     * @param path 从根结点到目标结点的路径
     * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
     *
     *
    private void getNodePath(TreeNode root, TreeNode target, List<TreeNode> path){
        if (root == null) return ;

        // 添加当前结点
        path.add(root);

        // 处理孩子结点
        for (TreeNode child : root.children){
            // System.out.println(child.value);  // 0	1	3	5	4	7	8	9	2
            if (child == target){
                System.out.println(child.value);
                path.add(child);
                return ;
            }else{
                System.out.println("---- " + child.value);
                getNodePath(child, target, path);
            }
        }

        // 恢复现场
        path.remove(path.size()-1);
        // 0	1	3	5	4	7	8	9	2
        // 0	1	3	5	6	4	7	2
    }

    */

    /**
     * 找根结点到目标结点的路径
     * @param root 树的根结点
     * @param target 树中的一个结点
     * @param path 从根结点到目标结点的路径
     * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
     */
    private boolean getNodePath2(TreeNode50 root, TreeNode50 target, List<TreeNode50> path){
        // 添加当前结点
        path.add(root);
        System.out.print(root.value + "\t");  //0	1	3	5	6	4	7

        if (root == target) return true;

        boolean found = false;

        // 处理孩子结点
        for (TreeNode50 child : root.children){
            found = getNodePath2(child, target, path);
            if (found) break;
        }

        if (!found) path.remove(path.size()-1);

        return found;
    }

    /**
     * 找两个链表的最后一个相同的结点
     * @param head1 链表一的头结点
     * @param head2 链表二的头结点
     * @return 两个链表的最后一个相同的结点
     */
    private TreeNode50 getLastCommonNode(List<TreeNode50> head1, List<TreeNode50> head2){
        for (int i = 1; i < head1.size() && i < head2.size(); i ++){
            if (head1.get(i).value != head2.get(i).value &&
                    head1.get(i-1).value == head2.get(i-1).value)
                return head1.get(i-1);
        }
        return null;
    }


    /**
     * 根据树的根结点和树中的两个结点，找到这两个结点的最低公共祖先结点
     * @param root 树的根结点
     * @param target1 树中结点1
     * @param target2 树中的结点2
     * @return 两个结点的最低公共祖先结点
     */
    public TreeNode50 getLastCommonParent(TreeNode50 root, TreeNode50 target1, TreeNode50 target2){
        if (root == null || target1 == null || target2 == null) return null;

        List<TreeNode50> path1 = new ArrayList<>();
        getNodePath2(root, target1, path1);
        System.out.println();
        for(TreeNode50 node : path1) System.out.print(node.value + "\t");
        System.out.println();

        List<TreeNode50> path2 = new ArrayList<>();
        getNodePath2(root, target2, path2);
        System.out.println();
        for(TreeNode50 node : path2) System.out.print(node.value + "\t");
        System.out.println();

        return getLastCommonNode(path1, path2);
    }


    @Test
    public void test(){
        TreeNode50[] nodes = generateTree();
        TreeNode50 root = nodes[0];
        TreeNode50 target1 = nodes[1];
        TreeNode50 target2 = nodes[2];

        TreeNode50 lastCommonNode = getLastCommonParent(root, target1, target2);
        System.out.println("lastCommonNode.value = " + lastCommonNode.value);

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
    private TreeNode50[] generateTree() {
        TreeNode50 node0 = new TreeNode50(0);
        TreeNode50 node1 = new TreeNode50(1);
        TreeNode50 node2 = new TreeNode50(2);
        TreeNode50 node3 = new TreeNode50(3);
        TreeNode50 node4 = new TreeNode50(4);
        TreeNode50 node5 = new TreeNode50(5);
        TreeNode50 node6 = new TreeNode50(6);
        TreeNode50 node7 = new TreeNode50(7);
        TreeNode50 node8 = new TreeNode50(8);
        TreeNode50 node9 = new TreeNode50(9);

        node0.addChildren(node1, node2);
        node1.addChildren(node3, node4);
        node3.addChildren(node5, node6);
        node4.addChildren(node7, node8, node9);

        return new TreeNode50[]{node0, node5, node7};
    }


}
