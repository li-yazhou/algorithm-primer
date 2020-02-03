package offerV2;

import offerV2.common.TreeNode;

/**
 * @No          v2-037,v1-062
 * @problem     二叉树序列化与反序列化
 * @tag         二叉树、递归
 * @author      liyazhou
 * @date        2017-06-19
 *
 * <pre>
 *      请实现两个函数，分别用来序列化和反序列化二叉树。
 *                    1
 *                  /  \
 *                2     3
 *               /     / \
 *              4     5  6
 * </pre>
 */
public class _037_BinTree_Serialize {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 序列化二叉树，采用前序遍历的方式
     *            而且要保证任何结点均有两个孩子，若没有孩子或者只有一个孩子，则将缺失的孩子设置为 null
     *      2. 反序列化二叉树，
     */
    private static class Solution {

        private String toDeserializeSeq;

        public String serialize(TreeNode root) {
            if (root == null) {
                return "#";
            }
            return root.val + " " + serialize(root.left) + " " + serialize(root.right);
        }

        public TreeNode deserialize(String seq) {
            toDeserializeSeq = seq;
            return deserialize();
        }

        private TreeNode deserialize() {
            if (toDeserializeSeq.length() == 0) {
                return null;
            }
            int index = toDeserializeSeq.indexOf(" ");
            String val = index == -1 ? toDeserializeSeq : toDeserializeSeq.substring(0, index);
            if (val.equals("#")) {
                return null;
            }
            int value = Integer.valueOf(val);
            TreeNode node = new TreeNode(value);
            node.left = deserialize();
            node.right = deserialize();
            return node;
        }

    }
}
