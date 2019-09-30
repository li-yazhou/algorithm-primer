package leetcode;

import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.Arrays;

/**
 * @No          105
 * @problem     Construct Binary Tree from Preorder and Inorder Traversal
 * @level       Medium
 * @desc        从前序与中序遍历序列构造二叉树
 * @author      liyazhou1
 * @date        2019/10/01
 *
 * <pre>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 */
public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {


    /**
     * Note
     *
     * Thought
     *      根据先序遍历和中序遍历重建二叉树
     *
     * Challenge
     *      确定边界是关键点
     *
     * Algorithm
     *      1. 参数是前序遍历序列以及其起始、终止下标，中序遍历序列以及其起始、终止下标
     *      2. 首先，判断起始和终止下标是否越界，如果越界，则返回null，这个null将作为只有一个孩子或者叶子结点的孩子
     *      3. 根据前序遍历序列的第一个元素创建当前树的根结点
     *      4. 查找根结点在中序遍历序列中的位置，也即是下标
     *      5. 假如，中序遍历序列中不存在该根结点，抛出前序遍历和中序遍历序列不匹配的异常
     *      6. 根据根结点在前序遍历和后续遍历中的下标，可以计算出根结点的左子树在前序和后序遍历序列中的下标范围，然后递归地创建左子树，并将返回值赋值给它的根结点
     *      7. 根据根结点在前序遍历和后续遍历中的下标，可以计算出根结点的右子树在前序和后序遍历序列中的下标范围，然后递归地创建右子树，并将返回值赋值给它的根结点
     *      8. 返回二叉树的根结点
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 判断输入数据
            if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
            return constructBinTree(preorder, 0, preorder.length, inorder, 0, preorder.length);
        }

        /**
         * @param preorder      前序遍历序列
         * @param preStart      当前树的前序遍历序列的第一个元素的下标
         * @param preEnd        当前树的前序遍历序列的最后一个元素的下标+1
         * @param inorder       中序遍历序列
         * @param inStart       当前树的中序遍历序列的第一个元素的下标
         * @param inEnd         当前树的中序遍历序列的最后一个元素的下标+1
         * @return              二叉树的根结点
         */
        private TreeNode constructBinTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            // 递归终止条件，当开始位置大于结束位置时，则没有要处理的数据
            if (preStart >= preEnd || inStart >= inEnd) return null;  // null 是只有一个孩子或者叶子结点的孩子

            // 从前序遍历序列中取出根结点
            int rootId = preorder[preStart];
            TreeNode root = new TreeNode(rootId);

            // 根结点在中序遍历序列中的位置
            int idxOfRoot = -1;
            for (int i = inStart; i < inEnd; i++){
                if(inorder[i] == rootId){
                    idxOfRoot = i;
                    break;
                }
            }

            if (idxOfRoot == -1) {
                System.out.println(String.format("preStart, preEnd = %d, %d, preorder = %s", preStart, preEnd, Arrays.toString(preorder)));
                System.out.println(String.format("inStart, inEnd = %d, %d, inorder = %s", inStart, inEnd, Arrays.toString(inorder)));
                throw new RuntimeException("先序遍历序列和中序遍历序列不匹配.");
            }

            // 递归构建当前根结点的左子树，左子树的结点个数是 idxOfRoot-inStart
            // 先序遍历序列中，当前根结点的左子树的范围是 [preStart+1, preStart+(idxOfRoot-inStart)+1)，根据起始位置和偏移量计算范围
            // 中序遍历序列中，当前根结点的左子树的范围是 [inStart, idxOfRoot)
            root.left = constructBinTree(preorder, preStart+1, preStart+idxOfRoot-inStart+1, inorder, inStart, idxOfRoot);

            // 递归构建当前根结点的右子树，右子树的结点个数是 inEnd-idxOfRoot-1
            // 先序遍历序列中，当前结点的右子树的范围是 [preEnd-(inEnd-idxOfRoot-1), preEnd)，根据终止位置和偏移量计算范围
            // 中序遍历序列中，当前结点的右子树的范围是 [idxOfRoot+1, inEnd)
            root.right = constructBinTree(preorder, preEnd-inEnd+idxOfRoot+1 , preEnd, inorder, idxOfRoot+1, inEnd);

            return root;
        }

        public static void main(String[] args) {
             int[][] preorders = {
                     {3, 9, 20, 15, 7},
             };
             int[][] inorders = {
                     {9, 3, 15, 20, 7},
             };

             for (int i = 0; i < preorders.length; i ++) {
                 TreeNode root = new Solution().buildTree(preorders[i], inorders[i]);
                 TreeUtil.visitByLevel(root);
             }
        }

    }
}
