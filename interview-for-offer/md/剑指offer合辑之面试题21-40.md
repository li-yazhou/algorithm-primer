## 剑指offer合辑之面试21-40

>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>

## [面试题21 包含 min 函数的栈](#面试题21-包含min函数的栈)
## [面试题22 栈的压入、弹出序列](#面试题22-栈的压入、弹出序列)
## [面试题23 从上到下打印二叉树](#面试题23-从上到下打印二叉树)
## [面试题24 二叉搜索树的后序遍历序列](#面试题24-二叉搜索树的后序遍历序列)
## [面试题25 二叉树中和为某一值的路径](#面试题25-二叉树中和为某一值的路径)
## [面试题26 复杂链表的复制](#面试题26-复杂链表的复制)
## [面试题27 二叉搜索树与双向链表](#面试题27-二叉搜索树与双向链表)
## [面试题28 字符串的排列](#面试题28-字符串的排列)
## [面试题29 数组中出现次数超过一半的数字](#面试题29-数组中出现次数超过一半的数字)
## [面试题30 最小的 k 个数](#面试题30-最小的k个数)
## [面试题31 连续子数组的最大和](#面试题31-连续子数组的最大和)
## [面试题32 从 1 到 n 整数中 1 出现的次数](#面试题32-从1到n整数中1出现的次数)
## [面试题33 把数组排成最小的数](#面试题33-把数组排成最小的数)
## [面试题34 丑数](#面试题34-丑数)
## [面试题35 第一个只出现一次的字符](#面试题35-第一个只出现一次的字符)
## [面试题36 数组中的逆数对](#面试题36-数组中的逆数对)
## [面试题37 两个链表的第一个公共结点](#面试题37-两个链表的第一个公共结点)
## [面试题38 数字在排序数组中出现的次数](#面试题38-数字在排序数组中出现的次数)
## [面试题39 二叉树的深度](#面试题39-二叉树的深度)
## [面试题40 数组中只出现一次的数字](#面试题40-数组中只出现一次的数字)


## 面试题21 包含min函数的栈

> **题目：**
>
>  定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数，
>  在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

```
package algorithm.foroffer.top30;

import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/27.
 * 面试题21：包含 min 函数的栈
 *
 * 题目：
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数，
 *      在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 问题：
 *      1. 栈的特性
 *      2. 求栈中的最小元素
 *
 * 思路：
 *      1. 使用索引栈
 *      2. 每次添加新元素时，在辅助栈中保存当前数据栈中的最小元素的位置
 */

/**
 * 对 T extends Comparable<T> 的理解：
 *
 * 1. T 必须实现 Comparable 接口，(并且这个接口类型是T)
 * 2. 需要给接口的抽象方法 compareTo 的参数类型为 T，也即是 compareTo(T t)
 * 比如 String implements Comparable<String>
 * 
 * @param <T>
 */
class StackWithMin<T extends Comparable<T>>{
    Stack<T> dataStack;   // 数据栈，保存压入的数据
    Stack<Integer> minIdxStack;  // 索引栈，该位置保存与数据栈的相同位置到栈底之间的最小元素的位置
    int minIdx;

    public StackWithMin(){
        dataStack = new Stack<>();
        minIdxStack = new Stack<>();
        minIdx = 0;
    }

    public void push(T element){
        if (element == null) throw new RuntimeException("the element is null.");
        dataStack.push(element);

        if (!minIdxStack.isEmpty()) {
            minIdx = dataStack.get(minIdxStack.peek()).compareTo(element) < 0 ? minIdx : dataStack.size()-1;
        }
        minIdxStack.push(minIdx);
    }

    public T pop(){
        if (dataStack.isEmpty()) throw new RuntimeException("The stack is already null.");
        minIdxStack.pop();
        return dataStack.pop();
    }

    public T min(){
        if (dataStack.isEmpty()) throw new RuntimeException("The stack is already null.");
        return dataStack.get(minIdxStack.peek());
    }

    @Override
    public String toString(){
        return dataStack.toString();
    }
}


public class Test21 {
    public static void main(String[] args){
        StackWithMin<Double> stack = new StackWithMin<>();
        stack.push(10.0);
        stack.push(15.0);
        stack.push(11.0);
        stack.push(2.0);
        stack.push(1.0);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.min());
    }
}

```




## 面试题22 栈的压入、弹出序列

> **题目：**
>
>  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
>  假设压入栈的所有数字均不相等。
>  例如序列 1、2、3、4、5 是某栈的压栈序列，序列 4、5、3、2、1 是该压栈序列对应的一个弹出序列，
>  但 4、3、5、1、2 就不可能是该压栈序列的弹出序列。

```
package algorithm.foroffer.top30;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/27.
 * 面试题22：栈的压入、弹出序列
 *
 * 题目：
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *      假设压入栈的所有数字均不相等。
 *      例如序列 1、2、3、4、5 是某栈的压栈序列，序列 4、5、3、2、1 是该压栈序列对应的一个弹出序列，
 *      但 4、3、5、1、2 就不可能是该压栈序列的弹出序列。
 *
 * 问题：
 *      1. 使用辅助栈
 *      2. 顺序压栈和有条件的出栈操作
 *
 * 思路：
 *      1. 两个序列存储在数组中，创建一个辅助栈（数据结构）
 *      2. 将压入序列的"第一个元素"依次压入到辅助栈中，（算法）
 *          如果辅助栈的栈顶元素和弹出序列的"第一个元素"相等，则从辅助栈弹出该元素；
 *          // 如果辅助栈为空，则继续压入压入序列中为入栈的元素；
 *      3. 辅助栈为空，该弹出序列是压入序列的出栈序列，返回 true；否则两者不匹配，返回 false。
 *         (如果辅助栈栈顶元素和弹出序列的"第一个元素"不相等，而且压入栈没有要压入辅助栈中的元素，返回 false)
 *
 *
 */
public class Test22 {

    public static boolean isPopOrder(int[] pushOrder, int[] popOrder){
        if (pushOrder == null || popOrder == null || pushOrder.length != popOrder.length) return false;

        boolean result = false;
        Stack<Integer> stack = new Stack<>();
        int popNum = 0;
        for (int i = 0; i < pushOrder.length; i++){  // 依次将压入序列中的元素压入到辅助栈
            stack.push(pushOrder[i]);
            // 从辅助栈中弹出和弹出序列中匹配的元素
            while (!stack.isEmpty() && stack.peek() == popOrder[popNum]){
                stack.pop();
                popNum ++;
            }
        }
        if (stack.isEmpty()) result = true;  // 压入序列和弹出序列中的所有的元素都匹配
        return result;
    }


    public static void main(String[] args){
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[][] popOrders = {
                {4, 5, 3, 2, 1},
                {4, 5, 3, 1, 2},
                {4, 5, 3, 1, 6},
        };
        for (int i = 0; i < popOrders.length; i++){
            System.out.print("压入序列：" + Arrays.toString(pushOrder) + "  ");
            System.out.print("弹出序列：" + Arrays.toString(popOrders[i]) + "  ");
            System.out.println(Test22.isPopOrder(pushOrder, popOrders[i]));
        }
    }
}

```




## 面试题23 从上到下打印二叉树

>**题目：**
>
> 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
> 例如输入下图的二叉树，则依次打印出 8、6、10、5、7、9、11.

```
package algorithm.foroffer.top30;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题23：从上往下打印二叉树
 *
 * 题目：
 *      从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 *      例如输入下图的二叉树，则依次打印出 8、6、10、5、7、9、11.
 *                  8
 *                /   \
 *              6      10
 *            /  \    /  \
 *           5   7   9   11
 *
 * 问题：
 *      1. 层次遍历二叉树
 *
 * 思路：
 *      1. 层次遍历二叉树，是广度优先搜索，需要使用队列
 *      2. 创建队列，并把根结点入队
 *         循环：队列不为空
 *              队列的首元素出队，并访问该元素
 *              如果当前元素的左孩子不为空，则入队
 *              如果当前元素的右孩子不为空，则入队
 */

class TreeNode23{
    int value;
    TreeNode23 left;
    TreeNode23 right;

    public TreeNode23(int value){ this.value = value; }

    public void setChildren(TreeNode23 left, TreeNode23 right) {
        this.left = left;
        this.right = right;
    }
}

public class Test23 {

    /**
     * 层次遍历二叉树
     * @param root 二叉树的根结点
     */
    public static void levelVisitTree(TreeNode23 root){
        if (root == null) return;

        Queue<TreeNode23> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()){
        for (queue.offer(root); !queue.isEmpty();){
            TreeNode23 currNode = queue.poll();
            System.out.print(currNode.value + "\t");

            if (currNode.left != null) queue.offer(currNode.left);
            if (currNode.right != null) queue.offer(currNode.right);
        }
    }

    public static void main(String[] args){
        TreeNode23 root = generateTree();
        Test23.levelVisitTree(root);
    }

    private static TreeNode23 generateTree() {
        TreeNode23 treeNode0 = new TreeNode23(8);

        TreeNode23 treeNode1 = new TreeNode23(6);
        TreeNode23 treeNode2 = new TreeNode23(10);

        TreeNode23 treeNode3 = new TreeNode23(5);
        TreeNode23 treeNode4 = new TreeNode23(7);
        TreeNode23 treeNode5 = new TreeNode23(9);
        TreeNode23 treeNode6 = new TreeNode23(11);

        treeNode0.setChildren(treeNode1, treeNode2);
        treeNode1.setChildren(treeNode3, treeNode4);
        treeNode2.setChildren(treeNode5, treeNode6);

        return treeNode0;
    }
}

```




## 面试题24 二叉搜索树的后序遍历序列

>**题目：**
>
> 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
> 如果是则返回 true，否则返回 false。
> 假设输入的数组的任意两个数字都互不相同。

```
package algorithm.foroffer.top30;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题24：二叉搜索树的后序遍历序列
 *
 * 题目：
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *      如果是则返回 true，否则返回 false。
 *      假设输入的数组的任意两个数字都互不相同。
 *
 * 问题：
 *      1. 二叉搜索树的性质
 *      2. 二叉树的后序遍历结果的特点
 *      3. 递归
 *
 * 思路：
 *      1. 二叉搜索树的性质，根结点比左孩子大，根结点比右孩子小
 *      2. 二叉树的后序遍历结果，最后的一个结点总是根结点
 *      3. 以最后一个元素作为分割点，将后序遍历结果分为两部分，其左子树和右子树的后序遍历结果
 *         判断每一个棵子树的是否满足条件，根结点比左孩子大，根结点比右孩子小
 *
 */
public class Test24 {

    public static boolean vertifySeqOfBST(int[] postorder, int start, int end){
        // System.out.println(String.format("start, end = %d, %d", start, end));
        // 应该在传入参数之前判断，免得每次递归都得进行判断
        if (postorder == null) return false;

        int split;
        for (split = start; split < end - 1; split++){  // 最后一个元素是根结点，不判断
            if (postorder[split] > postorder[end-1])  break;
        }


        // 递归终止条件
        // 如果根结点比其右孩子大，则返回 false
        for (int i = split; i < end; i++)
            if (postorder[i] < postorder[end - 1]) return false;


        boolean left = true;
        // 有条件的递归，其递归终止条件是 split <= start
        if (split > start) // 该区间的元素大于或者等于 2 个
            left = vertifySeqOfBST(postorder, start, split);

        boolean right = true;
        // 有条件的递归，其递归终止条件是 split >= end-1
        if (split < end-1)  // 该区间的元素大于或者等于 2 个
            right = vertifySeqOfBST(postorder, split, end-1); // 最后一个元素是根结点，不进入下一轮

        return (left && right);
    }

    public static void main(String[] args){
        int[][] seqs = {
                {5, 7, 6, 9, 11, 10, 8},
                {5, 7, 6, 9, 11, 5, 8}
        };

        for (int i = 0; i < seqs.length; i++)
            System.out.println(Test24.vertifySeqOfBST(seqs[i], 0, seqs[i].length));
    }

}

```




## 面试题25 二叉树中和为某一值的路径

> **题目：**
>
> 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
> 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。二叉树的定义如下：

```
package algorithm.foroffer.top30;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题25：二叉树中和为某一值的路径
 *
 * 题目：
 *      输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *      从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。二叉树的定义如下：
 *
 * 问题：
 *      1. 前序遍历二叉树
 *      2. 栈
 *
 * 思路：
 *      1. 前序遍历二叉树，并把当前结点的值入栈
 *         如果当前结点是叶子结点，判断栈中的所有元素之和是否为指定值，如果是，则输出该路径，否则不操作
 *         如果当前结点的左孩子不是叶子结点，则前序遍历以该结点的左孩子为根结点的子树
 *         如果当前结点的右孩子不是叶子结点，则前序遍历以该结点的右孩子为根结点的子树
 *
 *         在返回到父结点之前，在路径上删除当前节点（从栈中弹出该结点）
 *
 */

class TreeNode25{
    int value;
    TreeNode25 left;
    TreeNode25 right;
    public TreeNode25(int value){ this.value = value; }
    public void setChildren(TreeNode25 left, TreeNode25 right){
        this.left = left;
        this.right = right;
    }
}

public class Test25 {

    public static void findPath(TreeNode25 root, int expectedSum){
        if (root == null) return;
        Stack<Integer> stack = new Stack<>();
        findPath(root, stack, expectedSum);
    }

    /**
     * 查找符合条件的路径
     * 前序遍历二叉树
     * @param root 二叉树的根结点
     * @param stack 存储结点的值
     * @param expectedSum 路径上各个元素之和的期望值
     */
    private static void findPath(TreeNode25 root, Stack<Integer> stack, int expectedSum){
        // 前序遍历的操作
        stack.push(root.value);
        // 当前结点为叶子结点时，判断从根结点到该叶子结点的路径上所有元素的值之和
        if (root.left == null && root.right == null){
            int sum = 0;
            // for(int i = 0; i < stack.size(); i++) sum += stack.get(i);
            for (int value : stack) sum += value;
            if (sum == expectedSum) System.out.println(stack);
        }

        // 对当前结点的左孩子的递归操作
        if (root.left != null) findPath(root.left, stack, expectedSum);
        // 对当前结点的右孩子的递归操作
        if (root.right != null) findPath(root.right, stack, expectedSum);

        // todo, 返回到父结点之前，在路径上删除当前结点
        stack.pop();
    }

    public static void main(String[] args){
        TreeNode25 root = generateTree();
        findPath(root, 22);
    }

    private static TreeNode25 generateTree() {
        TreeNode25 node0 = new TreeNode25(10);
        TreeNode25 node1 = new TreeNode25(5);
        TreeNode25 node2 = new TreeNode25(12);
        TreeNode25 node3 = new TreeNode25(4);
        TreeNode25 node4 = new TreeNode25(7);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);

        return node0;
    }
}

```





## 面试题26 复杂链表的复制

>**题目：**
>
> 请实现函数 ComplexListNode clone(ComplexListNode head)，
> 复制一个复杂链表。在复杂链表中，每个结点除了有一个指向下一个结点的指针外，
> 还有一个指向链表中的任意结点或者 null。结点的定义如下：

```
package algorithm.foroffer.top30;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题26：复杂链表的复制
 *
 * 题目：
 *      请实现函数 ComplexListNode clone(ComplexListNode head)，
 *      复制一个复杂链表。在复杂链表中，每个结点除了有一个指向下一个结点的指针外，
 *      还有一个指向链表中的任意结点或者 null。结点的定义如下：
 *
 * 问题：
 *      1. 链表的遍历
 *      2. 链表的指针操作
 *
 * 思路：
 *      1. 复制各个结点，并将它们分别插入到它们的原始结点的后面
 *      2. 取出每个结点 N 的 sibling 指向的结点 S，副本结点 N' 的 sibling 值就是 S 后面的结点
 *          即是 N'.sibling = N.sibling.next // N.next.sibling = N.sibling.next
 *      3. 将这个长链表拆分为两个链表
 *          将奇数位置的结点链接起来就是原始链表，
 *          将偶数位置的结点链接起来就是原始链表的副本。
 *
 *          0   1   2   3   4   5
 *           \ / \ / \ / \ / \ / \
 *            0   1   2   3   4   5（边界分析）
 *
 *
 */

class ComplexListNode{
    int value;
    ComplexListNode next;
    ComplexListNode sibling;

    public ComplexListNode(int value){ this.value = value; }
    public void setNodes(ComplexListNode next, ComplexListNode sibling){
        this.next = next;
        this.sibling = sibling;
    }
}

public class Test26 {

    public static ComplexListNode clone(ComplexListNode head){
        if (head == null) return null;

        // 1. 复制各个结点，并将它们的副本结点作为它们的后继结点
        ComplexListNode cpNode;
        for (ComplexListNode currNode = head; currNode != null; currNode = currNode.next.next){
            cpNode = new ComplexListNode(currNode.value);
            cpNode.next = currNode.next;
            currNode.next = cpNode;
        }

        // 2. 取出每个结点 N 的 sibling 指向的结点 S，副本结点 N' 的 sibling 值就是 S 后面的结点
        // 即是 N'.sibling = N.sibling.next // N.next.sibling = N.sibling.next
        for(ComplexListNode currNode = head; currNode != null; currNode = currNode.next.next){
            currNode.next.sibling = currNode.sibling.next;
        }

        // 3. 将这个长链表拆分为两个链表，
        // 将奇数位置的结点链接起来就是原始链表，
        // 将偶数位置的结点链接起来就是原始链表的副本。
        // printList(head);
        ComplexListNode newHead = head.next;
        cpNode = newHead;
        for (ComplexListNode currNode = head; currNode != null; currNode = currNode.next){
            currNode.next = currNode.next.next;
            if (cpNode.next == null)  cpNode.next = null;   // 最后一个元素的后继结点是 null
            else                      cpNode.next = cpNode.next.next;
            cpNode = cpNode.next;
        }

        // for (cpNode = newHead; cpNode != null; cpNode = cpNode.next)
        //    cpNode.next = cpNode.next.next;
        return newHead;
    }

    public static void main(String[] args){
        ComplexListNode node0 = new ComplexListNode(0);
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);

        node0.setNodes(node1, node2);
        node1.setNodes(node2, node3);
        node2.setNodes(node3, node4);
        node3.setNodes(node4, node5);
        node4.setNodes(node5, node0);
        node5.setNodes(null, node2);

        printList(node0);
        System.out.println("\n----------------------------------\n");
        ComplexListNode cpHead = clone(node0);
        System.out.println("\n----------------------------------\n");
        printList(node0);
        System.out.println("\n----------------------------------\n");
        printList(cpHead);
    }

    private static void printList(ComplexListNode cpHead){
        for (ComplexListNode cpNode = cpHead; cpNode != null; cpNode = cpNode.next){
            System.out.print(cpNode.value + ",\t\t\t");
            if (cpNode.next != null) System.out.print(cpNode.next.value + ",\t\t\t");
            else System.out.print("null, \t\t\t");
            if (cpNode.sibling != null) System.out.print(cpNode.sibling.value);
            System.out.println();
        }
    }

}

```



## 面试题27 二叉搜索树与双向链表

> **面试题：**
>
> 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
> 要求不能创建任何新的结点，只能调整树中结点指针的指向。
> 比如输入下图中左边的二叉搜索树，则输出转换之后的排序双向链表。


```
package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题27：二叉搜索树和双向链表
 *
 * 题目：
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *      比如输入下图中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *
 *                      10
 *                    /    \
 *                  6       14
 *                /  \     /  \
 *               4    8   12  16
 *
 *        4 === 6 === 8 === 10 === 12 === 14 === 16
 *
 *  问题：
 *          1. 中序遍历二叉树
 *
 *  思路:
 *          1. 按书本C语言代码实现，感觉到很绕，没搞明白，需要继续思考
 */

class BinTreeNode{
    int value;
    BinTreeNode left;
    BinTreeNode right;
    public BinTreeNode(int value){ this.value = value; }
    public void setChildren(BinTreeNode left, BinTreeNode right){
        this.left = left;
        this.right = right;
    }
}


public class Test27 {

    public BinTreeNode convert(BinTreeNode root){
        BinTreeNode[] tailNode = new BinTreeNode[1];
        convert(root, tailNode);

        // tailNode 指向双向链表的尾结点，将其移动到头结点的位置
        BinTreeNode head = tailNode[0];
        for (; head != null && head.left != null; head = head.left);
        return head;

    }

    private void convert(BinTreeNode currNode, BinTreeNode[] tailNode){
        if (currNode == null) return;

        if (currNode.left != null) convert(currNode.left, tailNode);

        currNode.left = tailNode[0];

        if (tailNode[0] != null) tailNode[0].right = currNode;

        tailNode[0] = currNode;

        if (currNode.right != null) convert(currNode.right, tailNode);

    }

    public static void main(String[] args){
        BinTreeNode node0 = new BinTreeNode(10);
        BinTreeNode node1 = new BinTreeNode(6);
        BinTreeNode node2 = new BinTreeNode(14);
        BinTreeNode node3 = new BinTreeNode(4);
        BinTreeNode node4 = new BinTreeNode(8);
        BinTreeNode node5 = new BinTreeNode(12);
        BinTreeNode node6 = new BinTreeNode(16);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        BinTreeNode head = new Test27().convert(node0);
        System.out.println(head);
        for(; head != null; head = head.right)
            System.out.print(head.value + " -- ");
    }
}

```




 ## 面试题28 字符串的排列
 
> **题目：**
>
> 输入一个字符串，打印出该字符串中字符的所有排列。
> 例如输入字符串 abc，则打印出 a、b、c 所能排列出来的所有字符串
> abc、acb、bac、bca、cab 和 cba。


```
package algorithm.foroffer.top30;

/**
 * Created by liyazhou on 2017/5/29.
 * 面试题28：字符串的排列 
 *
 * 题目：
 *      输入一个字符串，打印出该字符串中字符的所有排列。
 *      例如输入字符串 abc，则打印出 a、b、c 所能排列出来的所有字符串
 *      abc、acb、bac、bca、cab 和 cba。
 *
 * 问题：
 *      1. 递归求解
 *
 * 思路：
 *      1. 把字符串分为两部分，一部分是字符串的第一个字符，另一部分是第一个字符以后的所有字符
 *         求第二部分字符串的排列
 *      2. 第一个字符和它后面的字符交换位置
 *
 *
 */
public class Test28 {

    public static void permutation(char[] chars){
        if (chars == null) return;
        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int start) {
        if (start == chars.length) {
            System.out.println(chars);
        }

        for (int idx = start; idx < chars.length; idx++){
            char tmp = chars[idx];
            chars[idx] = chars[start];
            chars[start] = tmp;

            permutation(chars, start+1);

            tmp = chars[idx];
            chars[idx] = chars[start];
            chars[start] = tmp;
        }
    }


    public static void main(String[] args){
        String str = "abc";
        char[] chars = str.toCharArray();
        permutation(chars);
    }

}

```


# 集合的所有子集


## 思路
类似位操作。思路:假设集合有4个元素{a,b,c,d}，那么做一个for循环从0到15，每次输出一个子集。0(0000)表示空子集，1(0001)因为最低位为1，所以在集合四个元素中取第一个元素{a}作为一个子集，2(0010)因为次低位为1，所以在集合四个元素中取第二个元素{b}作为一个子集，3(0011)因为最低位和次低位都为1，所以在集合四个元素中取第一、第二个元素{a,b}作为一个子集......，依次类推15(1111)表示{a,b,c,d}。再举个详细例子：
假设有集合{a,b,c}，则：迭代0到2^n-1==0到7
0(000)：{}
1(001)：{a}
2(010)：{b}
3(011)：{ab}
4(100)：{c}
5(101)：{a,c}
6(110)：{b,c}
7(111)：{a,b,c}


## 程序

```
import java.util.HashSet;
import java.util.Set;

public class SubSet {

	public static void main(String[] args) {
		int[] set = new int[]{1,2};
		Set<Set<Integer>> result = getSubSet(set);	//调用方法
		
		//输出结果
		for(Set<Integer> subSet: result){
			for(Integer num: subSet)
				System.out.print(num);
			
			System.out.println("");
		}
	}
	
	public static Set<Set<Integer>> getSubSet(int[] set){
		Set<Set<Integer>> result = new HashSet<Set<Integer>>();	//用来存放子集的集合，如{{},{1},{2},{1,2}}
		int length = set.length;
		int num = length==0 ? 0 : 1<<(length);	//2的n次方，若集合set为空，num为0；若集合set有4个元素，那么num为16.
		
		//从0到2^n-1（[00...00]到[11...11]）
		for(int i = 0; i < num; i++){		
			Set<Integer> subSet = new HashSet<Integer>();
			
			int index = i;
			for(int j = 0; j < length; j++){
				if((index & 1) == 1){		//每次判断index最低位是否为1，为1则把集合set的第j个元素放到子集中
					subSet.add(set[j]);
				}
				index >>= 1;		//右移一位
			}
			
			result.add(subSet);		//把子集存储起来
		}
		return result;
	}

}
```

作者：zo chen
链接：https://www.zhihu.com/question/29985661/answer/46501393
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






## 面试题29 数组中出现次数超过一半的数字

> **题目：**
>
>  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
>  例如输入一个长度为 9 的数组 {1, 2, 3, 2, 2, 2, 5, 4, 2}。
>  由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。

```
package algorithm.foroffer.top30;

/**
 * Created by liyazhou on 2017/5/29.
 * 面试题29：数组中出现次数超过一半的数字
 *
 * 题目：
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为 9 的数组 {1, 2, 3, 2, 2, 2, 5, 4, 2}。
 *      由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
 *
 * 问题：
 *      1. 对如此题目晕菜，第一感觉就是统计每一个数字出现的次数
 *
 * 思路：
 *      1. 遍历数组时，保存两个值，一个是数组中的一个数字，一个是次数。
 *         当遍历到下一个数字时候，如果其和之前保存的数字相同，则次数加 1，否则次数减 1。
 *         如果次数为零，则保存下一个数字，并把次数设为 1。
 *         最后一次把次数设置为 1 时，保存的数字即为出现次数超过数组长度一半的数字。
 */
public class Test29 {

    public static int findNum(int[] array){
        if (array == null) throw new RuntimeException("Invalid input, array is null.");

        int num = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i ++){
            if (times == 0){    // // 如果次数等于0，则保存当前数组，并将次数设置为1
                num = array[i];
                times ++;
            }else{    // 如果次数不等于0，若当前值跟保存值相等则次数加1，否则减1
                if (array[i] == num) times ++;
                else				 times --;
            }
        }

        return num;
    }

    public static void main(String[] args){
        int[][] numbers = {
                {1, 2, 3, 2, 2, 2, 5, 4, 2},
                {1, 2, 3, 2, 2, 2, 5, 4, 2, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        for (int i = 0; i < numbers.length; i++)
            System.out.println(findNum(numbers[i]));
    }
}

```


----------


另外，牛客上的额外要求是，如果不存在过半的数字则返回0，代码如下：

```
    public static int findNum2(int[] array){
        if (array == null) throw new RuntimeException("Invalid input, array is null.");

        int num = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i ++){
            if (times == 0){    // // 如果次数等于0，则保存当前数组，并将次数设置为1
                num = array[i];
                times = 1;
            }else{    // 如果次数不等于0，若当前值跟保存值相等则次数加1，否则减1
                if (array[i] == num) times ++;
                else				 times --;
            }
        }

        // 验证是否过半
        int counter = 0;
        for (int i = 0; i < array.length; i ++){
            if (array[i] == num) counter ++;
        }
        // 如果不过半，则返回0
        if (counter <= array.length/2) num = 0;

        return num;
    }
```





## 面试题30 最小的k个数

>**题目：**
>
> 输入 n 个整数，找出其中最小的 k 个数。
> 例如输入 4、5、1、6、2、7、3、8 这 8 个数字，则最小的 4 个数是 1、2、3、4。

```
package algorithm.foroffer.top30;

import java.util.*;

/**
 * Created by liyazhou on 2017/5/29.
 * 面试题30：最小的 k 个数
 *
 * 题目：
 *      输入 n 个整数，找出其中最小的 k 个数。
 *      例如输入 4、5、1、6、2、7、3、8 这 8 个数字，则最小的 4 个数是 1、2、3、4。
 *
 * 问题：
 *      1. 最大堆
 *
 * 思路：
 *      1. 使用最大堆，优先队列 PriorityQueue 和比较器 Comparator
 *      2. 将数组的中前 k 个数字存储到 最大堆中
 *      3. 遍历在数组区间[k,n)的元素，
 *             如果该元素小于最大堆中的第一个元素，则最大堆中的第一个元素出队，将该元素加入最大堆中
 */
public class Test30 {

    /**
     * AC
     * 2017-8-14 10:55:53
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k <= 0 || k > input.length) return new ArrayList<Integer>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int i = 0; i < k; i ++) maxHeap.offer(input[i]);

        for (int j = k; j < input.length; j ++){
            if (input[j] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(input[j]);
            }
        }

        // ArrayList<Integer> result = new ArrayList<>(k);
        // for (int i = 0; i < k; i ++){
        //    int idx = k - i - 1;  // 逆序保存
        //    result.add(idx, maxHeap.poll());
        // }

        Integer[] result = new Integer[k];
        for (int i = 0; i < k; i ++){
            int idx = k - i - 1;
            result[idx] = maxHeap.poll();
        }
        return new ArrayList<>(Arrays.asList(result));
    }


    //---------------------------------------------------------------


    public Integer[] minNums(int[] array, int k){
        Queue<Integer> maxHeap = getMaxHeap(k);

        for (int i = 0; i < k; i++) maxHeap.offer(array[i]);

        for (int i = k; i < array.length; i++)
            if (array[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }

        return maxHeap.toArray(new Integer[0]);
    }

    private Queue<Integer> getMaxHeap(int k){
        Comparator<Integer> revCmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer first, Integer second){
                return second - first;
            }
        };
        // Comparator<Integer> revCmp = Collections.reverseOrder();
        return new PriorityQueue<>(k, revCmp);
    }


    public static void main(String[] args){
        int[][] arrays = {
                {4, 5, 1, 6, 2, 7, 3, 8},
                {4, 5, 1, 6, 2, 7, 3, 8, -1, 10, -2},
        };

        for (int i = 0; i < arrays.length; i++){
            Integer[] minNums = new Test30().minNums(arrays[i], 5);
            System.out.println(Arrays.toString(minNums));
        }
    }
}

```





## 面试题32 从1到n整数中1出现的次数

> **题目：**
>
> 输入一个整数 n，求从 1 到 n 这 n 个整数中的十进制表示中 1 出现的次数。
> 例如输入 12， 从 1 到 12 这些整数中包含 1 的数字有 1，10，11 和 12，
> 1 一共出现了 5 次。

```
package algorithm.foroffer.top40;

/**
 * Created by liyazhou on 2017/5/29.
 * 面试题32：从 1 到 n 整数中 1 出现的次数
 *
 * 题目：
 *      输入一个整数 n，求从 1 到 n 这 n 个整数中的十进制表示中 1 出现的次数。
 *      例如输入 12， 从 1 到 12 这些整数中包含 1 的数字有 1，10，11 和 12，
 *      1 一共出现了 5 次。
 *
 * 考查点：
 *      1. 找规律
 *
 * 思路：
 *
 */
public class Test32 {

    public static int countNumOfOne(int n){
        int counter = 0;
        for (int i = 1; i <= n; i ++){
            for (int number = i; number != 0; number /= 10){
                if (number % 10 == 1)
                    counter ++;
            }
        }

        return counter;
    }

    public static void main(String[] args){
        int[] nums = {11, 12};

        for(int num: nums){
            for (int i = 1; i <= num; i ++) System.out.print(i + "\t");
            System.out.println("\n" + countNumOfOne(num) + "\n");
        }
    }
}

```





## 面试题31 连续子数组的最大和

> **题目：**
>
>  输入一个整型数组，数组里有正数也有负数。数组中一个或者连续的多个整数组成一个子数组。
>  所有子数组的和的最大值。要求时间复杂度是 O(n)。


```
package algorithm.foroffer.top40;

import java.util.Arrays;

/**
 * Created by liyazhou on 2017/5/29.
 * 面试题31：连续子数组的最大和
 *
 * 题目：
 *      输入一个整型数组，数组里有正数也有负数。数组中一个或者连续的多个整数组成一个子数组。
 *      求所有子数组的和的最大值。要求时间复杂度是 O(n)。
 *
 * 考查点：
 *      1. 动态规划
 *         函数 f(i) 表示以第 i 个数字结尾的子数组的最大和
 *
 * 思路：
 *      1. 连续子数组的最大和 maxSum 的初始值是数组的首元素，
 *         当前元素之前的资产 currSum 的初始值是数组的首元素
 *      2. 遍历[1,n)区间的数组元素，
 *             如果资产 currSum 小于0，是负资产，抛弃，设置 currSum = 0
 *             当前元素之前的资产 currSum 累加当前元素的值，结果为新的资产
 *             如果新的资产大于最大资产，则更新最大资源值为新的资产值
 */

public class Test31 {

    public static int findMaxSumOfSubArray(int[] array){
        if (array == null) throw new RuntimeException("Invalid input. Array is null.");

        int maxSum = array[0];
        int currSum = array[0];

        for (int i = 1; i < array.length; i ++){
            // 当前元素之前的若干元素的和 currSum, if currSum < 0，表示其是负资产，不参与下一轮的计算
            if (currSum < 0) currSum = 0;
            currSum += array[i];
            if (maxSum < currSum) maxSum = currSum;   // max = max > currSum ? max : currSum;
        }

        return maxSum;
    }


    public static void main(String[] args){
        int[][] arrays = {
                {1, -2, 3, 10, -4, 7, 2, -15},
                {5, -1, -3, -4, -7, -2, -15},
                {-5, 1, -3, -4, -7, -2, -15},
        };

        for (int i = 0; i < arrays.length; i++){
            System.out.print(Arrays.toString(arrays[i]) + ":\t");
            System.out.println(findMaxSumOfSubArray(arrays[i]));
        }
    }


}

```




## 面试题33 把数组排成最小的数

>
> **题目：**
>
>  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个，
>  例如输入数组 {3, 32, 321}，则打印出这 3 个数字能排成的最小数字 321323。

```
package algorithm.foroffer.top40;

import java.util.*;

/**
 * Created by liyazhou on 2017/5/30.
 * 面试题33：把数组排成最小的数
 *
 * 题目：
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个，
 *      例如输入数组 {3, 32, 321}，则打印出这 3 个数字能排成的最小数字 321323。
 *
 * 考查点：
 *      1. 字符串排序，// 字典顺序排序（字典序顺序排序，字典序逆序排序）
 *      2. 比较器
 *
 * 思路：
 *      1. 将数组中所有的整数转换为字符串
 *      2. 比较两个字符串A、B的大小（谁排在前，谁排在后）的原则：
 *         比较 A+B 和 B+A，让两者按字典序排序的准则，返回大小值（后验），
 *         A、B 依据返回的结果进行排序
 */
public class Test33 {

    public static void cancatMinNumber(int[] array){
        List<String> dictOrderList = new LinkedList<>();
        for (int element: array)
            dictOrderList.add(element + "");

        Collections.sort(dictOrderList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (String num: dictOrderList)
            System.out.print(num);
    }

    public static void main(String[] args){
        int[][] arrays = {
                {3, 32, 323},
                {31, 32, 323},
        };
        for(int[] array: arrays){
            System.out.println(Arrays.toString(array));
            cancatMinNumber(array);
            System.out.println();
        }
    }

}

```


----------


和以上大致相同的解法。
（2017-8-15 10:12:35）
```
import java.util.*;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        // List<Integer> list = Arrays.asList(numbers);
        Integer[] array = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i ++)
            array[i] = numbers[i];
        
        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer t1, Integer t2){
                int num1 = Integer.valueOf("" + t1 + t2);  // 代表t1放在前面
                int num2 = Integer.valueOf("" + t2 + t1);  // 代表t2放在前面
                int result = 0;
                if (num1 > num2) result = 1;               // 升序排序，t1+t2较大，则t1放后面
                else if (num1 < num2) result = -1;         // 升序排序，t1+t2较小，则t1放前面
                return result;
            }
        };
		Arrays.sort(array, cmp);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < array.length; i ++)
            s.append(array[i]);
        return s.toString();
    }
}
```





## 面试题34 丑数

> **题目：**
>
> 我们把只包含因子 2、3 和 5 的数称作为丑数（Ugly number）。求从小到大的顺序的第 1500 个丑数。
> 例如 6、8 都是丑数，但 14 不是，因为它包含了因子 7。习惯上，我们把 1 当做第一个丑数。

```
package algorithm.foroffer.top40;

/**
 * Created by liyazhou on 2017/5/30.
 * 面试题34：丑数
 *
 * 题目：
 *      我们把只包含因子 2、3 和 5 的数称作为丑数（Ugly number）。求从小到大的顺序的第 1500 个丑数。
 *      例如 6、8 都是丑数，但 14 不是，因为它包含了因子 7。习惯上，我们把 1 当做第一个丑数。
 *
 * 考查点：
 *      1. 根据定义找规律（没找到 =_=）
 *
 * 思路：
 *      1. 本办法，依次判断每一个自然数是否是丑数，当 k =1500 时明显感觉算时间较长
 *
 */
public class Test34 {

    public static int getKthUglyNumber(int k){
        if (k < 1) return -1;
         for (int number = 1; ; number++){
             if (isUgly(number)) k--;
             if (k == 0) return number;
        }
    }

    private static boolean isUgly(int number){
        while (number % 2 == 0) number /= 2;
        while (number % 3 == 0) number /= 3;
        while (number % 5 == 0) number /= 5;
        return number == 1;
    }

    public static void main(String[] args){
        System.out.println(getKthUglyNumber(8));  // 9
        System.out.println(getKthUglyNumber(1500));  // 859963392
    }
}

```




## 面试题35 第一个只出现一次的字符

> **题目：*
>
>  在字符串中找出第一个只出现一次的字符。
>  如输入"abaccdeff"，则输出'b'。

```
package algorithm.foroffer.top40;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by liyazhou on 2017/5/30.
 * 面试题35：第一个只出现一次的字符
 *
 * 题目：
 *      在字符串中找出第一个只出现一次的字符。
 *      如输入"abaccdeff"，则输出'b'。
 *
 * 考查点：
 *      1. 哈希表
 *
 * 思路：
 *      1. 使用哈希表统计每一个字符出现的次数
 *      2. 遍历哈希表，找出第一个出现次数为 1 的字符（不能使用排序）
 */
public class Test35 {

    public static Character firstDistinctChar(char[] chars){
        if (chars == null) return null;
        
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();
        for (char ch : chars){
            if (characterIntegerMap.containsKey(ch)) characterIntegerMap.put(ch, characterIntegerMap.get(ch)+1);
            else                                     characterIntegerMap.put(ch, 1);
        }
        Character result = null;
        for (Entry<Character, Integer> entry : characterIntegerMap.entrySet()){
            // System.out.println(entry.getKey() + " :: " + entry.getValue());
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }


    public static void main(String[] args){
        String[] strs = {
                "baaccdeff",
                "abaccdedbfe",
        };
        for (String str : strs)
            System.out.println(str + ":\t" + firstDistinctChar(str.toCharArray()));
    }
}

```


----------


更好的解决方案
```
public int firstNotRepeatingChar(String str) {
    int[] chars = new int[128];  // 题设字符串是由字母组成的前提下，使用数组作为map
    for(int i = 0; i < str.length(); i ++){
        chars[str.charAt(i)] += 1;
    }

    for(int i = 0; i < str.length(); i ++){
        if (chars[str.charAt(i)] == 1)
            return i;
    }
    return -1;
}
```





## 面试题36 数组中的逆数对

> **题目：**
>
>在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组，求出这个数组中的逆序对。
例如在数组 {7, 5, 6, 4} 中，一共存在 5 个逆序对，
分别是 (7, 6)、(7, 5)、(7, 4)、(6, 4)和(5, 4)。

```
package algorithm.foroffer.top40;

import org.junit.Test;

/**
 * Created by liyazhou on 2017/5/30.
 * 面试题36：数组中的逆数对
 *
 * 题目：
 *      在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *      输入一个数组，求出这个数组中的逆序对。
 *      例如在数组 {7, 5, 6, 4} 中，一共存在 5 个逆序对，
 *      分别是 (7, 6)、(7, 5)、(7, 4)、(6, 4)和(5, 4)。
 *
 * 考查点：
 *      1. 发现规律
 *
 * 思路：
 *      1. 蛮力解法，时间复杂度是 O(n^2)
 *
 */
public class Test36 {


    public int inversePairs(int[] array){
        if (array == null) return -1;
        int counter = 0;
        for (int i = 0; i < array.length; i ++){
            for (int j = i + 1; j < array.length; j++){
                if (array[i] > array[j]) {
                    counter ++;
                    // System.out.println(array[i] + " :: " + array[j]);
                }
            }
        }
        return counter;
    }


    @Test
    public void test01(){
        int[] array = {7, 5, 6, 4};
        System.out.println(inversePairs(array));
    }

}

```





## 面试题37 两个链表的第一个公共结点

> **题目：**
> 输入两个链表，找出它们的第一个公共结点。
> 链表结点的定义如 ListNode.
>
><pre> 
>1 --> 2 --> 3 \
>                6 --> 7 --> 8
>       4 --> 5 /
></pre>

```
package algorithm.foroffer.top40;

import org.junit.Test;

/**
 * Created by liyazhou on 2017/5/31.
 * 面试题37：两个链表的第一个公共结点
 *
 * 题目：
 *      输入两个链表，找出它们的第一个公共结点。
 *      链表结点的定义如 ListNode.
 *      1 --> 2 --> 3 \
 *                      6 --> 7 --> 8
 *            4 --> 5 /
 *
 * 考查点：
 *      1. 栈的使用
 *      2. trick，链表的bias（偏置），“对齐”两个链表
 *      注：本题目跟取链表的后k个结点有异曲同工之妙
 *
 * 思路：
 *      1. 计算链表的长度
 *      2. 右“对齐”两个链表
 *      3. 对齐后，遍历并比较对应结点是否相同
 *
 */

class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){ this.value = value; }
}

public class Test37 {

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) return null;

        int lenOfList1 = 0, lenOfList2 = 0;
        for (ListNode currNode = head1; currNode != null; currNode = currNode.next, lenOfList1 ++);
        for (ListNode currNode = head2; currNode != null; currNode = currNode.next, lenOfList2 ++);

        int bias = lenOfList1 - lenOfList2;
        if (bias > 0){
            for (int i = 0; i < bias; i++) head1 = head1.next;
        }else{
            for (int i = 0; i < -bias; i++) head2 = head2.next;
        }

        for (; head1 != null && head2 !=null && head1 != head2; head1 = head1.next, head2 = head2.next);
        return head1;
    }

    @Test
    public void test(){
        ListNode[] heads = getBothLists();
        ListNode head1 = heads[0];
        ListNode head2 = heads[1];
        ListNode firstCommonNode = findFirstCommonNode(head1, head2);
        System.out.println(firstCommonNode.value);
    }


    public ListNode[] getBothLists(){
        // different part of list1
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        // different part of list2
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        // common part
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;

        node4.next = node5;
        node5.next = node6;

        node6.next = node7;

        return new ListNode[]{node0, node4};

    }
}

```

重构代码，更清晰的程序

```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		int len1 = lenOfList(pHead1);
        int len2 = lenOfList(pHead2);
       
        int diff = len1 - len2;
        ListNode commonNode = null;
        if (diff > 0) pHead1 = moveN(pHead1, diff);
        else		  pHead2 = moveN(pHead2, -diff);
        
        for (; pHead1!=null; pHead1=pHead1.next, pHead2=pHead2.next){
            if (pHead1 == pHead2){
                commonNode = pHead1;
                break;
            }
        }
        
        return commonNode;
        
    }
    
    private ListNode moveN(ListNode head, int n){
        for (; n > 0; n --){
            head = head.next;
        }
        return head;
    }
    
    private int lenOfList(ListNode head){
        int len = 0;
        for (; head != null; head = head.next)
            len ++;
        return len;
    }
}
```





## 面试题38 数字在排序数组中出现的次数

> **题目：**
>统计一个数字在排序数组中出现的次数。例如输入排序数组 {1,2,3,3,3,3,4,5} 和数字 3，
由于 3 在这个数组中出现了 4 次，因此输出 4。


```
package algorithm.foroffer.top40;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-05-31 17:29
 *
 * 面试题：数字在排序数组中出现的次数
 *
 * 题目：
 *      统计一个数字在排序数组中出现的次数。例如输入排序数组 {1,2,3,3,3,3,4,5} 和数字 3，
 *      由于 3 在这个数组中出现了 4 次，因此输出 4。
 *
 * 考查点：
 *      1. 二叉查找
 *
 * 思路：
 *      1. 反复二叉查找，确定这个数字的边界
 *
 */
public class Test38 {

    public int countNumOfK(int[] array, int k){
        if (array == null) return -1;

        int firstIdx = idxOfFirstK(array, k);
        int lastIdx = idxOfLastK(array, k);
        int number = 0;
        if (firstIdx != -1) number = lastIdx - firstIdx + 1;
        return number;
    }

    private int idxOfFirstK(int[] array, int k){
        int first = 0;
        int last = array.length-1;
        while(first <= last){ // 等号
            int mid = (first + last) / 2;
            // System.out.printf("first, last, mid = %d, %d, %d \n", first, last, mid);
            // 与标准二分查找不同的退出条件
            if (array[mid] == k && (mid-1 >= 0 && array[mid-1] != k || mid == 0)) return mid;
            if (array[mid] < k) first = mid + 1;
            else if (array[mid] == k) last = mid; // 如果二分后的元素与查找元素相等，则移动右边界last
            else if (array[mid] > k) last = mid - 1;
        }
        return -1;
    }

    private int idxOfLastK(int[] array, int k){
        int first = 0;
        int last = array.length - 1;
        while (first <= last){
            int mid = (first + last) / 2;
            // System.out.printf("first, last, mid = %d, %d, %d \n", first, last, mid);
            if (array[mid] == k && (mid+1 < array.length && array[mid+1] != k || mid == array.length-1)) return mid;
            if (array[mid] < k) first = mid + 1;
            else if (array[mid] == k) first = mid;
            else if (array[mid] > k) last = mid - 1;
        }
        return -1;
    }


    @Test
    public void test(){
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        // int[] array = {1, 2, 3, 4, 5};
        int k = 1;
        int firstIdx = idxOfFirstK(array, k);
        int lastIdx = idxOfLastK(array, k);
        System.out.printf("firstIdx, lastIdx = %d, %d", firstIdx, lastIdx);
    }

    @Test
    public void test02(){
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        for (int k = 1; k < 6; k++){
            int numOfK = countNumOfK(array, k);
            System.out.println(Arrays.toString(array));
            System.out.printf("%d: %d\n\n", k, numOfK);
        }
    }
}

```


----------

另一种稍微低效的解法：
先二分查出该元素的位置，然后向前后两边扫描，确定边界。根据边界计算出该数字出现的次数。

```
 public int GetNumberOfK(int [] array , int k) {
     int pos = posOfK(array, k);
     if (pos == -1) return 0;
     int i = pos-1;
     int j = pos+1;
     for (; i >= 0 && array[i] == k; i --);
     for (; j < array.length && array[j] == k; j ++);
     return j - i - 1;
    
 }
 
 private int posOfK(int[] array, int k){
     int low = 0;
     int high = array.length - 1;
     while (low <= high){
         int mid = (low + high) / 2;
         if (array[mid] > k) high = mid - 1;
         else if (array[mid] < k) low = mid + 1;
         else return mid;
     }
     return -1;
 }
```






## 面试题39 二叉树的深度

>题目一：
     输入一棵二叉树的根结点。求该树的深度。从根结点到叶结点依次经过的结点
     （含根、叶结点）形成的树的一条路径，最长路径的长度为树的深度。
题目二：
     输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
     如果某二叉树中的任意结点的左右子树的深度相差不超过 1， 那么它就是一棵平衡二叉树。
     例如，下图中的二叉树就是一棵平衡二叉树。<pre>
                     1
                   /   \
                 2      3
               /  \      \
             4     5      6
                  /
                 7
</pre>


```
package algorithm.foroffer.top40;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-05-31 21:40
 *
 * 面试题39：二叉树的深度
 *
 * 题目一：
 *      输入一棵二叉树的根结点。求该树的深度。从根结点到叶结点依次经过的结点
 *      （含根、叶结点）形成的树的一条路径，最长路径的长度为树的深度。
 *
 * 题目二：
 *      输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 *      如果某二叉树中的任意结点的左右子树的深度相差不超过 1， 那么它就是一棵平衡二叉树。
 *      例如，下图中的二叉树就是一棵平衡二叉树。
 *                      1
 *                    /   \
 *                  2      3
 *                /  \      \
 *              4     5      6
 *                   /
 *                  7
 *
 * 考查点：
 *      1. 二叉树的遍历
 *
 * 思路：
 *      1. 从叶子节点递归到根结点，求出一条路径的长度
 */

class BinTreeNode{
    int         value;
    BinTreeNode left;
    BinTreeNode right;

    public BinTreeNode(int value){ this.value = value; }
    public void setChildren(BinTreeNode _left, BinTreeNode _right){
        left = _left;
        right = _right;
    }
}

public class Test39 {

    /**
     * 计算二叉树的深度
     * @param root 二叉树的根结点
     * @return 二叉树的深度
     */
    public int treeDepth(BinTreeNode root){
        if (root == null) return 0;

        int leftDepth = treeDepth(root.left) + 1;
        int rightDepth = treeDepth(root.right) + 1;

        int depth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return depth;
    }


    /**
     * 判断一个二叉树是否是平衡二叉树
     * @param root 二叉树的根结点
     * @return 是，返回 true，否则，返回 false
     */
    public boolean isBalancedBinTree(BinTreeNode root){
        // 递归终止条件一，遍历到叶子结点
        if (root == null) return true;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        int diff = leftDepth - rightDepth;
        // 递归终止条件二，存在结点的左右子树的深度相差超过 1
        if (diff > 1 || diff < -1) return false;
        return isBalancedBinTree(root.left) && isBalancedBinTree(root.right);
        // return !((diff > 1 || diff < -1)) && isBalancedBinTree(root.left) && isBalancedBinTree(root.right);
    }


    /**
     * 判断一个二叉树是否是平衡二叉树
     * @param root 二叉树的根结点
     * @return 是，返回 true，否则，返回 false
     */
    public boolean isBalancedBinTree2(BinTreeNode root){
        int[] depth = {0};
        return isBalancedBinTree(root, depth);
    }


    private boolean isBalancedBinTree(BinTreeNode root, int[] depth){
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] leftDepth = {0};
        int[] rightDepth = {0};
        if (isBalancedBinTree(root.left, leftDepth) && isBalancedBinTree(root.right, rightDepth)){
            int diff = leftDepth[0] - rightDepth[0];
            if (diff >= -1 && diff <= 1){
                depth[0] = 1 + (leftDepth[0] > rightDepth[0] ? leftDepth[0] : rightDepth[0]);
                return true;
            }
        }
        return false;
    }

    /**
     * 测试二叉树的深度
     *                1
     *              /   \
     *            2      3
     *          /  \      \
     *        4     5      6
     *             /
     *            7
     */
    @Test
    public void test1(){
        BinTreeNode node1 = new BinTreeNode(1);
        BinTreeNode node2 = new BinTreeNode(2);
        BinTreeNode node3 = new BinTreeNode(3);
        BinTreeNode node4 = new BinTreeNode(4);
        BinTreeNode node5 = new BinTreeNode(5);
        BinTreeNode node6 = new BinTreeNode(6);
        BinTreeNode node7 = new BinTreeNode(7);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, node5);
        node3.setChildren(null, node6);
        node5.setChildren(node7, null);
        int depth = treeDepth(node1);
        System.out.printf("depth = %d", depth);
    }

    /**
     * 测试二叉树的深度
     *                  1
     *                 /
     *                2
     *               /
     *              3
     *             /
     *            4
     *           /
     *          5
     */
    @Test
    public void test2(){
        BinTreeNode node1 = new BinTreeNode(1);
        BinTreeNode node2 = new BinTreeNode(2);
        BinTreeNode node3 = new BinTreeNode(3);
        BinTreeNode node4 = new BinTreeNode(4);
        BinTreeNode node5 = new BinTreeNode(5);

        node1.setChildren(node2, null);
        node2.setChildren(node3, null);
        node3.setChildren(node4, null);
        node4.setChildren(node5, null);
        int depth = treeDepth(node1);
        System.out.printf("depth = %d", depth);
    }


    /**
     * 测试二叉树的深度
     *         1
     *          \
     *           2
     *            \
     *             3
     *              \
     *               4
     *                \
     *                 5
     */
    @Test
    public void test3(){
        BinTreeNode node1 = new BinTreeNode(1);
        BinTreeNode node2 = new BinTreeNode(2);
        BinTreeNode node3 = new BinTreeNode(3);
        BinTreeNode node4 = new BinTreeNode(4);
        BinTreeNode node5 = new BinTreeNode(5);

        node1.setChildren(null, node2);
        node2.setChildren(null, node3);
        node3.setChildren(null, node4);
        node4.setChildren(null, node5);
        int depth = treeDepth(node1);
        System.out.printf("depth = %d", depth);
    }

    /**
     * 测试是否是平衡二叉树
     *              1
     *            /   \
     *          2      3
     *        /  \      \
     *      4     5      6
     *           /
     *          7
     */
    @Test
    public void test11(){
        BinTreeNode node1 = new BinTreeNode(1);
        BinTreeNode node2 = new BinTreeNode(2);
        BinTreeNode node3 = new BinTreeNode(3);
        BinTreeNode node4 = new BinTreeNode(4);
        BinTreeNode node5 = new BinTreeNode(5);
        BinTreeNode node6 = new BinTreeNode(6);
        BinTreeNode node7 = new BinTreeNode(7);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, node5);
        node3.setChildren(null, node6);
        node5.setChildren(node7, null);

        System.out.println(isBalancedBinTree(node1));
        System.out.println(isBalancedBinTree2(node1));
    }

    /**
     * 测试二叉树的深度
     *                  1
     *                 /
     *                2
     *               /
     *              3
     *             /
     *            4
     *           /
     *          5
     */
    @Test
    public void test12(){
        BinTreeNode node1 = new BinTreeNode(1);
        BinTreeNode node2 = new BinTreeNode(2);
        BinTreeNode node3 = new BinTreeNode(3);
        BinTreeNode node4 = new BinTreeNode(4);
        BinTreeNode node5 = new BinTreeNode(5);

        node1.setChildren(node2, null);
        node2.setChildren(node3, null);
        node3.setChildren(node4, null);
        node4.setChildren(node5, null);
        System.out.println(isBalancedBinTree(node1));
        System.out.println(isBalancedBinTree2(node1));
    }

}

```






## 面试题40 数组中只出现一次的数字

> **题目：**
>一个整型数组里除了两个数字之外，其他的数字都出现了两次。
请写程序找出两个只出现了一次的数字。要求时间复杂度是 O(n)，空间复杂度是 O(1)


```
package algorithm.foroffer.top40;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-01 15:12
 *
 * 面试题40：数组中只出现一次的数字
 *
 * 题目：
 *      一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *      请写程序找出两个只出现了一次的数字。要求时间复杂度是 O(n)，空间复杂度是 O(1)
 *
 * 考查点：
 *      1. 二进制与位运算
 *          第一，任何一个数字异或它自己都等于 0；
 *          第二，任何一个数字异或 0 都等于它自己。
 *
 * 思路：
 *      1. 如果一个数组中只有一个数字仅仅出现一次，其他数字都出现2次（或偶数次），
 *         则将该数组中所有的元素进行异或运算，则结果就是只出现一次的数字
 *      2. 根据 1，想办法将含有两个只出现一次的数字划分到两个数组中，之后可以按 1 分别计算出结果
 *      3. 将原始数组中的所有元素进行异或运算，由于有两个只出现一次的数字，则结果肯定是非0的数字，
 *         将异或结果转化为二进制，找到后边的第一个 1，记录其索引
 *         如果原始数组中的元素的二进制在该索引出是1，则将其划分到一个数组中，否则被划分到另一数组中。
 *         （注：我们的目的是将只出现一次的两个数字分别划分到两个数组中，而出现两次的数字同时被分配到哪一个数组是无关紧要的）
 *
 */
public class Test40 {

    public int[] findTwoNumOfApperanceOnce(int[] array){
        int[] result = {0, 0};

        if (array == null || array.length < 2) return result;

        int xor = 0;
        for (int emt : array) xor ^= emt;

        // int indexOfOne = findFirstBit1(xor);
        String xorStr = Integer.toBinaryString(xor);
        // 从右面开始计数，0 是第一个数字
        int indexOfOne = xorStr.length() - xorStr.lastIndexOf("1") - 1;
        for (int emt : array){
            // 如果这个数字的倒数第indexOfOne+1个数字是1则，划分到一个数组中，否则划分到另外一个数组中
            // 出现两次的数字同时被分配到哪一个数组是无关紧要的，
            // 我们的目的是将只出现一次的两个数字分别划分到两个数组中
            if (((emt >>> indexOfOne) & 1) == 1) result[0] ^= emt;
            else                                 result[1] ^= emt;
        }

        return result;
    }

    private int findFirstBit1(int num){
        int idx;
        for (idx = 0; (num & 1) == 0 && idx < 32; num >>>= 1, idx ++);
        return idx;
    }

    @Test
    public void test(){
        int[][] arrays = {
                {2, 4, 3, 6, 3, 2, 5, 5},
                {2, 4},
        };
        for (int[] array : arrays){
            int [] result = findTwoNumOfApperanceOnce(array);
            System.out.println(Arrays.toString(result));
        }
    }
}

```


>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>
