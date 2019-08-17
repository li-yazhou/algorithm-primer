# 124. Binary Tree Maximum Path Sum

2017-08


## Level
Hard

---


## [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,
<pre>
       1
      / \
     2   3
 </pre>
Return 6.

---


## Thought
递归

二叉树的最大路径和。
路径，如果选择当前结点，而且其父结点被选择，则它的左右孩子结点最多只能选择一个。


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


/**
 *       -1
 *      /  |
 *     2  3  
 *        / | 
 *       -1  2
 *       /
 *      4  
 */
class Solution {
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root){
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
        
    }
}
```
