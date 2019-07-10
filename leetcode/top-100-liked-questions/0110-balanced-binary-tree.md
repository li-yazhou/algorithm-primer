# 110. Balanced Binary Tree

2017-08


## Level
Easy


---


## [Description](https://leetcode.com/problems/balanced-binary-tree/)
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


---


## Thought
递归

二叉树的深度

---


## Solution
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        int l = depth(root.left);
        int r = depth(root.right);
        
        if (Math.abs(l-r) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int depth(TreeNode root){
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        return Math.max(l, r) + 1;
    }
}
```


