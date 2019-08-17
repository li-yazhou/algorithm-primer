# 111. Minimum Depth of Binary Tree

2017-08


## Level
Easy


---


## [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


---


## Thought
层次遍历二叉树


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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // if (root.left == null || root.right == null) return 1;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
		while (!queue.isEmpty()){
            level ++;
            int len = queue.size();
            for (int i = 0; i < len; i ++){
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right == null)
                    return level;
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
        }
        return level;
    }
}
```