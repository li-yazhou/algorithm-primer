# 94. Binary Tree Inorder Traversal

2017-08

## Level
Medium


---


## [Description](https://leetcode.com/problems/binary-tree-inorder-traversal)

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
<pre>
   1
    \
     2
    /
   3
</pre>
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?


---


## Thought
递归方式

迭代方式

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
    // ----------------------------------------
    // 迭代方式
    
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()){
            while (currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }
            
            if (!stack.isEmpty()){
                currNode = stack.pop();
                res.add(currNode.val);
                currNode = currNode.right;
                
            }
        }
        
        return res;
    }    
    
    
    // --------------------------------------
    // 递归方式
    
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper2(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res){
        if (root != null){
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
    
    private void helper2(TreeNode root, List<Integer> res){
        if (root == null) return;
        helper2(root.left, res);
        res.add(root.val);
        helper2(root.right, res);
    }
}
```


---


**Note**: The subject is from leetcode.


