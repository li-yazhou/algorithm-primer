package util;

import java.util.LinkedList;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/9/7
 */
public class TreeVisitor {

    public static void visitByLevel(TreeNode root) {
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();

            if (currNode.left != null) {
                nodeQueue.offer(currNode.left);
            }
            if (currNode.right != null) {
                nodeQueue.offer(currNode.right);
            }
            System.out.print(currNode.val + "\t");
        }
    }
}
