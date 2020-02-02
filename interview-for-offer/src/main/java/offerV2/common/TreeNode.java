package offerV2.common;

public class TreeNode {
    public int val;  // id of BinaryTreeNode, unique
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}
    public TreeNode(int value){ this.val = value; }
    public TreeNode(int value, TreeNode left, TreeNode right){
        this.val = value;
        this.left = left;
        this.right = right;
    }
}