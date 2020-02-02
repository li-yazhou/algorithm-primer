package offerV2;

import offerV2.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @No          v2-032,v1-060
 * @problem     按之字形顺序打印二叉树
 * @tag         二叉树、队列
 * @author      liyazhou1
 * @date        2017-06-08
 *
 * <pre>
 *      请实现一个函数按照之字型顺序打印二叉树，即第一行按照从左到右的顺序打印，
 *      第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *      例如：按之字形顺序打印下面的二叉树的结果为：
 *      1
 *      3  2
 *      4  5  6 7
 *      15 14 13 12 11 10 9 8
 *
 *               1
 *           /       \
 *         2          3
 *       /  \        /   \
 *      4    5      6     7
 *    / \   / \    / \   / \
 *   8  9  10 11  12 13 14 15
 * </pre>
 */
public class _032_BinTree_Level_Visit_With_Line_Rotate {


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

        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
            if (pRoot == null) return lines;

            ArrayList<Integer> line = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(pRoot);

            TreeNode currNode;
            int thisLevel = 1;
            int nextLevel = 0;

            int level = 1;

            LinkedList<Integer> stack = new LinkedList<Integer>();
            while (!queue.isEmpty()) {
                currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                    nextLevel++;
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                    nextLevel++;
                }

                line.add(currNode.val);

                thisLevel--;
                if (thisLevel == 0) {
                    if (level % 2 == 0) {
                        Collections.reverse(line);
                    } else {
                        lines.add(line);
                    }
                    lines.add(line);
                    line = new ArrayList<Integer>();
                    thisLevel = nextLevel;
                    nextLevel = 0;
                    level++;
                }
            }
            return lines;
        }
    }
}
