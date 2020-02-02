package offerV2;

import offerV2.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @No          v2-032,v1-060
 * @problem     把二叉树打印为多行
 * @tag         二叉树、队列
 * @author      liyazhou1
 * @date        2017-06-08
 *
 * <pre>
 *      从上到下按层打印二叉树，同一层的结点按从左到右顺序打印，
 *      每一层打印到一行。例如下面的二叉树的结果为：
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 *
 *       结果为：
 *       8
 *       6 10
 *       5 7 9 11
 * </pre>
 */
public class _032_BinTree_Level_Visit_With_Line {


    /**
     * Note
     *
     * Thought
     *      1. 树的层次遍历，属于广度优先遍历，使用的数据结构是队列
     *      
     * Algorithm
     *      1. 队列，
     *      2. 两个辅助变量，一个变量保存当前层还没有打印的结点数，
     *         另一个变量保存下一层结点的数目
     */
    private static class Solution {

        public void printBinTree(TreeNode root){
            if (root == null) return;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int nextLevel = 0;
            int thisLevel = 1;

            while (!queue.isEmpty()){
                TreeNode currNode = queue.poll();

                if (currNode.left != null){
                    queue.offer(currNode.left);
                    nextLevel ++;
                }

                if (currNode.right != null){
                    queue.offer(currNode.right);
                    nextLevel ++;
                }


                System.out.print(currNode.val + "\t");
                thisLevel --;

                if (thisLevel == 0){
                    System.out.println();
                    thisLevel = nextLevel;
                    nextLevel = 0;
                }
            }
        }
    }
}
