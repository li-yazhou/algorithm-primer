package offerV2;

import offerV2.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @No          v2-007,v1-006
 * @problem     根据前序和中序遍历结果重建二叉树
 * @tag         二叉树
 * @author      liyazhou1
 * @date        2017/5/23
 *
 * <pre>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果都不含重复的数字。
 * 例如，
 * 输入前序遍历序列 {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建出二叉树并输出它的头结点。
 * </pre>
 */
public class _007_Rebuild_Tree_By_PreOrder_InOrder_Seq {

    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        private Map<Integer, Integer> indexForOrders = new HashMap<>();

        public TreeNode reConstructTree(int[] preOrders, int[] inOrders) {
            for (int i = 0; i < inOrders.length; i ++) {
                indexForOrders.put(inOrders[i], i);
            }
            return reConstructTree(preOrders, 0, preOrders.length-1, 0);
        }

        private TreeNode reConstructTree(int[] preOrders, int preL, int preR, int inL) {
            if (preL > preR) {
                return null;
            }
            TreeNode root = new TreeNode(preOrders[preL]);
            int inIndex = indexForOrders.get(root.value);
            int leftTreeSize = inIndex - inL;
            root.left = reConstructTree(preOrders, preL+1, preL+leftTreeSize, inL);
            root.right = reConstructTree(preOrders, preL+leftTreeSize+1, preR, inL+leftTreeSize+1);
            return root;
        }
    }


    /**
     * Note
     *
     * Thought
     *  确定边界是关键点
     *
     * Algorithm
     *  参数是前序遍历序列以及其起始、终止下标，中序遍历序列以及其起始、终止下标
     *  首先，判断起始和终止下标是否越界，如果越界，则返回null，这个null将作为只有一个孩子或者叶子结点的孩子
     *  根据前序遍历序列的第一个元素创建当前树的根结点
     *  查找根结点在中序遍历序列中的位置，也即是下标
     *  假如，中序遍历序列中不存在该根结点，抛出前序遍历和中序遍历序列不匹配的异常
     *  根据根结点在前序遍历和后续遍历中的下标，可以计算出根结点的左子树在前序和后序遍历序列中的下标范围，然后递归地创建左子树，并将返回值赋值给它的根结点
     *  根据根结点在前序遍历和后续遍历中的下标，可以计算出根结点的右子树在前序和后序遍历序列中的下标范围，然后递归地创建右子树，并将返回值赋值给它的根结点
     *  返回二叉树的根结点
     */
    private static class Solution2 {

        public TreeNode constructBinTree2(int[] preorder, int[] inorder){
            // 判断输入数据
            if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
            return constructBinTree(preorder, 0, preorder.length, inorder, 0, preorder.length);
        }

        /**
         * @param preorder 前序遍历序列
         * @param ps 当前树的前序遍历序列的第一个元素的下标
         * @param pe 当前树的前序遍历序列的最后一个元素的下标+1
         * @param inorder 中序遍历序列
         * @param is 当前树的中序遍历序列的第一个元素的下标
         * @param ie 当前树的中序遍历序列的最后一个元素的下标+1
         * @return 二叉树的根结点
         */
        private TreeNode constructBinTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
            // 递归终止条件，当开始位置大于结束位置时，则没有要处理的数据
            if (ps >= pe || is >= ie) return null;  // null 是只有一个孩子或者叶子结点的孩子

            // 从前序遍历序列中取出根结点
            int rootId = preorder[ps];
            TreeNode root = new TreeNode(rootId);

            // 根结点在中序遍历序列中的位置
            int idxOfRoot = -1;
            for (int i = is; i < ie; i++){
                if(inorder[i] == rootId){
                    idxOfRoot = i;
                    break;
                }
            }

            if (idxOfRoot == -1) {
                System.out.println(String.format("ps, pe = %d, %d, preorder = %s", ps, pe, Arrays.toString(preorder)));
                System.out.println(String.format("is, ie = %d, %d, inorder = %s", is, ie, Arrays.toString(inorder)));
                throw new RuntimeException("先序遍历序列和中序遍历序列不匹配.");
            }

            // 递归构建当前根结点的左子树，左子树的结点个数是 idxOfRoot-is
            // 先序遍历序列中，当前根结点的左子树的范围是 [ps+1, ps+(idxOfRoot-is)+1)，根据起始位置和偏移量计算范围
            // 中序遍历序列中，当前根结点的左子树的范围是 [is, idxOfRoot)
            root.left = constructBinTree(preorder, ps+1, ps+idxOfRoot-is+1, inorder, is, idxOfRoot);

            // 递归构建当前根结点的右子树，右子树的结点个数是 ie-idxOfRoot-1
            // 先序遍历序列中，当前结点的右子树的范围是 [pe-(ie-idxOfRoot-1), pe)，根据终止位置和偏移量计算范围
            // 中序遍历序列中，当前结点的右子树的范围是 [idxOfRoot+1, ie)
            root.right = constructBinTree(preorder, pe-ie+idxOfRoot+1 , pe, inorder, idxOfRoot+1, ie);

            return root;
        }
    }

}
