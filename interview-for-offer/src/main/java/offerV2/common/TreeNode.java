package offerV2.common;

public class TreeNode {
    public int value;  // id of BinaryTreeNode, unique
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}
    public TreeNode(int value){ this.value = value; }
    public TreeNode(int value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}