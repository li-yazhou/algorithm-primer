# 543. Diameter of Binary Tree

这是秒针系统的面试题，当时把题目理解错了，面试一个多小时最后挂了。
古有八股，今有Leetcode，加油。

2017-08


## Level

Easy


---


## [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
<pre>
          1
         / \
        2   3
       / \     
      4   5    
</pre>      
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.


---


## Thought

对于每一个结点，经过它的最长路径的长度 = 它的左子树的最大深度 + 右子树的最大深度。


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
//     public int diameterOfBinaryTree(TreeNode root) {
//         if (root == null) return 0;
//         int left = depth(root.left);
//         int right = depth(root.right);
//         return left + right;
//     }
    
//     private int depth(TreeNode root){
//         if (root == null) return 0;
//         int l = depth(root.left);
//         int r = depth(root.right);
//         return Math.max(l, r) + 1;
//     }
    
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root){
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max, l+r);
        return Math.max(l, r) + 1;
    }
}
```