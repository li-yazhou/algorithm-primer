# 树的前中后序递归与非递归遍历

二叉树前序、中序和后序的递归遍历与非递归遍历

<pre>
二叉树结点的数据结构
private static class Node {
    String val;
    Node left;
    Node right;
    public Node(String _val){ val = _val; }
    public void setChildren(Node _left, Node _right){
        left = _left;
        right = _right;
    }
}
</pre>


## 前序遍历
### 前序遍历的递归遍历

```
    /**
     * 递归方式前序遍历二叉树
     * @param root 二叉树的根结点
     */
    public void preorder(Node root){
        if (root == null) return;
        visit(root);
        preorder(root.left);
        preorder(root.right);
    }
```

### 前序遍历的非递归遍历

```
    /**
     * 非递归方式前序遍历二叉树
     * 数据结构：栈 stack
     * 思路：先弹出并访问栈顶元素，然后将其非空的右孩子、左孩子依次序压入栈顶
     * @param root 二叉树的根结点
     */
    public void iterativePreorder(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node currNode = stack.pop();
            visit(currNode);
            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);
        }
    }


    /**
     * 非递归方式前序遍历二叉树2
     * @param root 二叉树的根结点
     */
    public void iterativePreorder2(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        Node currNode = root;
        while (currNode != null || !stack.isEmpty()){
            while(currNode != null){
                visit(currNode);
                stack.push(currNode);
                currNode = currNode.left;
            }

            if (!stack.isEmpty()){
                currNode = stack.pop();
                currNode = currNode.right;
            }
        }
    }
```


---


## 中序遍历
### 中序遍历的递归遍历

```
    /**
     * 递归方式中序遍历二叉树
     * @param root 二叉树的根结点
     */
    public void inorder(Node root){
        if (root == null) return;
        inorder(root.left);
        visit(root);
        inorder(root.right);
    }

```

### 中序遍历非递归遍历

```
    /**
     * 非递归方式中序遍历二叉树
     * 数据结构：栈
     * 思路：
     *      1. 将当前结点的所有由左指针指向的子孙结点（后代结点）依次压入栈中；
     *      2. 弹出并访问栈顶元素，并将当前结点设置为该栈顶结点的右孩子
     *      3. 执行 1 和 2 ，直到当前结点为空且栈为空，也即是当当前结点或者栈不为空时，重复执行1和2
     *
     * @param root 二叉树的根结点
     */
    public void iterativeInorder(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        Node currNode = root;
        while (currNode != null || !stack.isEmpty()){
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }

            if (!stack.isEmpty()){
                currNode = stack.pop();
                visit(currNode);
                currNode = currNode.right;
            }
        }
    }
```


---


## 后续遍历
### 后序遍历的递归遍历

```
    /**
     * 递归方式后序遍历二叉树
     * @param root 二叉树的根结点
     */
    public void postorder(Node root){
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        visit(root);
    }


```

### 后续遍历的非递归遍历

```
    /**
     * 非递归方式后续遍历二叉树
     * 数据结构：栈
     * 思路：
     *      要保证根结点在左孩子和右孩子之后才能访问，因此对于任一结点node，先将其入栈。
     *      如果node不存在左孩子和右孩子，则可以直接访问它；
     *      或者node存在左孩子或者右孩子，但是其左孩子和右孩子都已经被访问过，则同样可以直接访问该结点。
     *      若非上述两种情况，则将node的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素时，左孩子在右孩子前面被访问，
     *      左孩子和右孩子都在根结点前面被访问。
     * @param root 二叉树的根结点
     */
    public void iterativePostorder(Node root){
        if (root == null) return;
        Node currNode = null;
        Node pre = null;

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            currNode = stack.peek();
            if ((currNode.left == null && currNode.right == null) ||
                    (pre != null && (pre == currNode.left || pre== currNode.right))){
                visit(currNode);
                stack.pop();
                pre = currNode;
            }
            else {
                if (currNode.right != null) stack.push(currNode.right);
                if (currNode.left != null) stack.push(currNode.left);
            }
        }
    }


    /**
     * 非递归方式后序遍历二叉树2
     * 数据结构：栈
     * 难点：需要判断上次访问的结点是位于左子树，还是右子树。
     *       若是位于左子树，则需要跳过根结点，先进入右子树，再回头访问根结点；
     *       若是位于右子树，则直接访问根结点。
     *
     * @param root 二叉树的根结点
     */
    public void iterativePostorder2(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        Node currNode = root;  // 当前结点
        Node preNode = null;  // 上次访问的结点

        while (currNode != null){ // 走到根结点左子树的最左边
            stack.push(currNode);
            currNode = currNode.left;
        }

        while (!stack.isEmpty()){
            currNode = stack.pop();

            // 有右子树，且右子树没有被访问过
            if (currNode.right != null && currNode.right != preNode){
                stack.push(currNode);  // 有右子树，且右子树没有被访问过，则当前结点不能被访问，压入栈中

                currNode = currNode.right;  // 进入右子树
                while (currNode != null){  // 走到右子树的最左边
                    stack.push(currNode);
                    currNode = currNode.left;
                }
            }
            else {  // 没有右子树，或者右子树已经被访问过
                visit(currNode);   // 访问当前结点
                preNode = currNode;  // 修改最近被访问的结点
            }
        }
    }
```


---


## 程序汇总

```
package algorithm.basis.bintree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-06 21:20
 *
 */
public class BinaryTreeVisit {

    private static class Node {
        String val;
        Node left;
        Node right;
        public Node(String _val){ val = _val; }
        public void setChildren(Node _left, Node _right){
            left = _left;
            right = _right;
        }
    }

    /**
     *            A
     *          /   \
     *        B      C
     *      /  \      \
     *     D   E       F
     *     \   /
     *     G  H
     *
     *  levelorder: ABCDEFGH
     *  preorder:   ABDGEHCF
     *  inorder:    DGBHEACF
     *  postorder:  GDHEBFCA
     */
    public Node generateTree(){
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");

        nodeA.setChildren(nodeB, nodeC);
        nodeB.setChildren(nodeD, nodeE);
        nodeC.setChildren(null, nodeF);
        nodeD.setChildren(null, nodeG);
        nodeE.setChildren(nodeH, null);

        return nodeA;
    }


    public void visit(Node node){
        System.out.print(node.val + "\t");
    }

    /**
     * 层次遍历二叉树，广度优先遍历的思路
     * @param root 二叉树的根结点
     */
    public void levelorder(Node root){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            visit(currNode);
            if (currNode.left != null) queue.offer(currNode.left);
            if (currNode.right != null) queue.offer(currNode.right);
        }
    }

    @Test
    public void testLevelorder(){
        Node root = generateTree();
        levelorder(root);
    }

    /**
     * 递归方式前序遍历二叉树
     * @param root 二叉树的根结点
     */
    public void preorder(Node root){
        if (root == null) return;
        visit(root);
        preorder(root.left);
        preorder(root.right);
    }


    /**
     * 非递归方式前序遍历二叉树
     * 数据结构：栈 stack
     * 思路：先弹出并访问栈顶元素，然后将其非空的右孩子、左孩子依次序压入栈顶
     * @param root 二叉树的根结点
     */
    public void iterativePreorder(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node currNode = stack.pop();
            visit(currNode);
            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);
        }
    }


    /**
     * 非递归方式前序遍历二叉树2
     * @param root 二叉树的根结点
     */
    public void iterativePreorder2(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        Node currNode = root;
        while (currNode != null || !stack.isEmpty()){
            while(currNode != null){
                visit(currNode);
                stack.push(currNode);
                currNode = currNode.left;
            }

            if (!stack.isEmpty()){
                currNode = stack.pop();
                currNode = currNode.right;
            }
        }
    }

    @Test
    public void testPreorder(){
        Node root = generateTree();
        preorder(root);
        System.out.println();
        iterativePreorder(root);
        System.out.println();
        iterativePreorder2(root);
    }


    /**
     * 递归方式中序遍历二叉树
     * @param root 二叉树的根结点
     */
    public void inorder(Node root){
        if (root == null) return;
        inorder(root.left);
        visit(root);
        inorder(root.right);
    }


    /**
     * 非递归方式中序遍历二叉树
     * 数据结构：栈
     * 思路：
     *      1. 将当前结点的所有由左指针指向的子孙结点（后代结点）依次压入栈中；
     *      2. 弹出并访问栈顶元素，并将当前结点设置为该栈顶结点的右孩子
     *      3. 执行 1 和 2 ，直到当前结点为空且栈为空，也即是当当前结点或者栈不为空时，重复执行1和2
     *
     * @param root 二叉树的根结点
     */
    public void iterativeInorder(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        Node currNode = root;
        while (currNode != null || !stack.isEmpty()){
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }

            if (!stack.isEmpty()){
                currNode = stack.pop();
                visit(currNode);
                currNode = currNode.right;
            }
        }
    }

    @Test
    public void testInorder(){
        Node root = generateTree();
        inorder(root);
        System.out.println();
        iterativeInorder(root);
    }


    /**
     * 递归方式后序遍历二叉树
     * @param root 二叉树的根结点
     */
    public void postorder(Node root){
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        visit(root);
    }


    /**
     * 非递归方式后续遍历二叉树
     * 数据结构：栈
     * 思路：
     *      要保证根结点在左孩子和右孩子之后才能访问，因此对于任一结点node，先将其入栈。
     *      如果node不存在左孩子和右孩子，则可以直接访问它；
     *      或者node存在左孩子或者右孩子，但是其左孩子和右孩子都已经被访问过，则同样可以直接访问该结点。
     *      若非上述两种情况，则将node的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素时，左孩子在右孩子前面被访问，
     *      左孩子和右孩子都在根结点前面被访问。
     * @param root 二叉树的根结点
     */
    public void iterativePostorder(Node root){
        if (root == null) return;
        Node currNode = null;
        Node pre = null;

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            currNode = stack.peek();
            if ((currNode.left == null && currNode.right == null) ||
                    (pre != null && (pre == currNode.left || pre== currNode.right))){
                visit(currNode);
                stack.pop();
                pre = currNode;
            }
            else {
                if (currNode.right != null) stack.push(currNode.right);
                if (currNode.left != null) stack.push(currNode.left);
            }
        }
    }


    /**
     * 非递归方式后序遍历二叉树2
     * 数据结构：栈
     * 难点：需要判断上次访问的结点是位于左子树，还是右子树。
     *       若是位于左子树，则需要跳过根结点，先进入右子树，再回头访问根结点；
     *       若是位于右子树，则直接访问根结点。
     *
     * @param root 二叉树的根结点
     */
    public void iterativePostorder2(Node root){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        Node currNode = root;  // 当前结点
        Node preNode = null;  // 上次访问的结点

        while (currNode != null){ // 走到根结点左子树的最左边
            stack.push(currNode);
            currNode = currNode.left;
        }

        while (!stack.isEmpty()){
            currNode = stack.pop();

            // 有右子树，且右子树没有被访问过
            if (currNode.right != null && currNode.right != preNode){
                stack.push(currNode);  // 有右子树，且右子树没有被访问过，则当前结点不能被访问，压入栈中

                currNode = currNode.right;  // 进入右子树
                while (currNode != null){  // 走到右子树的最左边
                    stack.push(currNode);
                    currNode = currNode.left;
                }
            }
            else {  // 没有右子树，或者右子树已经被访问过
                visit(currNode);   // 访问当前结点
                preNode = currNode;  // 修改最近被访问的结点
            }
        }
    }

    @Test
    public void testPostorder(){
        Node root = generateTree();
        postorder(root);
        System.out.println();
        iterativePostorder(root);
        System.out.println();
        iterativePostorder2(root);
    }
}

```


----------


## 参考
参考以下两篇优秀的博文，在此表示对作者的感谢。
* http://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html
* http://blog.csdn.net/zhuqiuhui/article/details/51319165

