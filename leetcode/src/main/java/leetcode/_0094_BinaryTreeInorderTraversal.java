package leetcode;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @No          94
 * @problem     Binary Tree Inorder Traversal
 * @level       Medium
 * @desc        二叉树的中序遍历
 * @author      liyazhou1
 * @date        2019/09/29
 *
 * <pre>
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * </pre>
 */
public class _0094_BinaryTreeInorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static class TreeUtil {

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

        public static void main(String[] args) {
            TreeNode root = generateTreeWithLevel(1, 2, null, 4, 5, null, null, 7, 8);
            visitByLevel(root);
        }
    }


    /**
     * Note
     *
     * Thought
     *      莫里斯中序遍历
     *          根节点右旋遍历法
     *          每一步右旋之后的二叉树的中序遍历结果与原二叉树的中序遍历结果相同
     *
     * Challenge
     *      指针控制
     *
     * Algorithm
     *      1. 参数校验，若root为空，则返回空List；
     *      2. while (root != null)
     *              若根结点存在左孩子结点，则将该左孩子结点作为新的根结点，并将旧根结点作为新根结点的最右孩子结点的右孩子；
     *              若根结点不存在左孩子结点，则将当前根结点保存到List中，并将当前结点的右孩子结点作为新的根结点；
     *      3. 返回List，即结果集。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            if (root == null) {
                return inorder;
            }

            while (root != null) {
                if (root.left != null) {
                    TreeNode oldRoot = root;
                    TreeNode right = oldRoot.left;

                    while (right.right != null) {
                        right = right.right;
                    }
                    right.right = oldRoot;
                    root = oldRoot.left;
                    oldRoot.left = null;
                } else {
                    inorder.add(root.val);
                    root = root.right;
                }
            }

            return inorder;
        }


        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithLevel(1,
                    2, 3,
                    4, 5, 6, 7,
                    8, 9, 10, 11, 12, 13, 14, 15
            );

            TreeUtil.visitByLevel(root);

            List<Integer> result = new Solution().inorderTraversal(root);
            System.out.println("result = " + result);
        }
    }

    /**
     * Note
     *
     * Thought
     *      二叉树的中序遍历
     *          递归法
     *          使用栈
     *          莫里斯中序遍历，需要修改树的结构
     *
     * Challenge
     *
     *
     * Algorithm
     *      莫里斯中序遍历
     *      1. 若当前结点没有左孩子结点，则访问该结点
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution2 {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            if (root == null) {
                return inorder;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                inorder.add(curr.val);
                curr = curr.right;
            }

            return inorder;
        }


        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithLevel(1,
                    2, 3,
                    4, 5, 6, 7,
                    9, 10, 11, 12, 13, 14, 15, 16
            );

            TreeUtil.visitByLevel(root);

            List<Integer> result = new Solution2().inorderTraversal(root);
            System.out.println("result = " + result);
        }
    }


    /**
     * Note
     *
     * Thought
     *      二叉树的中序遍历，递归法
     *
     * Challenge
     *
     *
     * Algorithm
     *      1. 若当前结点为空，则返回；
     *      2. 若当前结点的左孩子结点为空，则递归递进该孩子结点；
     *      3. 访问当前结点；
     *      4. 若当前结点的右孩子结点为空，则递归递进该孩子结点
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution1 {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();

            inorderTraversal(inorder, root);

            return inorder;
        }

        private void inorderTraversal(List<Integer> inorder, TreeNode root) {
            if (root == null) {
                return;
            }

            inorderTraversal(inorder, root.left);

            inorder.add(root.val);

            inorderTraversal(inorder, root.right);
        }

        public static void main(String[] args) {
            TreeNode root = TreeUtil.generateTreeWithLevel(1,
                    2, 3,
                    4, 5, 6, 7,
                    9, 10, 11, 12, 13, 14, 15, 16
            );

            TreeUtil.visitByLevel(root);

            List<Integer> result = new Solution1().inorderTraversal(root);
            System.out.println("result = " + result);
        }
    }

}
