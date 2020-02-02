package offerV2;

import offerV2.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @No          v2-032,v1-023
 * @problem     从上往下打印二叉树
 * @tag         二叉树、队列
 * @author      liyazhou1
 * @date        2017-06-19
 *
 * <pre>
 *      从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 *      例如输入下图的二叉树，则依次打印出 8、6、10、5、7、9、11.
 *                  8
 *                /   \
 *              6      10
 *            /  \    /  \
 *           5   7   9   11
 * </pre>
 */
public class _032_BinTree_Level_Visit {


    /**
     * Note
     *
     * Thought
     *      1. 层次遍历二叉树
     *      
     * Algorithm
     *      1. 层次遍历二叉树，是广度优先搜索，需要使用队列
     *      2. 创建队列，并把根结点入队
     *         循环：队列不为空
     *              队列的首元素出队，并访问该元素
     *              如果当前元素的左孩子不为空，则入队
     *              如果当前元素的右孩子不为空，则入队
     */
    private static class Solution {
        /**
         * 层次遍历二叉树
         * @param root 二叉树的根结点
         */
        public static void levelVisitTree(TreeNode root){
            if (root == null) return;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode currNode = queue.poll();
                System.out.print(currNode.val + "\t");

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
        }
    }
}
