package util;

import java.util.LinkedList;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/9/7
 */



public class TreeUtil {

    public static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static void visitByLevel(TreeNode root) {
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) nodeQueue.offer(root);
        int currLevelNum = 1;
        int nextLevelNum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();

            if (currNode.left != null) {
                nodeQueue.offer(currNode.left);
                nextLevelNum ++;
            }
            if (currNode.right != null) {
                nodeQueue.offer(currNode.right);
                nextLevelNum ++;
            }

            System.out.print(currNode.val + "\t");
            currLevelNum --;
            if (currLevelNum == 0) {
                System.out.println();
                currLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }
    }

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


    public static TreeNode generateTreeWithLevel(
            Integer arg11,
            Integer arg21, Integer arg22,
            Integer arg31, Integer arg32, Integer arg33, Integer arg34,
            Integer arg41, Integer arg42, Integer arg43, Integer arg44, Integer arg45, Integer arg46, Integer arg47, Integer arg48) {
        TreeNode node1_1 = null;
        TreeNode node2_1 = null;
        TreeNode node2_2 = null;
        TreeNode node3_1 = null;
        TreeNode node3_2 = null;
        TreeNode node3_3 = null;
        TreeNode node3_4 = null;
        TreeNode node4_1 = null;
        TreeNode node4_2 = null;
        TreeNode node4_3 = null;
        TreeNode node4_4 = null;
        TreeNode node4_5 = null;
        TreeNode node4_6 = null;
        TreeNode node4_7 = null;
        TreeNode node4_8 = null;

        if (arg11 != null) node1_1 = new TreeNode(arg11);
        if (arg21 != null) node2_1 = new TreeNode(arg21);
        if (arg22 != null) node2_2 = new TreeNode(arg22);
        if (arg31 != null) node3_1 = new TreeNode(arg31);
        if (arg32 != null) node3_2 = new TreeNode(arg32);
        if (arg33 != null) node3_3 = new TreeNode(arg33);
        if (arg34 != null) node3_4 = new TreeNode(arg34);
        if (arg41 != null) node4_1 = new TreeNode(arg41);
        if (arg42 != null) node4_2 = new TreeNode(arg42);
        if (arg43 != null) node4_3 = new TreeNode(arg43);
        if (arg44 != null) node4_4 = new TreeNode(arg44);
        if (arg45 != null) node4_5 = new TreeNode(arg45);
        if (arg46 != null) node4_6 = new TreeNode(arg46);
        if (arg47 != null) node4_7 = new TreeNode(arg47);
        if (arg48 != null) node4_8 = new TreeNode(arg48);

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


        if (node3_1 != null) {
            node3_1.left = node4_1;
            node3_1.right = node4_2;
        }
        if (node3_2 != null) {
            node3_2.left = node4_3;
            node3_2.right = node4_4;
        }
        if (node3_3 != null) {
            node3_3.left = node4_5;
            node3_3.right = node4_6;
        }
        if (node3_4 != null) {
            node3_4.left = node4_7;
            node3_4.right = node4_8;
        }

        return node1_1;
    }

    public static TreeNode generateTreeWithLevel(Integer... nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        int len = nodes.length;
        TreeNode[] treeNodes = new TreeNode[len];
        for (int i = 0; i < len; i ++) {
            if (nodes[i] != null) {
                treeNodes[i] = new TreeNode(nodes[i]);
            }
        }

        double doubleLevel = Math.log(len+1) / Math.log(2);
        int intLevel = (int)doubleLevel;
        int levelWithChild = doubleLevel > intLevel ? intLevel : intLevel-1;
        int nodeNumNotBottomLevel = (int) Math.pow(2, levelWithChild) - 1;

        for (int i = 0; i < nodeNumNotBottomLevel; i ++) {
            if (treeNodes[i] == null) {
                continue;
            }
            int rightChildIndex = (i + 1) * 2;
            int leftChildIndex =  rightChildIndex - 1;
            if (leftChildIndex < len) {
                treeNodes[i].left = treeNodes[leftChildIndex];
            }
            if (rightChildIndex < len) {
                treeNodes[i].right = treeNodes[rightChildIndex];
            }
        }

        return treeNodes[0];
    }
}
