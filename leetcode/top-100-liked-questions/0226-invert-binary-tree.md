# 226. Invert Binary Tree

2017-08


## Level

Easy


---


## [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

Invert a binary tree.
<pre>
     4
   /   \
  2     7
 / \   / \
1   3 6   9
</pre>

to

<pre>
     4
   /   \
  7     2
 / \   / \
9   6 3   1
</pre>

Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.


---


## Thought

递归

和[剑指offer 面试题19 二叉树的镜像](http://blog.csdn.net/liyazhou0215/article/details/72780580)基本一样。


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
    
    public TreeNode invertTree(TreeNode root) {
        mirrorTree(root);
        return root;
    }
    
    private void mirrorTree(TreeNode root) {
        if (root == null) return;
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        mirrorTree(root.left);
        mirrorTree(root.right);
    }
    
    
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
    
    
}
```


**声明：题目来自Leetcode。**