# 572. Subtree of Another Tree

2017-08


## Level

Easy


---


## [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/description/)

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:
<pre>
     3
    / \
   4   5
  / \
 1   2
 </pre>
Given tree t:
<pre>
   4 
  / \
 1   2
 </pre>
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:
<pre>
     3
    / \
   4   5
  / \
 1   2
    /
   0
 </pre>
Given tree t:
<pre>
   4
  / \
 1   2
 </pre>
Return false.


---


## Thought


对比《剑指offer》[剑指offer 面试题18 树的子结构](http://blog.csdn.net/liyazhou0215/article/details/72779679)


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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if (s != null && t != null){
            if (s.val == t.val) result = validate(s, t);
            if (!result) result = isSubtree(s.left, t);
            if (!result) result = isSubtree(s.right, t);
        }
        return result;
    }
    
    private boolean validate(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return true;
        // if (root1 == null) return false;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        if (root1.val != root2.val) return false;
        return validate(root1.left, root2.left) && validate(root1.right, root2.right);
    }
}
```


---


**声明：题目来自Leetcode.**