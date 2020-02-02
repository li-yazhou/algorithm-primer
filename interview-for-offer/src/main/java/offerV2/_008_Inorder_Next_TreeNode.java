package offerV2;

/**
 * @No          v2-008,v1-058
 * @problem     查找二叉树指定节点的中序遍历的下一个节点
 * @tag         二叉树
 * @author      liyazhou1
 * @date        2017/06/18
 *
 * <pre>
 *      给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *      树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 *      例如，下图的中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
 *                  0
 *                /   \
 *               1     2
 *              / \   / \
 *             3  4  5   6
 *               / \
 *              7   8
 * </pre>
 */
public class _008_Inorder_Next_TreeNode {

    class TreeNodeWithParent{
        int value;
        TreeNodeWithParent parent;
        TreeNodeWithParent left;
        TreeNodeWithParent right;
        public TreeNodeWithParent(int _value){ value = _value; }
        @Override
        public String toString(){
            return String.format("value = %s", value);
        }
    }


    /**
     * Note
     *
     * Thought
     *      二叉树中序遍历
     *
     * Algorithm
     *      1. 当前结点有右孩子，则下一个结点是其右子树的最左子结点
     *      2. 当前结点没有右孩子，但存在父结点，则下一个节点是从下往上的第一个为左孩子的祖先节点
     *           当前结点有右孩子，则其右子树的最左子结点即是下一个结点
     *           当前结点没有右孩子，而且是其父结点的左孩子，则其父结点即是下一个结点
     *           当前结点没有左孩子，而且是其父结点的右孩子，则其从下往上的祖先结点中是左孩子的结点即是下一个结点，可能不存在
     */
    private static class Solution {

        public TreeNodeWithParent nextNode(TreeNodeWithParent node){
            if (node == null) return null;

            if (node.right != null){   // 当前结点有右孩子，则下一个结点是其右子树的最左子结点
                TreeNodeWithParent currNode = node.right;
                while (currNode.left != null) {
                    currNode = currNode.left;
                }
                return currNode;
            } else if (node.parent != null){ // 当前结点没有右孩子，但存在父结点

                TreeNodeWithParent currNode = node;
                // 若当前结点是父结点的右孩子，则一直向上遍历，直到遇到其祖先结点是一个左孩子的情况
                // 该祖先结点的父结点的左子树已被遍历完成，则中序遍历的下一个结点就是其父结点
                while (currNode.parent != null) {
                    TreeNodeWithParent parentNode = currNode.parent;
                    if (parentNode.left == currNode) {
                        return parentNode;
                    }
                    currNode = parentNode;
                }
            }
            return null;
        }
    }
}
