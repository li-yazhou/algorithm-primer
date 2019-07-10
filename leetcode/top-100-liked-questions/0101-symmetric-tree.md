# 101. Symmetric Tree

2017-08


## Level
Easy


---


## [Description](https://leetcode.com/problems/symmetric-tree/description/)


Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
<pre>
    1
   / \
  2   2
 / \ / \
3  4 4  3
</pre>
But the following [1,2,2,null,3,null,3] is not:
<pre>
    1
   / \
  2   2
   \   \
   3    3
</pre>
Note:
Bonus points if you could solve it both recursively and iteratively.


---


## Thought
递归


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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    
    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return true;
        
        if (root1 == null || root2 == null) return false;  // 两者只有一者为null，则返回false
        
        if (root1.val != root2.val) return false;  // 两者均不为null，但两者的值不相等
        
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        
    }
}
```


---


**Note**: The subject is from leetcode.

