package problems;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-02 10:45
 *
 *  Binary Tree Paths 二叉树根结点到所有叶子结点的路径
 *
 * 题目：
 *  Given a binary tree, return all root-to-leaf paths.
 *  For example, given the following binary tree:
 *                 1
 *               /   \
 *              2     3
 *               \
 *                5
 *
 * All root-to-leaf paths are:  ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    private static class BinTreeNode{
        int value;
        BinTreeNode left;
        BinTreeNode right;

        public BinTreeNode (int _value){ value = _value; }
        public void setChildren(BinTreeNode _left, BinTreeNode _right){
            left = _left;
            right = _right;
        }
    }


    public List<String> binaryTreePaths(BinTreeNode root){
        List<String> paths = new LinkedList<>();
        if (root == null) return paths; // if root == null, return []
        String path = "";
        binaryTreePaths(root, paths, path);
        return paths;
    }

    private void binaryTreePaths(BinTreeNode root, List<String> paths, String path) {
        if (root == null) return;

        // 叶子结点，路径中的末尾结点，是专有的
        if (root.left == null && root.right == null){
            if ("".equals(path))  path += root.value;
            else                  path += "->" + root.value;
            paths.add(path);
            return;
        }

        // 根结点到当前结点的路径，为其左右子结点公有的路径
        if ("".equals(path)) path += root.value;
        else                 path += "->"+root.value;
        binaryTreePaths(root.left, paths, path);
        binaryTreePaths(root.right, paths, path);
    }


    @Test
    public void test(){
        BinTreeNode node1 = new BinTreeNode(1);
        BinTreeNode node2 = new BinTreeNode(2);
        BinTreeNode node3 = new BinTreeNode(3);
        BinTreeNode node5 = new BinTreeNode(5);

        node1.setChildren(node2, node3);
        node2.setChildren(null, node5);

        List<String> paths = binaryTreePaths(node1);
        for (String path : paths)
            System.out.println(path);
    }
}
