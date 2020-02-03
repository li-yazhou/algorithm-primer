package offerV2;

/**
 * @No          v2-033,v1-024
 * @problem     二叉搜索树的后序遍历序列
 * @tag         二叉搜索树、后序遍历
 * @author      liyazhou1
 * @date        2017/5/28
 *
 * <pre>
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *      如果是则返回 true，否则返回 false。
 *      假设输入的数组的任意两个数字都互不相同。
 * </pre>
 */
public class _033_Search_BinTree_PostOrder_Check {


    /**
     * Note
     *
     * Thought
     *      1. 二叉搜索树的性质
     *      2. 二叉树的后序遍历结果的特点
     *      3. 递归
     *
     * Algorithm
     *      1. 二叉搜索树的性质，根结点比左孩子大，根结点比右孩子小
     *      2. 二叉树的后序遍历结果，最后的一个结点总是根结点
     *      3. 以最后一个元素作为分割点，将后序遍历结果分为两部分，其左子树和右子树的后序遍历结果
     *         判断每一个棵子树的是否满足条件，根结点比左孩子大，根结点比右孩子小
     */
    private static class Solution {

        public boolean vertifySeqOfBST(int[] seq) {
            if (seq == null || seq.length == 0) {
                return false;
            }
            return vertify(seq, 0, seq.length-1);
        }


        private boolean vertify(int[] seq, int start, int end) {

            // 验证通过的条件，跳出递归
            if (end - start <= 1) {
                return true;
            }

            int rootVal = seq[end];
            int currIndex = start;
            // 左子树的节点都小于根节点
            while (currIndex < end && seq[currIndex] <= rootVal) {
                currIndex ++;
            }

            // 从分界点验证右子树是否均大于根节点，若存在小于根节点的值则不是BST的后序遍历
            for (int i = currIndex; i < end; i ++) {
                if (seq[i] < rootVal) {
                    return false;
                }
            }

            return vertify(seq, start, currIndex-1) && vertify(seq, currIndex, end-1);

        }

    }
}
