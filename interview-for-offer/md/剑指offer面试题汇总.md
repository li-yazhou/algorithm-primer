## 剑指offer合辑之面试01-67

>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>



## 目录

+ [面试题2 实现单例模式](#面试题2-实现单例模式)
+ [面试题3 二维数组中的查找](#面试题3-二维数组中的查找)
+ [面试题4 替换空格](#面试题4-替换空格)
+ [面试题5 从尾到头打印链表](#面试题5-从尾到头打印链表)
+ [面试题6 重建二叉树](#面试题6-重建二叉树)
+ [面试题7 用两个栈实现队列](#面试题7-用两个栈实现队列)
+ [面试题8 旋转数组的最小数字](#面试题8-旋转数组的最小数字)
+ [面试题9 斐波那契数列/青蛙跳台阶/矩形覆盖/变态跳台阶](#面试题9-斐波那契数列/青蛙跳台阶/矩形覆盖/变态跳台阶)
+ [面试题10 二进制中 1 的个数](#面试题10-二进制中-1-的个数)
+ [面试题11 数值的整数次方](#面试题11-数值的整数次方)
+ [面试题12 打印 1 到最大的 n 位整数](#面试题12-打印1到最大的n位整数)
+ [面试题13 在o(1)时间删除链表结点](#面试题13-在o(1)时间删除链表结点)
+ [面试题14 调整数组顺序使奇数位于偶数前面](#面试题14-调整数组顺序使奇数位于偶数前面)
+ [面试题15 链表中倒数第 k 个结点](#面试题15-链表中倒数第k个结点)
+ [面试题16 反转链表](#面试题16-反转链表)
+ [面试题17 合并两个排序的链表](#面试题17-合并两个排序的链表)
+ [面试题18 树的子结构](#面试题18-树的子结构)
+ [面试题19 二叉树的镜像](#面试题19-二叉树的镜像)
+ [面试题20 顺时针打印矩阵](#面试题20-顺时针打印矩阵)
+ [面试题21 包含 min 函数的栈](#面试题21-包含min函数的栈)
+ [面试题22 栈的压入、弹出序列](#面试题22-栈的压入、弹出序列)
+ [面试题23 从上到下打印二叉树](#面试题23-从上到下打印二叉树)
+ [面试题24 二叉搜索树的后序遍历序列](#面试题24-二叉搜索树的后序遍历序列)
+ [面试题25 二叉树中和为某一值的路径](#面试题25-二叉树中和为某一值的路径)
+ [面试题26 复杂链表的复制](#面试题26-复杂链表的复制)
+ [面试题27 二叉搜索树与双向链表](#面试题27-二叉搜索树与双向链表)
+ [面试题28 字符串的排列](#面试题28-字符串的排列)
+ [面试题29 数组中出现次数超过一半的数字](#面试题29-数组中出现次数超过一半的数字)
+ [面试题30 最小的 k 个数](#面试题30-最小的k个数)
+ [面试题31 连续子数组的最大和](#面试题31-连续子数组的最大和)
+ [面试题32 从 1 到 n 整数中 1 出现的次数](#面试题32-从1到n整数中1出现的次数)
+ [面试题33 把数组排成最小的数](#面试题33-把数组排成最小的数)
+ [面试题34 丑数](#面试题34-丑数)
+ [面试题35 第一个只出现一次的字符](#面试题35-第一个只出现一次的字符)
+ [面试题36 数组中的逆数对](#面试题36-数组中的逆数对)
+ [面试题37 两个链表的第一个公共结点](#面试题37-两个链表的第一个公共结点)
+ [面试题38 数字在排序数组中出现的次数](#面试题38-数字在排序数组中出现的次数)
+ [面试题39 二叉树的深度](#面试题39-二叉树的深度)
+ [面试题40 数组中只出现一次的数字](#面试题40-数组中只出现一次的数字)
+ [面试题41 和为 s 的两个数字 VS 和为 s 的连续正数序列](#面试题41-和为-s-的两个数字-VS-和为-s-的连续正数序列)
+ [面试题42 翻转单词顺序 VS 左旋转字符串](#面试题42-翻转单词顺序-VS-左旋转字符串)
+ [面试题44 扑克牌的顺子](#面试题44-扑克牌的顺子)
+ [面试题45 圆圈中最后剩下的数字](#面试题45-圆圈中最后剩下的数字)
+ [面试题46 求 1+2+3+...+n（不使用乘除以及条件判断语句求前 n 项正整数的和）](#面试题46-求-1+2+3+...+n（不使用乘除以及条件判断语句求前-n-项正整数的和）)
+ [面试题47 不用加减乘除做加法](#面试题47-不用加减乘除做加法)
+ [面试题48 不能被继承的类](#面试题48-不能被继承的类)
+ [面试题49 把字符串转换成整数](#面试题49-把字符串转换成整数)
+ [面试题50 树中两个结点的最低公共祖先](#面试题50-树中两个结点的最低公共祖先)
+ [面试题51 数组中重复的数字](#面试题51-数组中重复的数字)
+ [面试题52 构建乘积数组](#面试题52-构建乘积数组)
+ [面试题55 字符流中第一个不重复的字符](#面试题55-字符流中第一个不重复的字符)
+ [面试题56 链表中环的入口结点](#面试题56-链表中环的入口结点)
+ [面试题57 删除链表中重复的结点](#面试题57-删除链表中重复的结点)
+ [面试题58 二叉树的下一个结点](#面试题58-二叉树的下一个结点)
+ [面试题59 对称的二叉树](#面试题59-对称的二叉树)
+ [面试题60 把二叉树打印成多行](#面试题60-把二叉树打印成多行)
+ [面试题61 按之字形顺序打印二叉树](#面试题61-按之字形顺序打印二叉树)
+ [面试题62 序列化和反序列化二叉树](#面试题62-序列化和反序列化二叉树)
+ [面试题63 二叉搜索树的第 k 个结点](#面试题63-二叉搜索树的第-k-个结点)
+ [面试题64 数据流中的中位数](#面试题64-数据流中的中位数)
+ [面试题65 滑动窗口的最大值](#面试题65-滑动窗口的最大值)




面试题2 实现单例模式
=================

> 实现 Singleton 模式

```
package algorithm.foroffer;

/**
 * 单例模式：恶汉式，线程安全
 * 步骤：
 *      1. 创建并初始化 private static 变量
 *      2. 私有化构造方法
 *      3. 创建返回单例对象的 public static getInstance 方法
 */
class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){   }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }

    public static void test(){
        Singleton1 test01 = Singleton1.getInstance();
        Singleton1 test02 = Singleton1.getInstance();
        boolean isEquals = test01.equals(test02);
        String info = String.format("%s equals %s, %b", test01, test02, isEquals);
        System.out.println(info);
    }
}

/**
 * 单例模式：懒汉式，线程不安全
 * 步骤：
 *     1. 创建 private static 变量
 *     2. 私有化构造方法
 *     3. 创建返回单例对象的 public static getInstance 方法，如果单例为 null，则创建该对象，之后返回该单例
 */
class Singleton2{
    private static Singleton2 INSTANCE;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if (INSTANCE == null) INSTANCE = new Singleton2();
        return INSTANCE;
    }

    public static void test(){
        Singleton2 instance01 = Singleton2.getInstance();
        Singleton2 instance02 = Singleton2.getInstance();
        boolean isEquals = instance01.equals(instance02);
        String info = String.format("%s equals %s, %b", instance01, instance02, isEquals);
        System.out.println(info);
    }
}


/**
 * 单例模式：静态代码块懒汉式，线程安全
 */
class Singleton3 {
    private static Singleton3  INSTANCE;

    static{
        INSTANCE = new Singleton3 ();
    }

    private Singleton3 (){}

    public static Singleton3  getInstance(){
        return INSTANCE;
    }

    public static void test(){
        Singleton3  instance1 = Singleton3 .getInstance();
        Singleton3  instance2 = Singleton3 .getInstance();
        boolean isEquals = instance1.equals(instance2);
        String info = String.format("%s equals %s, %b", instance1, instance2, isEquals);
        System.out.println(info);
    }
}

/**
 * 单例模式：静态内部类，线程安全【推荐，why】
 */
class Singleton4 {
    // todo, what are its advantages
    private final static class SingletonHolder {
        private final static Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4(){}

    public static Singleton4 getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void test(){
        Singleton4 instance1 = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        boolean isEquals = instance1.equals(instance2);
        String info = String.format("%s equals %s, %b", instance1, instance2, isEquals);
        System.out.println(info);
    }
}


/**
 * 单例模式：synchronized懒汉式，线程安全，多线程环境下效率不高
 */
class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5 (){}

    public static synchronized Singleton5  getInstance(){
        if (INSTANCE == null) INSTANCE = new Singleton5();
        return INSTANCE;
    }

    public static void test(){
        Singleton5 instance1 = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        boolean isEquals = instance1.equals(instance2);
        String info = String.format("%s equals %s, %b", instance1, instance2, isEquals);
        System.out.println(info);
    }
}

/**
 * 单例模式：(双重校验锁)双重空校验 + 中间的synchronized代码块，线程安全【推荐】
 */
class Singleton6{
    // todo, volatile 关键字
    private volatile static Singleton6 INSTANCE;

    private Singleton6(){}

    public static Singleton6 getInstance(){
        if (INSTANCE == null){
            synchronized(Singleton6.class){
                if (INSTANCE == null) INSTANCE = new Singleton6();
            }
        }
        return INSTANCE;
    }

    public static void test(){
        Singleton6 instance1 = Singleton6.getInstance();
        Singleton6 instance2 = Singleton6.getInstance();
        boolean isEquals = instance1.equals(instance2);
        String info = String.format("%s equals %s, %b", instance1, instance2, isEquals);
        System.out.println(info);
    }
}


/**
 * 单例模式：单个实例的枚举，线程安全【推荐】
 */
enum Singleton7{
    //    INSTANCE("singleton instance");
    //    private String name;
    //    Singleton7(String name){this.name = name; }
    INSTANCE;

    public static void test(){
        Singleton7 instance1 = Singleton7.INSTANCE;
        Singleton7 instance2 = Singleton7.INSTANCE;
        boolean isEquals = instance1.equals(instance2);
        String info = String.format("%s equals %s, %b", instance1, instance2, isEquals);
        System.out.println(info);
    }
}

/**
 * Created by liyazhou on 2017/5/22.
 * 面试题2：实现Singleton模式
 */
public class Test02 {
    public static void main(String[] args){
        Singleton1.test();
        Singleton2.test();
        Singleton3.test();
        Singleton4.test();
        Singleton5.test();
        Singleton6.test();
        Singleton7.test();
    }
}
```


[回到目录](#目录)



面试题3 二维数组中的查找
===================

> 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
> 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

```

/**
 * Created by liyazhou on 2017/5/22.
 */
public class Test3 {

    public static boolean contains(int[][] matrix, int number){
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == number) {
                    System.out.println(String.format("i, j = %d, %d", i, j));
                    return true;
                }
        return false;
    }

    public static boolean contains2(int[][] matrix, int number){
        boolean contains = false;
        int col = matrix[0].length-1;
        int row = 0; // 右上角元素的
        if (number < matrix[0][0] || number > matrix[matrix[0].length-1][matrix.length-1]) return false;  // 判断边界
        while(row < matrix.length && col >= 0){
            int topRightVal = matrix[row][col];
            if (number == topRightVal) {
                contains = true; break;
            }
            else if (number < topRightVal) {  // 删除当前元素所在列
                --col;
            }else{ // number > topRightVal，删除当前元素所在行
                ++row;
            }
        }
        System.out.println(String.format("row, col = %d, %d", row, col));
        return contains;
    }

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p/>
     * 规律：
     *  首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束。
     *  如果该数字大于要查找的数字，剔除这个数字所在的列；
     *  如果该数字小于要查找的数字，剔除这个数字所在的行。
     *  也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除行或者列，
     *  这样每一步都可以缩小查找范围，直到要查找的数字，或者查找范围为空。
     * @param matrix 二维数组
     * @param number 待查找的数字
     * @return 在数组中是否找到该数字
     */
    public static boolean contains3(int[][] matrix, int number){
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;  // 判断数组
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (number < matrix[0][0] || number > matrix[rows-1][cols-1]) return false;  // 判断边界

        boolean found = false;
        int row = 0;
        int col = cols-1;  // todo, 注意边界
        while(row < rows && col >=0){
            int topRightVal = matrix[row][col];  // 获取到查找范围内的右上角的元素
            if (number == topRightVal){
                found = true; break;  // 找到该数字，停止查询
            }
            else if (number < topRightVal) --col;  // 删除当前列， 第 col 列
            else ++row;  // number > topRightVal， 删除当前行，第 row 行
        }
        System.out.println(String.format("row, col = %d, %d", row, col));
        return found;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1 ,2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int[] numbers = {-1, 1, 15, 7};
        for (int number : numbers){
            System.out.println(String.format("contains  %d, %b", number, Test3.contains(matrix, number)));
            System.out.println(String.format("contains2 %d, %b", number, Test3.contains2(matrix, number)));
            System.out.println(String.format("contains3 %d, %b", number, Test3.contains3(matrix, number)));
        }
    }
}

```

[回到目录](#目录)


面试题4 替换空格
==============

> **题目：**
>
> 请实现一个函数，把字符串中的每个空格替换成 "%20"。
> 例如输入 "We are happy."，则输出"We%20are%20happy."。

```
package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/23.
 * 面试题4: 替换空格
 * 题目： 请实现一个函数，把字符串中的每个空格替换成 "%20"。
 *       例如输入 "We are happy."，则输出"We%20are%20happy."。
 */
public class Test04 {

    public static String replaceSpace(String line, String oldStr, String newStr){
        line = line.replace(oldStr, newStr);
        return line;
    }

    public static String replaceSpace2(String line, String oldStr, String newStr){
         String[] strs = line.split(oldStr);
         return String.join(newStr, strs);
    }

    /**
     * 思路：
     *      1. 统计空格的个数，计算转换后的字符数组的长度，判断其是否小于字符数组的容量 capacity，如果为假，返回 -1
     *      2. 从后往前取出原始字符数组中的字符，直到没有空格
     *          如果是' '，则执行替换操作
     *          如果不是' '， 则复制该字符
     * @param chars 需要转换的字符数组
     * @param usedLength 字符数组中元素的个数
     * @return 转换后的字符数据中元素的个数，-1表示转换失败
     */
    public static int replaceSpace3(char[] chars, int usedLength){
        // 判断输入是否合法
        if(chars == null || usedLength < 1) return -1;

        // 统计字符数组中空格字符的个数
        int spaceCnt = 0;
        for(int i = 0; i < usedLength; i++)
            if (chars[i] == ' ')  ++spaceCnt;

        // 计算新字符数组所需要的长度
        int newUsedLength = 2 * spaceCnt + usedLength;   // int increment = 2 * spaceCnt;
        if (chars.length < newUsedLength) return -1;  // 字符数组长度太小，转换失败

        int indexOfOriginal = usedLength - 1;  // 指向未移动的字符串的末尾，也即是指向待移动的字符
        int indexOfNew = newUsedLength - 1;   // 指向移动后的字符串的开头
        // 从后往前移动字符数组的元素
        // while (indexOfOriginal >= 0 && indexOfOriginal < indexOfNew){  // 当还存在空格时，继续移动字符
        while (spaceCnt > 0){  // 当还存在空格时，继续移动字符
            if (chars[indexOfOriginal] == ' '){  // 判断当前字符是为' '，为真则替换' '
                spaceCnt--;
                chars[indexOfNew--] = '0';
                chars[indexOfNew--] = '2';
                chars[indexOfNew--] = '%';
            }else{  // 保存在字符
                chars[indexOfNew--] = chars[indexOfOriginal];
            }
            indexOfOriginal--;  // 字符数组的指针向前移动一位
        }
        return newUsedLength;
    }

    public static void main(String[] args){
        String line = "We are  happy .";

        String line1= Test04.replaceSpace(line, " ", "%20");
        System.out.println(line1);

        String line2 = Test04.replaceSpace2(line, " ", "%20");
        System.out.println(line2);

        char[] chars = new char[50];
        char[] string = line.toCharArray();
        for (int i = 0; i < string.length; i++)
            chars[i] = string[i];
        int length = Test04.replaceSpace3(chars, string.length);
        System.out.println(new String(chars, 0, length));
    }
}

```

[回到目录](#目录)




面试题5 从尾到头打印链表
===================

>  **题目：**
>
> 输入一个链表的头结点，从尾到头反过来打印出每个结点的值（不能改变链表的结构，仅仅对链表进行只读操作）

```
package algorithm.foroffer;

import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/23.
 * 面试题5：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值（不能改变链表的结构，仅仅对链表进行只读操作）
 * 思路：
 *     1.使用栈
 *     2.递归，隐性的栈
 */

class Node{
    private int value;
    private Node nextNode;

    public Node(){}
    public Node(int value){ this.value = value; }
    public Node(int value, Node nextNode){
        this.value = value;
        this.nextNode = nextNode;
    }

    public int getValue(){ return this.value; }
    public Node nextNode(){ return this.nextNode; }
    public void setNextNode(Node node){ this.nextNode = node; }
}

public class Test05 {

    /**
     * 方法一：使用栈
     * 思路：
     *      首先，遍历链表，将链表中的元素存入到栈中
     *      然后，访问栈中的元素
     * @param headNode 头结点
     */
    public static void printListReverselyUsingIteration(Node headNode){
        if (headNode == null) return;

        Stack<Node> stack = new Stack<>();
        while(headNode != null){
            stack.push(headNode);
            headNode = headNode.nextNode();
        }

        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            System.out.print(String.format("%s \t", currNode.getValue()));
        }
    }


    /**
     * 方法二：递归，递归的本质就是栈结构，代码更加简洁
     * 思路：
     *      每访问到一个结点的时候，先递归输出它后面的结点，在输出该结点自身。
     * @param headNode 头结点
     */
    public static void printListReverselyUsingRecursion(Node headNode){
        if (headNode.nextNode() != null){
            printListReverselyUsingRecursion(headNode.nextNode());
        }
        System.out.print(String.format("%s \t", headNode.getValue()));

    }

    public static void main(String[] args){
        Node nextNode = new Node(1);
        Node headNode = new Node(0, nextNode);
        for(int i = 2; i < 10; i++){
            Node node = new Node(i);
            nextNode.setNextNode(node);
            nextNode = node;
        }

        Test05.printListReverselyUsingIteration(headNode);
        System.out.println();
        Test05.printListReverselyUsingRecursion(headNode);

    }
}

```

[回到目录](#目录)




面试题6 重建二叉树
===============

> **题目：**
>
> 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
> 假设输入的前序遍历和中序遍历的结果都不含重复的数字。例如，
> 输入前序遍历序列 {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
> 则重建出二叉树并输出它的头结点。



```
package algorithm.foroffer;

import java.util.Arrays;

/**
 * Created by liyazhou on 2017/5/23.
 */

class BinaryTreeNode{
    private int value;  // id of BinaryTreeNode, unique
    private BinaryTreeNode leftChildNode;
    private BinaryTreeNode rightChildNode;

    public BinaryTreeNode(){}
    public BinaryTreeNode(int value){ this.value = value; }
    public BinaryTreeNode(int value, BinaryTreeNode leftChildNode, BinaryTreeNode rightChildNode){
        this.value = value;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public int getValue(){ return this.value; }
    public BinaryTreeNode getLeftChildNode(){ return this.leftChildNode; }
    public BinaryTreeNode getRightChildNode(){ return this.rightChildNode; }

    public void setValue(int value){ this.value = value; }
    public void setLeftChildNode(BinaryTreeNode leftChildNode){ this.leftChildNode = leftChildNode; }
    public void setRightChildNode(BinaryTreeNode rightChildNode){ this.rightChildNode = rightChildNode; }
}


public class Test06 {

    public BinaryTreeNode constructBinTree2(int[] preorder, int[] inorder){
        // 判断输入数据
        if(preorder == null || preorder.length == 0 ||
           inorder == null || inorder.length == 0)
            return null;
        return constructBinTree(preorder, 0, preorder.length, inorder, 0, preorder.length);
    }

    // todo, 确定边界是关键点
    private BinaryTreeNode constructBinTree(int[] preorder, int ps, int pe, 
						    int[] inorder, int is, int ie) {
        // 递归终止条件，当开始位置大于结束位置时，则没有要处理的数据
        if (ps >= pe || is >= ie) return null;

        // 从前序遍历序列中取出根结点
        int rootId = preorder[ps];
        BinaryTreeNode root = new BinaryTreeNode(rootId);

        // 根结点在中序遍历序列中的位置
        int idxOfRoot = -1;
        for (int i = is; i < ie; i++){
            if(inorder[i] == rootId){
                idxOfRoot = i;
                break;
            }
        }

        if (idxOfRoot == -1) {
            System.out.println(String.format("ps, pe = %d, %d, preorder = %s", ps, pe, Arrays.toString(preorder)));
            System.out.println(String.format("is, ie = %d, %d, inorder = %s", is, ie, Arrays.toString(inorder)));
            throw new RuntimeException("先序遍历序列和中序遍历序列不匹配.");
        }

        // 递归构建当前根结点的左子树，左子树的结点个数是 idxOfRoot-is
        // 先序遍历序列中，当前根结点的左子树的范围是 [ps+1, ps+(idxOfRoot-is)+1)，根据起始位置和偏移量计算范围
        // 中序遍历序列中，当前根结点的左子树的范围是 [is, idxOfRoot)
        BinaryTreeNode leftChildNode = constructBinTree(preorder, ps+1, ps+idxOfRoot-is+1, inorder, is, idxOfRoot);
        root.setLeftChildNode(leftChildNode);

        // 递归构建当前根结点的右子树，右子树的结点个数是 ie-idxOfRoot-1
        // 先序遍历序列中，当前结点的右子树的范围是 [pe-(ie-idxOfRoot-1), pe)，根据终止位置和偏移量计算范围
        // 中序遍历序列中，当前结点的右子树的范围是 [idxOfRoot+1, ie)
        BinaryTreeNode rightChildNode = constructBinTree(preorder, pe-ie+idxOfRoot+1 , pe, inorder, idxOfRoot+1, ie);
        root.setRightChildNode(rightChildNode);

        return root;
    }

    public void previsit(BinaryTreeNode root){
        if (root == null) return;
        System.out.print(String.format("%s \t", root.getValue()));
        previsit(root.getLeftChildNode());
        previsit(root.getRightChildNode());
    }

    public void invisit(BinaryTreeNode root){
        if (root == null) return;
        invisit(root.getLeftChildNode());
        System.out.print(String.format("%s \t", root.getValue()));
        invisit(root.getRightChildNode());
    }

    public void postvisit(BinaryTreeNode root){
        if (root == null) return;
        postvisit(root.getLeftChildNode());
        postvisit(root.getRightChildNode());
        System.out.print(String.format("%s \t", root.getValue()));
    }

    public void visit(BinaryTreeNode root){
        System.out.print("先序遍历结果：");
        previsit(root);
        System.out.println();
        System.out.print("中序遍历结果：");
        invisit(root);
        System.out.println();
        System.out.print("后序遍历结果：");
        postvisit(root);
        System.out.println("\n---------------------");
    }

    /**
     * 普通二叉树
     */
    public void test1(){
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = constructBinTree2(preorder, inorder);
        visit(root);
    }

    /**
     * 完全二叉树
     */
    public void test5(){
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = constructBinTree2(preorder, inorder);
        visit(root);
    }

    /**
     * 所有结点都没有右孩子
     */
    public void test2(){
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = constructBinTree2(preorder, inorder);
        visit(root);
    }

    /**
     * 所有结点都没有左孩子
     */
    public void test3(){
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = constructBinTree2(preorder, inorder);
        visit(root);
    }


    /**
     * 只有一个结点
     */
    public void test4(){
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = constructBinTree2(preorder, inorder);
        visit(root);
    }

    /**
     * 空指针
     */
    public void test6(){
        BinaryTreeNode root = constructBinTree2(null, null);
        visit(root);
    }

    /**
     * 前序遍历和中序遍历不匹配
     */
    public void test7(){
        int[] preorder = {1,3,2,4,7,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = constructBinTree2(preorder, inorder);
        visit(root);
    }


    public static void main(String[] args){
        Test06 test = new Test06();
        test.test1();
        test.test2();
        test.test3();
        test.test4();
        test.test5();
        test.test6();
        test.test7();
    }

}

```

[回到目录](#目录)




面试题7 用两个栈实现队列
====================

> **题目：** 
>
> 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
> 分别完成在队列尾部插入结点和在队列头部删除结点的功能。


----------
2017-9-3 15:22:06

```
/**
 * 面试题07 用两个栈实现队列
 */
private class MyQueue<T>{
    LinkedList<T> pushStack = new LinkedList<>();
    LinkedList<T> popStack = new LinkedList<>();

    public void offer(T ele){
        pushStack.push(ele);
    }

    public T poll(){
        T head = null;
        if (!popStack.isEmpty()) head = popStack.poll();
        else{
            while(!pushStack.isEmpty()) popStack.push(pushStack.pop());
            if (!popStack.isEmpty()) head = popStack.pop();
        }
        return head;
    }
}
```

----------


```
package algorithm.foroffer;

import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/24.
 * 面试题7：用两个栈实现队列
 * 题目：
 *      用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
 *      分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 *
 * 思路：
 *      1. 当在"队列"尾部插入结点时，把队列（子队列）的元素压入 A 栈
 *      2. 当删除"队列"的首部元素时，检查 B 栈是否为空，
 *              如果为空，将 A 栈中的元素弹出并依次压入B栈，此时 B 栈存储的就是子队列，可以访问该子队列的首部元素
 *              如果不为空，则 B 栈中已经存储子队列，可以访问子队列的首部元素
 */
public class Test07 {

    class MQueue<T>{
        // 压入栈，存储添加的数据
        private Stack<T> pushStack = new Stack<>();
        // 弹出栈，存储子队列
        private Stack<T> popStack = new Stack<>();

        public MQueue(){ }
        public MQueue(T[] args){
            for (T str: args)
                pushStack.push(str);
        }

        public void appendTail(T element){
            pushStack.push(element);
        }

        public T deleteHead(){
            // 子队列为空时，再次创建子队列
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    T popElement = pushStack.pop();
                    popStack.push(popElement);
                }
            }
            // String retval = this.popStack.isEmpty() ? null: this.popStack.pop();
            if (popStack.isEmpty()) throw new RuntimeException("Queue is empty, no more element.");
            return popStack.pop();
        }
    }

    public void test1(){
        MQueue<String> queue = new MQueue<>();
        String[] strs = new String[2];
        for (int i = 0; i < strs.length; i++)
            strs[i] = "" + i;
        queue.appendTail(strs[0]);
        queue.appendTail(strs[1]);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        // System.out.println(queue.deleteHead());
    }

    public void test2(){

        String[] strs = new String[2];
        for (int i = 0; i < strs.length; i++)
            strs[i] = "" + i;
        MQueue<String> queue = new MQueue<>(strs);
        queue.appendTail("xxxx");
        // queue.appendTail("yyyy");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    public static void main(String[] args){
        Test07 test = new Test07();
        test.test1();
        test.test2();
    }
}

```

[回到目录](#目录)




面试题8 旋转数组的最小数字
=====================

>**题目：** 
>
> 把一个数组的最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
> 输入一个**递增排序【更准确的说法是 非递减排序， 本题目的难点就是需要考虑各种特殊情况】**的数组的一个旋转，输出旋转数组的最小元素。
> 例如，数组 {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。


```
package algorithm.foroffer;

import java.util.Arrays;

/**
 * Created by liyazhou on 2017/5/24.
 * 面试题 8：旋转数组的最小数字
 * 题目：
 *      把一个数组的最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如，数组 {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 思路：
 *      1. 二分查找（双指针，确定边界）
 *      2. 初始时，A 指针指向第一个元素，B 指针指向最后一个元素;
 *              两个指针分别从开头和末尾向中间移动，直到指向同一个位置
 *         两个指针所在的下标之和折半，
 *              若该元素大于 B 指针指向的元素，则该元素属于第一个递增子数组，
 *                  最小值位于折半位置和 B 指针之间，所以将 A 指向折半后的位置
 *              若该元素小于 B 指针指向的元素，则该元素属于第二个递增子数组，
 *                  最小值位于 A 指针和折半位置之间，所以将 B 指向折半后的位置
 *         当 A 指针和 B 指针位置相同时，它们指向的元素就是最小值
 *
 *
 * 思路2：
 *      1. 二分查找（双指针，确定边界）
 *      2. 初始时，A 指针指向第一个元素，B 指针指向最后一个元素;
 *              两个指针分别从开头和末尾向中间移动，直到指向同一个位置
 *         两个指针所在的下标之和折半得到指针 mid，
 *              若A、B 和 mid 三者指向的元素相等，
 *                  则无法判断 mid 指向的元素属于第一个还是第二个递增子数组，所以顺序查询最小元素
 *              若该元素大于等于 A 指针指向的元素，
 *                  则该元素属于第一个递增子数组，最小值位于折半位置和 B 指针之间，所以将 A 指向折半后的位置
 *              若该元素小于等于 B 指针指向的元素，
 *                  则该元素属于第二个递增子数组，最小值位于 A 指针和折半位置之间，所以将 B 指向折半后的位置
 *         当 A 指针和 B 指针位置相同时，它们指向的元素就是最小值
 */
public class Test08 {

    public int min(int[] array){
        // 判断输入
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");

        int first = 0;
        int second = array.length-1;
        // 特殊情况：当第二递增子数组的长度为 0 时，不执行下面的程序，返回数组的第一个元素
        int mid = first;  
        while(array[first] >= array[second]) {
            // 找到最小数字，记录位置，退出循环
            // if (second - first <= 1){  // 等于 0 时，表示数组中只有一个元素
            if (second - first == 1){  // 终止条件
                mid = second;
                break;
            }

            // 对 first 和 second 折半
            mid = (first + second) / 2;
            int midElement = array[mid];

            if (midElement == array[first] && midElement == array[second]){
                // 特殊情况，当折半后的下标和 A、B 指向的元素都相等时，
                // 无法判断该元素属于第一个还是第二个递增子数组，则顺序查找
                for(int i = first+1; i <= second; i++)
                    if (array[i-1] - array[i] > 0 ) {
                        return array[i];
                    }
            }

            if (midElement >= array[first]) first = mid;
            else if (midElement <= array[second]) second = mid;

            System.out.println(String.format("first = %d, second = %d", first, second));
        }
        return array[mid];
    }


    public static void main(String[] args){
         int[][] arrays = {
                            {3, 4, 5, 1, 2},  // 典型输入，单调升序的数组的旋转数组
                            {1, 0, 1, 1, 1},  // 折半后的指针指向的元素等于两个指针指向的元素，且该元素属于第二个递增子数组
                            {1, 1, 1, 0, 1},  // 折半后的指针指向的元素等于两个指针指向的元素，且该元素属于第一个递增子数组
                            {1, 2, 3, 4, 5},  // 第二个递增子数组的长度为 0
                            {3, 4, 5, 1, 1},  // 有重复元素
                            {2},              // 只有一个数字
                            null,             // 数组为 null
                          };

        for (int i = 0; i < arrays.length; i++){
            int[] array = arrays[i];
            Test08 test = new Test08();
            int min = test.min(array);
            System.out.println(String.format("array = %s, min = %d", Arrays.toString(array), min));
        }
    }
}

```

[回到目录](#目录)




面试题9 斐波那契数列/青蛙跳台阶/矩形覆盖/变态跳台阶
==========================================


>  **题目一：**
>
>  写一个函数，输入 n，求斐波那契 (Fibonacci)数列的第 n 项。斐波那契数列的定义如下：
>  f(n) = 0,                   n = 0
>
>  f(n) = 1,                   n = 1
>
>  f(n) = f(n-1) + f(n-2),     n > 1

>   
>  **题目二：**
>
>  一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。
>  求该青蛙跳上一个 n 级台阶总共有多少种跳发。

```
package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/24.
 * 面试题9：斐波那契数列
 * 题目一：
 *      写一个函数，输入 n，求斐波那契 (Fibonacci)数列的第 n 项。斐波那契数列的定义如下：
 *          f(n) = 0,                   n = 0
 *          f(n) = 1,                   n = 1
 *          f(n) = f(n-1) + f(n-2),     n > 1
 *
 * 思路：
 *      1. 当 n = 0 或 1 时，返回 n
 *      2. 当 n > 1 时，返回前两项元素之和。使用循环实现
 *
 *
 * 题目二：
 *      一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。
 *      求该青蛙跳上一个 n 级台阶总共有多少种跳发。
 *
 * 思路：
 *      1. 本质就是斐波那契数列，使用递归思想解题
 *      2. 如果只有 1 级台阶，结果只有一种跳法；
 *         如果只有 2 级台阶，结果有两种跳法；
 *         如果台阶阶数为n，n 大于 2时，第一次跳有两种不同的选择，
 *         一是先跳一级台阶，则总的跳法数目为后面 n-1 级台阶的跳法数目；
 *         二是先跳二级台阶，则总的跳法数目为后面 n-2 级台阶的跳法数目
 */
public class Test09 {

    public static int fibonacciUsingRecursion(int n){
        // 递归终止条件
        if (n < 2) return n;
        // 递归操作，不能改变状态变量的数值
        return fibonacciUsingRecursion(n-1) + fibonacciUsingRecursion(n-2);
    }

    public static int fibonacci(int n){
        if (n < 0) throw new RuntimeException("Invalid input n");
        else if (n <=1 ) return n;

        int first = 0;
        int second = 1;
        int tmp = -1;
        for (int i = 1; i < n; i++){
            tmp = second;
            second = first + second;
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.println(String.format("fibonacci(%d) = %d", i, Test09.fibonacci(i)));
            System.out.println(String.format("fibonacci(%d) = %d", i, Test09.fibonacciUsingRecursion(i)));
        }
    }
}

```


----------

青蛙跳台阶
2017-8-23 09:22:24

```
public class Solution {
    public int JumpFloor(int target) {
       if (target <= 2) return target;
        
        
       int first = 1;
       int second = 2;
       int temp = -1;
       for (int i = 3; i <= target; i ++){
           temp = first + second;
           first = second;
           second = temp;
       }
       return second;
    }
}
```


----------

矩形覆盖
2017-8-23 09:44:16
**题目描述：**
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

```
public class Solution {
    public int RectCover(int target) {
       if (target <= 2) return target;
        
       int first = 1;
       int second = 2;
       int temp = -1;
       for (int i = 3; i <= target; i ++){
           temp = first + second;
           first = second;
           second = temp;
       }
       return second;
    }
}
```



----------


变态跳台阶
2017-8-23 09:42:33

**题目：**
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

```
public class Solution {
    public int JumpFloorII(int target) {
        return (int)Math.pow(2, target-1);
    }
}
```

[回到目录](#目录)




面试题10 二进制中 1 的个数
======================

> **题目:** 
>
> 请实现一个函数，输入一个整数，输出该整数二进制表示中 1 的个数。
> 例如把 9 表示成二进制是 1001， 有 2 位是 1。因此如果输入 9，该函数输出 2。

```
package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/25.
 * 面试题10：二进制 1 的个数
 * 题目：
 *      请实现一个函数，输入一个整数，输出该整数二进制表示中 1 的个数。
 *      例如把 9 表示成二进制是 1001， 有 2 位是 1。因此如果输入 9，该函数输出 2。
 */
public class Test10 {

    /**
     * 思路：
     *      1. 使用Integer.toBinaryString(int number)，将整数转换为二进制数组
     *      2. 统计字符串中 1 的个数
     * @param n 整数
     * @return 1 的个数
     */
    public static int numberOfOne(int n){
        String binString = Integer.toBinaryString(n);
        System.out.println(String.format("binString of %d, %s", n, binString));
        int counter = 0;
        for (int i = 0; i < binString.length(); i++)
            if (binString.charAt(i) == '1')
                counter ++;
        return counter;
    }

    /**
     * 思路：
     *      1. 将帧数转换为二进制字符串
     *      2. 统计字符串中 1 的个数
     * @param n 整数
     * @return 1 的个数
     */
    public static int numberOfOne2(int n){
        String binString = getBinString1(n);
        System.out.println(String.format("binString of %d, %s", n, binString));
        int counter = 0;
        for (int i = 0; i < binString.length(); i++)
            if (binString.charAt(i) == '1')
                counter ++;
        return counter;
    }

    /**
     * 将一个十进制整数转换为二进制字符串
     *
     * 在计算机中，为了方便计算（计算机中只有加法运算），所有数字都是用其补码表示的
     *
     * 原码、反码和补码详解：
     *  int类型的表示范围是 [-2^31, 2^31-1]
     *  1. 正整数，表示范围是 [1, 2^31-1]
     *      正整数的原码 = 反码 = 补码
     *
     *  2. 负整数（不能超出表示范围 [-2^31, -1]）
     *      负整数的原码，求负整数绝对值的原码，并将（最左边、最高位）符号位设置为 1
     *      负整数的反码，在原码的基础上，符号位不变，其余取反
     *      负整数的补码，在其原码的基础上，符号位不变，其余取反，最后加 1（或者表述为，在负整数的反码基础上，加 1）
     *
     *      负整数的补码转化为反码，负整数的补码减 1
     *      负整数的反码转化为原码，符号位不变，其余取反
     *
     *  3. 零，表示 0
     *      和正整数一样，其原码 = 反码 = 补码，为 [0000 0000 0000 0000]
     *
     * 注意：
     *      8 位二进制整数的取值范围是 [1111 1111, 0111 1111]，也即是 [-127, 127]，那么-128怎么表示呢？
     *      对于8位二进制，使用原码或反码表示的范围为[-127, +127]，而使用补码表示的范围是 [-128, 127]
     *      (-1) + (-127) = [1000 0001]原 + [1111 1111]原 = [1111 1111]补 + [1000 0001]补 = [1000 0000]补
     *      -1-127的结果应该是 -128，在用补码运算的结果中，[1000 0000]补就是 -128。
     *      但是注意因为实际上使用以前的-0的补码来表示-128，所以 -128 并没有原码和反码表示。
     *      （对 -128 的补码表示[1000 0000]补算出来的原码是[0000, 0000]原，这是不正确的）
     *
     * @param n 十进制整数
     * @return 二进制字符串
     */
    private static String getBinString1(int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -1 * n;
        }
        StringBuilder sBuilder = new StringBuilder();
        while(n != 0){
            int remainder = n % 2;
            n = n / 2;
            sBuilder.append(remainder);
        }

        // 根据负数绝对值的原码，计算负数的补码
        if (isNegative){
            for (int i = sBuilder.length(); i < 31; i++)
                sBuilder.append(0);
            sBuilder.append(1);

            for (int j = 0; j < sBuilder.length()-1; j++){
                char ch = sBuilder.charAt(j)=='0' ? '1' : '0';
                sBuilder.setCharAt(j, ch);
            }

            StringBuilder tmpBuilder = new StringBuilder();
            int addition = 1;
            for (int k = 0; k < sBuilder.length(); k++){
                int emt = (sBuilder.charAt(k) == '0' ? 0 : 1) + addition;
                if (emt == 1) {
                    tmpBuilder.append(1);
                    break;
                }else{
                    tmpBuilder.append(0);
                    addition = 1;
                }
            }
            for(int i = tmpBuilder.length(); i < sBuilder.length(); i++)
                tmpBuilder.append(sBuilder.charAt(i));
            sBuilder = tmpBuilder;
        }
        return sBuilder.reverse().toString();
    }

    /**
     * 思路：
     *      1. 位操作：按位与操作，左移
     *      2. 2 的 n 次幂整数，与 number 按位与操作，
     *              如果结果大于0，则当前位数字为 1，
     *              否则，当前数字为 0
     * @param number 整数
     * @return 1 的个数
     */
    public static int numberOfOne3(int number){
        String binString = getBinString2(number);
        System.out.println(String.format("binString of %d, %s", number, binString));
        int counter = 0;
        int base = 1;
        while(base > 0){
            if((number & base) > 0) counter ++;
            base = base << 1;
        }
        if ((number & base) < 0) counter ++;   // number = 9, 0000 0000 0000 0000 0000 0000 0000 1001
        return counter;
    }

    private static String getBinString2(int number) {
        StringBuilder sBuilder = new StringBuilder();
        int base = 1;
        while(base > 0){
            int bitResult = (number & base) > 0 ? 1 : 0;  // 9 & 8 = 8
            sBuilder.append(bitResult);
            base = base << 1;
        }
        sBuilder.append((number & base) < 0 ? 1 : 0);  // number = 9, 0000 0000 0000 0000 0000 0000 0000 1001
        return sBuilder.reverse().toString();
    }

    /**
     * 思路：
     *      1. 位操作：按位与操作，无符号右移
     *      2. 2 的 n 次幂整数，与 number 按位与操作，
     *              如果结果大于0，则当前位数字为 1，
     *              否则，当前数字为 0
     * @param number 整数
     * @return 1 的个数
     */
    public static int numberOfOne4(int number){
        String binString = getBinString3(number);
        System.out.println(String.format("binString of %d, %s", number, binString));
        int counter = 0;
        // Java语言规范中，int整型类型占四个字节，总计32位
        // 对每一个位置与 1 进行按位与操作，再累加就可以求出当前数字的表示包含有多少位 1
        for (int i = 0; i < 32; i++){
            counter += (number & 1);
            number = number >>> 1;
        }
        return counter;
    }

    /**
     * 将整型数字转换为二进制字符串
     * @param number 整型数字
     * @return 二进制字符串
     */
    private static String getBinString3(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        return sBuilder.reverse().toString();
    }

    public static void main(String[] args){
        int number = 0B1001;
        System.out.println(String.format("numberOfOne(%d) = %d", number, numberOfOne(number)));
        System.out.println(String.format("numberOfOne2(%d) = %d", number, numberOfOne2(number)));
        System.out.println(String.format("numberOfOne3(%d) = %d", number, numberOfOne3(number)));
        System.out.println(String.format("numberOfOne3(%d) = %d", number, numberOfOne4(number)));
    }
}

```



## 面试题11 数值的整数次方

> **题目：**
>
>  实现函数 double Power(double base, int exponent)，求 base 的 exponent 次方。
>  不得使用库函数，同时不需要考虑大数问题。

```
package algorithm.foroffer.top20;

/**
 * Created by liyazhou on 2017/5/25.
 * 面试题11：数值的整数次方
 * 题目：
 *      实现函数 double Power(double base, int exponent)，求 base 的 exponent 次方。
 *      不得使用库函数，同时不需要考虑大数问题。
 *
 * 问题：
 *      1. 指数 exponent可能为 0 或者负数
 *      2. 底数为 0 的特殊情况, 0^0 = 1，0^n = 0
 *      3. 判断 double 型底数是否为 0，虽然double 类型不是精确类型，但是Java语言支持使用等号判断
 *
 * 思路：
 *      1、exponent == 0, 返回 1
 *      2. base == 0, 返回 0
 *      3. base!=0, exponent < 0, 累乘 1/base abs(exponenet)次
 *      4. base!=0, exponent > 0, 累乘 1/base exponent 次
 *
 */
public class Test11 {

    /**
     * 一般做法
     * @param base 底数
     * @param exponent 幂次，指数
     * @return 幂运算结果
     */
    public static double power(double base, int exponent){
        if (exponent == 0) return 1.0;  // 任何数的零次幂结果均为 1
        if (base == 0) return 0.0;

        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        return powerWithPositiveExponent(base, exponent);
    }

    private static double powerWithPositiveExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++)
            result *= base;
        return result;
    }


    /**
     * 优化的方法，折半的思想，可以减少 abs(exponent)/2 次循环，
     * 如果exponent较大，可以多次折半
     * @param base 底数
     * @param exponent 幂次，指数
     * @return 幂运算结果
     */
    public static double power2(double base, int exponent){
        if (exponent == 0) return 1.0;  // 任何数的零次幂结果均为 1
        if (base == 0) return 0.0;

        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        double result = powerWithPositiveExponent(base, exponent>>1);  // 折半计算，减少循环次数
        result *= result;
        if ((exponent & 1) == 1) result *= base;  // 按位与 1，判断整数为奇数还是偶数
        return result;
    }

    public static void main(String[] args){
        double[] bases  =  {0, 10, -1, 5};
        int[] exponents =  {0, -5, -3, 4};
        for (int i = 0; i < bases.length; i++){
            System.out.println(String.format("power(%.6f, %d) = %.6f", bases[i], exponents[i], 
            Test11.power(bases[i], exponents[i])));
            System.out.println(String.format("power2(%.6f, %d) = %.6f", bases[i], exponents[i], 
            Test11.power2(bases[i], exponents[i])));
        }
    }
}

```


----------


```
 // 进一步优化，使时间复杂度降为 log(n)
 // 2017年10月4日22:11:28
 public static double pow(double base, int exponent){
     if (exponent == 0) return 1;
     boolean isNegative = exponent < 0;
     if (isNegative) exponent = - exponent;

     int lgn = (int)Math.log(exponent);
     double result = base;
     for (int i = 0; i < lgn; i ++) result *= result;

     for (int j = 0; j < exponent-Math.pow(2, lgn); j ++) result *= base;

     if (isNegative) result = 1/result;
     return result;
 }
```




## 面试题12 打印1到最大的n位整数

> **题目：**
>
>  输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。
>  比如输入 3，则打印出 1,2,3 一直到最大的 3 位数即 999.

```
package algorithm.foroffer.top20;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by liyazhou on 2017/5/25.
 * 面试题12：打印 1 到最大的 n 位数
 *
 * 题目：
 *      输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。
 *      比如输入 3，则打印出 1,2,3 一直到最大的 3 位数即 999.
 *
 * 问题：
 *      1. 大整数问题
 *
 * 思路：
 *      1. 使用 BigInteger类型
 *      2. 使用整型数组模拟大整数以及加 1 运算
 *             数组的左端表示整数的高位，右端表示整数的低位
 *             每次为该"整数"加1，
 *                  如果高位没有溢出，打印该整数
 *                  否则，停止循环加1的操作
 *             打印出整数的合理形式
 */
public class Test12 {

    public static void printOneToNDigits(int length){
        if (length < 0) throw new RuntimeException("Invalid input.");

        BigInteger max = BigInteger.TEN.pow(length);
        for(BigInteger i = BigInteger.ONE; i.compareTo(max) < 0; ){
            System.out.print(i.toString() + "\t");
            i = i.add(BigInteger.ONE);
        }
    }


    /**
     * 思路：
     *      1. 使用数组模拟大整数，数组左端为高位，右端为低位
     *      2. "数字"每次增加 1，
     *          如果没有溢出，也即是最高位没有进位时，打印出用数组表示的该数字；
     *          否则，退出循环
     *
     * @param length 最大数字的位数
     */
    public static void printOneToNDigits2(int length){
        if (length < 1) throw new RuntimeException("Invalid input, the parameter must be bigger than 0");
        // 存储大整数
        int[] arr = new int[length];
        while(!addOne(arr)){
             // System.out.println(Arrays.toString(arr));
             printDigit(arr);
        }
    }

    /**
     * 功能：打印用数组表示的整数
     * 思路：判断开头是不是连续的0，如果是，则忽略；遇见非零元素后，打印后面的全部元素
     * @param arr 表示"整数"的数组
     */
    private static void printDigit(int[] arr) {
        boolean isZero = true;
        for (int i = 0; i < arr.length; i++){
            if (isZero && arr[i] != 0) isZero = false;  //遇见非零数字后，不会再执行该语句
            if (!isZero)  System.out.print(arr[i]);
        }
        System.out.print("\t");
    }

    /**
     * 用数组模拟大整数加法运算，并判断"整数"加 1 后最高位是不是进位
     *
     * @param arr 表示"整数"的数组
     * @return 最高位是否进位
     */
    private static boolean addOne(int[] arr) {
        int increment = 1;
        boolean isOverflow = true;
        for(int i = arr.length-1; i >=0; i--){
            int digit = arr[i] + increment;
            increment = digit / 10;
            arr[i] = digit % 10;
            if (increment == 0) {
                isOverflow = false;
                break;
            }
        }
        return isOverflow;
    }


    public static void printOneToNDigits3(int length){

    }


    public static void main(String[] args){
        Test12.printOneToNDigits(2);
        System.out.println();
        Test12.printOneToNDigits2(2);
    }
}

```


----------


2017-9-16 18:40:35

```
 /**
  * 连续打印1~length位的所有整数（比之前版本更容易理解）
  * @param length 最大整数的位数
  */
 public void test12_printOneToN02(int length){
     // 如果length = 3，则最大值是 1000，最高位是 1 则退出循环
     int[] arr = new int[length + 1];
     while(test12_addOne(arr)){  // 如果最高位不是 1， 则一直加 1
         test12_printN(arr);  // 打印当前的整数
     }
 }

 private void test12_printN(int[] arr) {
     boolean isZero = true;
     for (int i = 0; i < arr.length; i ++){
         if (arr[i] != 0) isZero = false;  // 遇到非零数字之前，isZero = true，则将不会执行下面的打印语句
         // if (isZero && arr[i] != 0) isZero = false;  
         // 小优化，只有isZero=true时，才可能执行该语句，为false时一定不会执行
         if (!isZero) System.out.print(arr[i]);
     }
     System.out.print("\t");
 }

 /**
  * 如果最高位不是1，返回true，表示还没有达到最大值，可以继续加 1
  * @param arr 使用数组保存整数
  * @return 是否可以继续加 1
  */
 private boolean test12_addOne(int[] arr) {
     int increment = 1;
     // 模拟整数加 1 操作
     for (int i = arr.length-1; i >= 0; i--){
         int intDigit = arr[i] + increment;
         arr[i] = intDigit % 10;
         increment = intDigit / 10;
         if (increment == 0) break;
     }
     // 判断最高位是否为 1
     boolean continues = true;
     if (arr[0] == 1) continues = false;
     return continues;
 }
```



## 面试题13 在o(1)时间删除链表结点

>**题目：**
>
> 给定单项链表的头指针和一个结点指针，定义一个函数在 O(1) 时间删除该节点。
> 链表结点与函数定义如下：

```
package algorithm.foroffer.top20;

/**
 * Created by liyazhou on 2017/5/25.
 * 面试题13：在 O(1) 时间删除链表结点
 *
 * 题目：
 *      给定单项链表的头指针和一个结点指针，定义一个函数在 O(1) 时间删除该节点。
 *      链表结点与函数定义如下：
 *
 * 问题：
 *      1. 快速定位结点位置
 *
 * 思路：
 *      1. 一般思路是，删除单向链表的一个结点，需要获取该结点的前驱节点，但时间复杂度是 O(n)，不可行
 *      2. 要删除单向链表的一个结点，可以将其后继结点复制到当前结点，并删除该后继结点即可
 *         存在特殊情况，
 *              如果单向链表只有一个结点，则将头指针赋值为空既可以
 *              如果要删除的结点位于单向链表的末尾，则需要顺序遍历所有的结点，直到倒数第二个结点，把其后继结点设置为空
 */

class Node{
    int value;
    Node next;
}

public class Test13 {

    /**
     * 删除单向链表中的某个结点
     * @param head 单向链表头结点
     * @param deleteNode 链表中的某个结点，由该方法的调用者控制，此方法在 O(1)时间无法检验该结点是否属于链表
     * @return
     */
    public static Node deleteNode(Node head, Node deleteNode){
        if (head == null || deleteNode == null) return head;

        // 只有一个结点的单向链表，由于已经保证两个结点都属于链表，所以此处两者相同
        if (head.next == null) return null;

        // 有两个及以上结点的单向链表，且要删除的结点位于单向链表末尾
        if (deleteNode.next == null){
            Node preNode;
            // 找到最后倒数第二个结点
            for (preNode = head; preNode.next.next != null; preNode = preNode.next);
            preNode.next = null;
            return head;
        }

        // 要删除的节点在单链表中间位置
        Node nextNode = deleteNode.next;  // 获取待删除结点的后继结点
        deleteNode.value = nextNode.value; // 将待删除结点的后继结点，复制到待删除结点
        deleteNode.next = nextNode.next;  // 将待删除结点的后继结点设置为其后继结点的后继结点

        return head;
    }


    public static void main(String[] args){
        Node head = new Node();
        head.value = 0;
        Node tmpNode = head;
        Node deleteNode = null;
        for (int i = 1; i < 10; i++){
            Node currNode = new Node();
            currNode.value = i;

            tmpNode.next = currNode;
            tmpNode = currNode;

            if (i == 4) deleteNode = currNode;
        }

        Node link = Test13.deleteNode(head, deleteNode);
        for(Node currNode = link; currNode != null && currNode.next != null; currNode = currNode.next)
            System.out.println(String.format("currNode = %d, nextNode = %d", currNode.value, currNode.next.value));
    }
}

```



## 面试题14 调整数组顺序使奇数位于偶数前面

>**题目：**
>
> 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
> 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

```
package algorithm.foroffer.top20;

import java.util.Arrays;

/**
 * Created by liyazhou on 2017/5/26.
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 题目：
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *      使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 问题：
 *      1. 排序
 *
 * 思路：
 *      1. 快速排序的思想
 *      2. 用 A、B 两个指针分别指向数组的开始和末尾
 *          A 指针往右移动，若发现偶数则停止移动
 *          B 指针往左移动，若发现奇数则停止移动
 *          若 A 指向偶数，B 指向奇数。交换两者的位置
 *          直到 A、B 指针相遇
 *
 */
public class Test14 {

    public static void reorderOddEven(int[] array){
        if (array == null) return;
        int first = 0;
        int second = array.length-1;

        while (first < second){
            // 从左往右，找到第一个偶数
            while(((array[first] & 1) == 1) && first < second) first ++;
            while(((array[second] & 1) == 0) && second > first) second --;
            // 从右往左，找到第一个奇数
            if (first < second){
                int tmp = array[first];
                array[first] = array[second];
                array[second] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] array = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        Test14.reorderOddEven(array);
        System.out.println(Arrays.toString(array));
    }

}

```



## 面试题15 链表中倒数第k个结点

> **题目：**
>
>  输入一个链表，输出该链表第 k 个结点。
>  为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾结点是倒数第 1 个结点。
>  例如一个链表有 6 个结点，从头结点开始它们的值依次是 1、2、3、4、5、6.
>  这个链表的倒数第 3 个结点是值为 4 的结点。

```
package algorithm.foroffer.top20;

/**
 * Created by liyazhou on 2017/5/26.
 * 面试题15：链表中倒数第 k 个结点
 *
 * 题目：
 *      输入一个链表，输出该链表第 k 个结点。
 *      为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾结点是倒数第 1 个结点。
 *      例如一个链表有 6 个结点，从头结点开始它们的值依次是 1、2、3、4、5、6.
 *      这个链表的倒数第 3 个结点是值为 4 的结点。
 *
 * 问题：
 *      1. 索引单向链表中的元素
 *      2. 边界问题
 *
 * 思路：
 *      1. 顺序遍历
 *      2. trick，两个前后间隔相差 k 的指针顺序遍历整个单向链表到末尾，前面一个指针指向的元素即为倒数第 k 个结点
 */

class Node15{
    int value;
    Node15 next;
}

public class Test15 {

    public static Node15 findKthFromTail(Node15 head, int k){
        if (head == null || k < 0)
            throw new RuntimeException("Invalid input, linked list is null or k is smaller than zero.");

        Node15 first= head;
        Node15 second = head;

        for (int i = 1; i < k; i++) { // 从 1 开始计数
            second = second.next;
            // 单向链表的长度小于 k
            if (second == null) return null;
        }

        for (; second.next != null; second = second.next)
            first = first.next;

        return first;
    }


    public static void main(String[] args){
        Node15 head = new Node15();
        head.value = 0;

        Node15 tmpNode = head;
        int length = 10;
        for (int i = 1; i < length; i++){
            Node15 currNode = new Node15();
            currNode.value = i;
            tmpNode.next = currNode;
            tmpNode = currNode;
        }

        Node15 kNode = Test15.findKthFromTail(head, 10);
        StringBuilder sBuilder = new StringBuilder();
        for (Node15 currNode = head; currNode != null; currNode = currNode.next )
            sBuilder.append(currNode.value).append("-");
        sBuilder.deleteCharAt(sBuilder.length()-1);

        System.out.println(sBuilder.toString() + "\n");

        System.out.println(kNode.value);
    }
}

```



## 面试题16 反转链表

> **题目：**
>
>  定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
>  链表结点定义如下

```
package algorithm.foroffer.top20;

/**
 * Created by liyazhou on 2017/5/26.
 * 面试题16：反转链表
 *
 * 题目：
 *      定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *      链表结点定义如下
 *
 * 问题：
 *      1. 单向链表的遍历
 *
 * 思路：
 *      1. 取出第一个结点和第二个结点，将第一个结点的后继结点设置为 null
 *      2. 取出链表中两个相邻的结点 A、B
 *         tmp = B.next
 *         B.next = A
 *         A = B
 *         B = tmp
 *         直到 B 结点为空
 */


class Node16{
    int value;
    Node16 next;
}


public class Test16 {

    public static Node16 reverseList(Node16 head){
        if (head == null || head.next == null) return head;

        Node16 first = head;
        Node16 second = head.next;

        // 首先，第一个元素的后继结点设置为 null
        first.next = null;

        for (Node16 tmpNode; second != null;){
            // System.out.println(second.value);
            tmpNode = second.next;  // 取出第二个结点的后继结点，保存到临时变量中
            second.next = first;    // 第二个结点的后继结点设置为第一个结点
            first = second;         // 第一个结点向后移动一位
            second = tmpNode;       // 第二个结点向后移动一位
        }
        return first;
    }


    public static void main(String[] args){
        Node16 head = new Node16();
        head.value = 0;

        Node16 tmpNode = head;
        int length = 10;
        for (int i = 1; i < length; i++){
            Node16 currNode = new Node16();
            currNode.value = i;
            tmpNode.next = currNode;
            tmpNode = currNode;
        }
        System.out.println(Test16.listToString(head) + "\n");
        Node16 newHead = Test16.reverseList(head);
        System.out.println(Test16.listToString(newHead));

    }


    public static String listToString(Node16 head){
        StringBuilder sBuilder = new StringBuilder();
        for (Node16 currNode = head; currNode != null; currNode = currNode.next )
            sBuilder.append(currNode.value).append("-");
        sBuilder.deleteCharAt(sBuilder.length()-1);
        return sBuilder.toString();
    }
}

```



## 面试题17 合并两个排序的链表

> **面试题：**
>
> 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
> 例如输入链表1，1-3-5-7，和链表2，2-4-6-8，则合并之后的升序链表如链表3，
> 1-2-3-4-5-6-7-8。链表结点的定义如下。

```
package algorithm.foroffer.top20;

/**
 * Created by liyazhou on 2017/5/26.
 * 面试题17：合并两个排序的链表
 *
 * 题目：
 *      输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 *      例如输入链表1，1-3-5-7，和链表2，2-4-6-8，则合并之后的升序链表如链表3，
 *      1-2-3-4-5-6-7-8。链表结点的定义如下。
 *
 * 问题：
 *      1. 链表的遍历
 *      2. 指针操作
 *
 * 思路：
 *      1. 两个指针分别指向两个链表的头结点
 *      2. 比较两个指针指向的元素的大小
 *          将较小者添加到新链表中，并将指针往后移动一位
 *          循环执行
 *          当一个指针为空时，将另一个指针设置为新链表尾结点的后继结点
 */

class Node17{
    int value;
    Node17 next;
}

public class Test17 {

    public static Node17 mergeOrderList(Node17 head1, Node17 head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Node17 newHead;
        // if (head1.value < head2.value){
        //    newHead = head1;
        //    head1 = head1.next;
        // }else{
        //    newHead = head2;
        //    head2 = head2.next;
        //}

        Node17 newHead = new Node17();
        Node17 tailNode = newHead;
        while (head1 != null && head2 != null){
            if (head1.value < head2.value) {
                tailNode.next = head1;
                head1 = head1.next;
            } else{
                tailNode.next= head2;
                head2 = head2.next;
            }
            tailNode = tailNode.next;
        }
        // tailNode.next = null;  // 确保尾结点的后继结点为 null
        if (head1 != null) tailNode.next = head1;
        else tailNode.next = head2;

        return newHead;
    }

    /**
     * 递归方式实现合并两个排序的链表
     * @param head1 链表一
     * @param head2 链表二
     * @return 合并后的链表
     */
    public static Node17 mergeOrderList2(Node17 head1, Node17 head2){ return null; }

    public static void main(String[] args){
        Node17 head1 = Test17.generateList(10, 2);
        Node17 head2 = Test17.generateList(10, 3);
        System.out.println(listToString(head1));
        System.out.println(listToString(head2));
        Node17 newHead = Test17.mergeOrderList(head1, head2);
        System.out.println(listToString(newHead));
    }


    private static Node17 generateList(int length, int pace){
        Node17 head = new Node17();
        head.value = 0;

        Node17 tmpNode = head;
        for (int i = 1; i < length; i += pace){
            Node17 currNode = new Node17();
            currNode.value = i;
            tmpNode.next = currNode;
            tmpNode = currNode;
        }

        return head;
    }

    private static String listToString(Node17 head){
        StringBuilder sBuilder = new StringBuilder();
        for (Node17 currNode = head; currNode != null; currNode = currNode.next )
            sBuilder.append(currNode.value).append("-");
        sBuilder.deleteCharAt(sBuilder.length()-1);
        return sBuilder.toString();
    }
}

```




## 面试题18 树的子结构

>**面试题：**
>
> 输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
> 二叉树的定义如下：

```
package algorithm.foroffer.top20;

/**
 * Created by liyazhou on 2017/5/26.
 * 面试题 18：树的子结构
 *
 * 题目：
 *      输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
 *      二叉树的定义如下：
 *
 * 问题：
 *      1. 树中的指针操作
 *      2. 边界条件的检查
 *
 * 思路：
 *      1. 递归
 *      2. 第一，判断 A 的根结点和 B 的根结点是否相等
 *         如果不相等，判断 A 的左孩子和 B 的根结点是否相等
 *         如果不相等，判断 A 的右孩子和 B 的根结点是否相等
 *         递归执行，直到找到与 B 的根结点相等的结点 R
 *
 *         第二，判断 B 的左右孩子结点和 R 的左右孩子结点是否分别相等
 *         如果不相等，返回 false
 *         如果相等，则递归判断对应的后代结点是否相等
 *
 */

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}
    public TreeNode(int value){ this.value = value; }
    public void setChildren(TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
    }
}

public class Test18 {

    /**
     * 判断一个树中是否包含另一个树的结构
     * @param root1 树1的根结点
     * @param root2 树2的根结点
     * @return 包含返回 true，不包含返回 false
     */
    public static boolean hasSubtree(TreeNode root1, TreeNode root2){
        // if (root1 == null || root2 == null) throw new RuntimeException("Invalid input.");

        boolean contains = false;
        if (root1 != null && root2 != null){
            // 递归终止条件，
            // 找到和第二棵树的根结点root2相等的结点
            // 判断以当前结点为根结点的子树是否包含以 root2 为根结点的树
            if (root1.value == root2.value) contains = contains(root1, root2);

            // 如果当前结点和root2 "不相等"（以当前结点为根结点的子树不包含以 root2 为根结点的树），
            // 则判断左孩子结点和 root2 是否相等
            if (!contains) contains = hasSubtree(root1.left, root2);
            // 如果当前结点和root2 "不相等"（以当前结点为根结点的子树不包含以 root2 为根结点的树），
            // 则判断右孩子结点和 root2 是否相等
            if (!contains) contains = hasSubtree(root1.right, root2);
        }

        return contains;
    }

    /**
     * 判断一个树中是否包含另一个树的结构，其中两个树的的根结点相等
     * @param root1 树 1 的根结点
     * @param root2 树 2 的根结点
     * @return 包含返回 true， 不包含返回 false
     */
    private static boolean contains(TreeNode root1, TreeNode root2){
        // 1. 递归终止条件
        if (root2 == null) return true;   // 树 2 遍历结束
        if (root1 == null) return false;  // 树 1 遍历结束，而树 2 还没有遍历结束
        if (root1.value != root2.value) return false;  // 存在对应的结点不相等的情况

        // 2. 递归操作
        return contains(root1.left, root2.left) && contains(root1.right, root2.right);
    }

    public static void main(String[] args){
        TreeNode root1 = generateTree1();
        TreeNode root2 = generateTree2();

        boolean contains = Test18.hasSubtree(root1, root2);
        System.out.println(contains);
    }

    private static TreeNode generateTree1() {
        TreeNode root0 = new TreeNode(8);
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(7);
        TreeNode root3 = new TreeNode(9);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);

        root0.setChildren(root1, root2);
        root1.setChildren(root3, root4);
        root4.setChildren(root5, root6);

        return root0;
    }

    private static TreeNode generateTree2() {
        TreeNode root0 = new TreeNode(8);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(3);

        root0.setChildren(root1, root2);

        return root0;
    }

}


```



## 面试题19 二叉树的镜像

> **题目：** 
>
> 请完成一个函数，输入一个二叉树，该函数输出它们的镜像。
> （反转二叉树 mirrorBinTree, reverseBinTree）

```
package algorithm.foroffer.top20;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liyazhou on 2017/5/27.
 * 面试题19：二叉树的镜像
 *
 * 题目：
 *      请完成一个函数，输入一个二叉树，该函数输出它们的镜像。
 *
 * 问题：
 *      1. 前序遍历二叉树，递归
 *      2. 树中的指针操作
 *
 * 思路：
 *      1. 前序遍历二叉树
 *          如果当前结点有两个子结点，则交换它们的位置
 */


class TreeNode19{
    int value;
    TreeNode19 left;
    TreeNode19 right;

    public TreeNode19(int value){ this.value = value; }
    public void setChildren(TreeNode19 left, TreeNode19 right){
        this.left = left;
        this.right = right;
    }
}


public class Test19 {

    public static void mirrorOfBinTree(TreeNode19 root){
        // 递归终止条件
        if (root == null) return;

        // 针对本次递归的操作
        TreeNode19 tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        mirrorOfBinTree(root.left);
        mirrorOfBinTree(root.right);
    }


    public static void main(String[] args){
        TreeNode19 root = generateTree1();
        levelVisit(root);
        inorderVisit(root);
        System.out.println();
        mirrorOfBinTree(root);
        levelVisit(root);
        inorderVisit(root);

    }

    private static void inorderVisit(TreeNode19 root){
        if (root == null) return;
        inorderVisit(root.left);
        System.out.print(root.value + "-");
        inorderVisit(root.right);
    }


    private static void levelVisit(TreeNode19 root){
        if (root == null) return;
        Queue<TreeNode19> queue = new LinkedList<>();
        queue.add(root);  // queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode19 currNode = queue.poll();
            if (currNode.left != null)  queue.add(currNode.left); // queue.offer(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
            System.out.print(currNode.value + "-");
        }
        System.out.println();
    }

    private static TreeNode19 generateTree1() {
        TreeNode19 root0 = new TreeNode19(8);
        TreeNode19 root1 = new TreeNode19(6);
        TreeNode19 root2 = new TreeNode19(10);
        TreeNode19 root3 = new TreeNode19(5);
        TreeNode19 root4 = new TreeNode19(7);
        TreeNode19 root5 = new TreeNode19(9);
        TreeNode19 root6 = new TreeNode19(11);

        root0.setChildren(root1, root2);
        root1.setChildren(root3, root4);
        root2.setChildren(root5, root6);
        // root0.left = root1;
        // root1.left = root2;

        return root0;
    }

}

```


## 面试题20 顺时针打印矩阵

> **题目：**
>
> 输入一个矩阵，按照从外向里以顺时针依次打印出每一个数字。
> 例如，如果输入矩阵如下：
>          1   2   3   4
>          5   6   7   8
>          9   10  11  12
>         13  14  15  16
>则依次打印出数字 1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10。

```
package algorithm.foroffer.top20;

/**
 * Created by liyazhou on 2017/5/27.
 * 面试题20：顺时针打印矩阵
 *
 * 题目：
 *      输入一个矩阵，按照从外向里以顺时针依次打印出每一个数字。
 *      例如，如果输入矩阵如下：
 *          1   2   3   4
 *          5   6   7   8
 *          9   10  11  12
 *          13  14  15  16
 *      则依次打印出数字 1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10。
 *
 * 问题：对这道题目懵圈
 *
 * 思路：对这道题目懵圈
 *
 */
public class Test20 {

    public static void printMatrixClockwisely(int[][] matrix){
        if (matrix == null) return;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        // 没有发现这规律，不会定义这条件
        while (rows > 2 * start && cols > 2 * start){
            printMatrixCircle(matrix, start);
            start ++;
        }

    }

    private static void printMatrixCircle(int[][] matrix, int start) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++){
            int number = matrix[start][i];
            System.out.print(number + " ");
        }

        // 从上到下打印一列
        if (start < endY){
            for (int i = start + 1; i <= endY; i++){
                int number = matrix[i][endX];
                System.out.print(number + " ");
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY){
            for (int i = endY - 1; i >= start; i--){
                int number = matrix[endY][i];
                System.out.print(number + " ");
            }
        }

        // 从下到上打印一列
        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start + 1; i--){
                int number = matrix[i][start];
                System.out.print(number + " ");
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,    2,    3,    4},
                {5,    6,    7,    8},
                {9,   10,   11,   12},
                {13,  14,   15,   16}
        };

        printMatrixClockwisely(matrix);
    }


}

```



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




## 面试题41 和为 s 的两个数字 VS 和为 s 的连续正数序列


>题目一：
     输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是 s。
     如果有多对数字的和等于 s， 输出任意一对即可。
     例如，输入数组 {1, 2, 4, 7, 11, 15}和数字15，输出 4,7。
>
>题目二：
     输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。
     例如输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，
     所以结果打印出3个连续序列 1~5、4~6 和 7~8。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-01 21:19
 *
 * 面试题41：和为 s 的两个数字 VS 和为 s 的连续正数序列
 *
 * 题目一：
 *      输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是 s。
 *      如果有多对数字的和等于 s， 输出任意一对即可。
 *      例如，输入数组 {1, 2, 4, 7, 11, 15}和数字15，输出 4,7。
 *
 * 考查点：
 *      1. 二叉查找的思想（对于排序数组，首先要想到二分查找，使用两个指针不断缩小范围）
 *
 * 思路：
 *      1. 使用两个指针，分别指向查找范围的最小值 min 和最大值 max
 *      2. 如果 min + max < sum，则 min 向后移动一位
 *         如果 min + max > sum，则 max 向前移动一位
 *         如果 min + max == sum，则输出 min, max，停止循环
 *
 *
 * 题目二：
 *      输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。
 *      例如输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，
 *      所以结果打印出3个连续序列 1~5、4~6 和 7~8。
 *
 * 考查点：
 *      1. 找规律
 *
 * 思路：
 *      1. 连续的数字序列之和正好，则返回该序列
 *         连续的数字序列之和较小，则从后面添加数字
 *         连续的数字序列之和较大，则从前面删除数字，
 *         （每添加一个较大的数字，可以能会删除若干个较小的数字，需要使用循环）
 *         循环条件是，最小值的下标minIdx小于 (sum+1)/2
 *
 */
public class Test41 {

    /**
     * 在数组 array 中查找一对和为 sum 的数字
     * @param array 数组
     * @param sum 两个数字之和
     * @return 如果存在，返回这对数字；不存在，返回 null
     */
    public int[] findTwoNum(int[] array, int sum){
        if (array == null || array.length < 2)  return null;

        int minIdx = 0;
        int maxIdx = array.length-1;

        while (minIdx < maxIdx){
            if (array[minIdx] + array[maxIdx] == sum)       return new int[]{array[minIdx], array[maxIdx]};
            else if (array[minIdx] + array[maxIdx] < sum)   minIdx ++;
            else                                            maxIdx --;
        }
        return null; // 违背单一出口原则，但是这种写法简洁，是适合刷题的写法
    }

    @Test
    public void test11(){
        int[][] arrs = {
                {1, 2, 4, 7, 11, 15},
        };

        int[] result = findTwoNum(arrs[0], 109);
        System.out.println(Arrays.toString(result));
    }


    public void findContinuousSequence(int sum){
        if (sum < 3) return;

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int currSum = small + big;
        while (small < middle){
            if (currSum == sum) printSequence(small, big+1);

            // 每添加一个较大的数字，可以能会删除若干个较小的数字
            while (currSum > sum && small < middle){
                currSum -= small;
                small ++;
                if (currSum == sum) printSequence(small, big+1);
            }

            big ++;
            currSum += big;
        }
    }

    private void printSequence(int start, int end) {
        for (int i = start; i < end; i ++)
            System.out.print(i + "\t");
        System.out.println();
    }

    @Test
    public void test21(){
        findContinuousSequence(4);
    }

}

```



## 面试题42 翻转单词顺序 VS 左旋转字符串

> 题目一：
      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
      为简单起见，标点符号和普通字母一样处理。
      例如输入字符串"I am a student."，则输出"student. a am I"。
>      
> 题目二：
     字符串的左悬殊操作是把字符串前面的若干个字符转移到字符串的尾部。
     请定义一个函数实现字符串左旋转操作的功能。
     比如输入字符串"abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果"cdefgab"。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-02 14:57
 *
 * 面试题42：翻转单词顺序 VS 左旋转字符串
 *
 * 题目一：
 *      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *      为简单起见，标点符号和普通字母一样处理。
 *      例如输入字符串"I am a student."，则输出"student. a am I"。
 *
 * 考查点：
 *      1. 字符数组的操作
 *
 * 思路：
 *      Solution 1：
 *          以空格为 separator(delimiter)将字符串切分为字符串数组，
 *          逆序遍历字符串数组
 *      Solution 2:
 *          两次翻转字符串。
 *          首先，翻转整个字符串；
 *          然后，翻转每个单词。
 *
 * 题目二：
 *      字符串的左悬殊操作是把字符串前面的若干个字符转移到字符串的尾部。
 *      请定义一个函数实现字符串左旋转操作的功能。
 *      比如输入字符串"abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果"cdefgab"。
 *
 * 考查点：
 *
 * 思路：
 *
 *
 */
public class Test42 {

    /**
     * 解法一，翻转单词顺序
     * @param chars 字符数组
     */
    public String reverseSequence(char[] chars){
        if (chars == null) return null;
        String sequence = new String(chars);
        String[] words = sequence.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sBuilder.append(words[i]).append(" ");
        }
        if (sBuilder.length() > 0) sBuilder.deleteCharAt(sBuilder.length()-1);
        return sBuilder.toString();
    }


    /**
     * 解法二：翻转单词顺序
     * @param chars 字符数组
     */
    public String reverseSequence2(char[] chars){
        if (chars == null) return null;

        // for (int i = 0; i < chars.length/2; i++) chars[i] = chars[chars.length-1-i];
        reverseString(chars, 0, chars.length);
        // System.out.println(new String(chars));

        int wordStartIdx = 0;
        int wordEndIdx = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[wordEndIdx] == ' '){
                reverseString(chars, wordStartIdx, wordEndIdx);
                // System.out.println(new String(chars));
                wordStartIdx = wordEndIdx + 1;
            }
            wordEndIdx ++;
        }
        return new String(chars);
    }

    private char[] reverseString(char[] chars, int startIdx, int endIdx){
        // System.out.printf("startIdx, endIdx = %d, %d\n", startIdx, endIdx);
        for (endIdx --; startIdx < endIdx; startIdx ++, endIdx --){
            char tmp = chars[startIdx];
            chars[startIdx] = chars[endIdx];
            chars[endIdx] = tmp;
        }
        return chars;
    }


    @Test
    public void test11(){
        String[] lines = {
                "I am a student.",
                "I",
                " ",
                "",
        };

        for(String line : lines){
            System.out.println("method 1: " + reverseSequence(line.toCharArray()));
            System.out.println("method 2: " + reverseSequence2(line.toCharArray()));
        }
    }


    /**
     * 方法一：字符数组中的前 k 个字符平移到末尾（辅助空间较大）
     * @param chars 字符数组
     * @param k 移动字符的数目
     * @return 移动之后的数组
     */
    public char[] mvHeadToTail(char[] chars, int k){
        if (chars == null || k >= chars.length-1 || k < 0) return chars;
        char[] tmpChars = new char[k];
        for (int i = 0; i < k; i ++) tmpChars[i] = chars[i];
        // 一步到位，但是需要长度的k的字符数组作为辅助空间
        // 当然，当 k 较大且空间复杂度限制时，可以考虑一次移动 m 个字符。
        for(int j = k; j < chars.length; j ++) chars[j-k] = chars[j];
        for(int i = 0; i < k; i ++) chars[chars.length - k + i] = tmpChars[i];
        return chars;
    }

    /**
     * 方法二：字符数组中的前 k 个字符平移到末尾（时间复杂较大）
     * @param chars 字符数组
     * @param k 移动字符的数目
     * @return 移动之后的数组
     */
    public char[] mvHeadToTail2(char[] chars, int k){
        if (chars == null || k >= chars.length-1 || k < 0) return chars;
        char tmp;
        for (int i = 0; i < k; i ++) {
            tmp = chars[0];
            for (int j = 1; j < chars.length; j++) chars[j-1] = chars[j];
            chars[chars.length-1] = tmp;
        }
        return chars;
    }

    @Test
    public void test21(){
        String[] lines = {
                "abcdefg",
                "string",
        };

        for (String line : lines){
            System.out.println(mvHeadToTail(line.toCharArray(), 2));
            System.out.println(mvHeadToTail2(line.toCharArray(), 2));
        }
    }
}

```


----------

左旋转字符串
2017-8-17 17:03:59

```
public String LeftRotateString(String str,int n) {
    if (str == null || str.length() == 0) return str;
    
    n = n % str.length();
    
    StringBuilder s = new StringBuilder(str);
    
    String substring = s.substring(0, n);
    
    s.delete(0, n).append(substring);
    
    return s.toString();
}
```


----------


反转单词顺序
2017-8-17 19:32:27

```
public String ReverseSentence(String str) {
    if (str == null || str.length() == 0) return str;
    
    if (str.trim().equals("")) return str;
    
    String[] words = str.split(" ");
    // if (words.length == 0) return str;  // "               " 的返回结果
    
    StringBuilder result = new StringBuilder();
    
    for (int i = words.length-1; i >= 0; i --)
        result.append(words[i]).append(" ");
        
    if (result.length() > 0)
        result.deleteCharAt(result.length()-1);
    
    return result.toString();
}
```






## 面试题43 n个骰子的点数 - null

> **题目：**
     把 n 个骰子仍在地上，所有骰子朝上一面的点数之和为 s。
     输入 n，打印出 s 的所有可能的值出现的次数。
     

```
package algorithm.foroffer.top50;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-02 19:35
 *
 * 面试题43：n个骰子的点数
 *
 * 题目：
 *      把 n 个骰子仍在地上，所有骰子朝上一面的点数之和为 s。
 *      输入 n，打印出 s 的所有可能的值出现的次数。
 *
 * 考查点：
 *      1. 数学建模能力
 *
 * 思路：
 *
 *
 */
public class Test43 {
}

```





## 面试题44 扑克牌的顺子

>**题目：**
>
>从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
2~10为数字本身， A 为 1，J 为 11，Q 为 12，K 为13，而大、小王可以看成任意数字。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-02 20:12
 *
 * 面试题44：扑克牌的顺子
 *
 * 题目：
 *      从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
 *      2~10为数字本身， A 为 1，J 为 11，Q 为 12，K 为13，而大、小王可以看成任意数字。
 *
 * 考查点：
 *      1. 抽象建模能力
 *
 * 思路：
 *      1. 对非大小王的数字排序
 *             如果有相同的数字，则返回 false
 *             统计大、小王的数目(大小王初始化为0，区分其他的牌)
 *             计算相邻数字之间的差，相差为1，表示连续，相差大于 1，则不连续，统计相邻的牌空缺总数（大于大小王数目，返回 false）
 *
 *
 */
public class Test44 {

    public boolean isContinuous(int[] numbers){
        if (numbers == null || numbers.length != 5) return false;

        // 冒泡排序
        for (int i = 0; i < numbers.length; i ++){
            for (int j = i; j < numbers.length; j ++){
                // if (numbers[i] == numbers[j]) return false; // 存在相同的数字，不是顺子
                if (numbers[i] > numbers[j]){
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        // 统计大小王的个数
        int counter = 0;
        for (int i = 0; i < 2; i ++){
            if (numbers[i] == 0) counter ++;
        }

        int totalDiff = 0;
        for (int i = 1; i < numbers.length; i ++){
            if (numbers[i-1] == 0) continue; // 前一个数字是0，也即是小大王则跳过
            int diff = numbers[i] - numbers[i-1];
            if (diff == 0) return false;
            totalDiff += (diff - 1);
            if (totalDiff > counter) return false;
        }

        return totalDiff <= counter;
    }

    @Test
    public void test(){
        List<Integer> pokers = new ArrayList<>();
        for (int i = 0; i < 4; i ++){
            for (int j = 1; j < 14; j ++)
                pokers.add(j);
        }
        pokers.add(0);
        pokers.add(0);
        Collections.shuffle(pokers);

        for (int times = 0; times < 10; times ++) {
            int[] selectedPokers = new int[5];
            Random random = new Random();
            for (int i = 0; i < 5; i++)
                 selectedPokers[i] = pokers.get(random.nextInt(pokers.size()));

            boolean isContinuous = isContinuous(selectedPokers);
            System.out.println(Arrays.toString(selectedPokers) + ":\t" + isContinuous);
        }
    }


}

```


----------

逻辑更加清晰的代码

2017-8-17 20:15:19

```
public boolean isContinuous(int [] numbers) {
    if (numbers == null || numbers.length == 0) return false;
    
    // Arrays.sort(numbers， Comparator.reverseOrder());
    // Arrays.sort(numbers);
    
    for (int i = 0; i < numbers.length; i ++){
        int idx = i;
        for (int j = i+1; j < numbers.length; j ++){
            if (numbers[j] < numbers[idx])
                idx = j;
        }
        if (idx != i){
            int tmp = numbers[i];
            numbers[i] = numbers[idx];
            numbers[idx] = tmp;
        }
    }
    
    
    int timesOfZero = 0;
    for (int num : numbers){
        if (num == 0) timesOfZero ++;
        else		  break;
    }
    
    int diff = 0;
    for (int i = 1; i < numbers.length; i ++){
        if (numbers[i] == numbers[i-1] && numbers[i] != 0) return false;
        if (numbers[i-1] == 0 || numbers[i] == 0) continue;
        diff += numbers[i] - numbers[i-1] - 1;
    }
    
    boolean isContinuous = false;
    if (timesOfZero >= diff) isContinuous = true; 
    
    return isContinuous;
}
```





## 面试题45 圆圈中最后剩下的数字

>**题目：**
>
> 0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 求出这个圆圈里剩下的最后一个数字。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 20:41
 * 面试题 46：圆圈中最后剩下的数字
 *
 * 题目：
 *      0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 *      求出这个圆圈里剩下的最后一个数字。
 *
 * 考查点：
 *      1. 约瑟夫环问题
 *
 * 思路：
 *      1. 圆形链表
 *
 *
 */
public class Test45 {

    public int lastRemainElement(int n, int m){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) list.add(i);

        int idx = 0;
        for (int i = 0; i < n-1; i ++){
            // for (int j = 0; j < m-1; j ++) idx ++;
            idx = idx + (m-1);
            idx = idx % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }

    @Test
    public void test(){
        System.out.println(lastRemainElement(5, 3));
    }


}

```

使用数组求解
2017-8-17 21:30:30

```
 public int LastRemaining_Solution0(int n, int m) {
     if (n == 0 || m == 0) return -1;
     
     int[] arr = new int[n];  // 下标表示id
     int num = 0;  // 当前报数
     int idx = 0;  // 当前报数的id
     int counter = 0;  // 已经被删除的个数
     
     for (int i = 0; ; i ++){
         num = i % m;
         // idx = idx % n;
         if (num == m-1) {
             arr[idx] = -1;
             counter ++;
             if (counter == n-1) break;
         }
         
         
         // 查找下一个报数的id
         idx ++;
         if (idx == n) idx = 0;
         while (arr[idx] == -1){
             idx ++;
             if (idx == n) idx = 0;
         }

     }
     
     
     for (int j = 0; j < arr.length; j ++){
         if (arr[j] == 0) return j;
     }
     
     return -1;
 }
```






## 面试题46 求 1+2+3+...+n（不使用乘除以及条件判断语句求前 n 项正整数的和）

>**题目：**
>
>求 1+2+...+n。要求不能使用乘除法、for、while、if、else、switch、case等关键字
及条件判断语句。

```
package algorithm.foroffer.top50;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 21:36
 *
 * 面试题46：求 1+2+...+n
 *
 * 题目：
 *      求 1+2+...+n。要求不能使用乘除法、for、while、if、else、switch、case等关键字
 *      及条件判断语句。
 *
 * 考查点：
 *      1. 发散思维，使用对象数组初始化实现求和功能
 *
 * 思路：
 *      1. 不能使用公式法(*,/)，不能使用循环(for/while)、不能使用递归(if)
 *
 */

class Add{
    static int sum = 0;
    static int n = 0;
    public Add(){
        n ++;
        sum += n;
    }

    public static int sum(int n){
        // n = 0;
        // sum = 0;
        // 创建对象数组，仅仅是分配内存空间，不调用构造函数
        Add[] adds = new Add[n];
        return sum;
    }
}
public class Test46 {

    @Test
    public void test(){
        // int sum = Add.sum(5);
        // System.out.println(sum);
    }

    /**
     * 不用 if 判断递归终止条件的递归
     * @param n 参数
     * @return 和
     */
    public int sum(int n){
        int sum = n;
        boolean bool = (n > 0) && ((sum +=sum(n-1)) > 0);
        return sum;
    }

    @Test
    public void test2(){
        System.out.println(sum(5));
    }

}

```






## 面试题47 不用加减乘除做加法

>**题目：**
>
>写一个函数，求两个整数之和，要求在函数体内不得使用加减乘除四则运算。

```
package algorithm.foroffer.top50;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 22:01
 *
 * 面试题 47：不用加减乘除做加法
 *
 * 题目：
 *      写一个函数，求两个整数之和，要求在函数体内不得使用加减乘除四则运算。
 *
 * 考查点：
 *      1. 位运算
 *
 * 思路：
 *      比如计算 5 + 97，
 *      第一步，两个整数的各个对应为相加，每位相加产生的结果不进位。个位是 5 + 7 = 2，十位是 0 + 9 = 9，结果是 92
 *      第二步，只取各位相加产生的进位。个位相加 5 + 7，进位是 10，十位相加 0 + 9，进位是 0
 *      第三步，把第一步产生的不进位结果与第二步产生的所有的进位累加，结果即为所求。92 + 10 + 0 = 102
 *
 *      同理，使用这种方法对二进制数字计算也是成立的。
 *
 */
public class Test47 {

    public int add(int num1, int num2){
        int sum, carry;
        do{  // 从低位到高位循环做进位运算
            sum = num1 ^ num2;  // 不进位相加
            carry = (num1 & num2) << 1; // 进位产生的数字

            num1 = sum; // 加上一次进位数字的结果
            num2 = carry;  // 进的位数，在下一轮循环中，做不进位运算
        }while (num2 != 0);

        return num1;
    }

    @Test
    public void test(){
        System.out.println(add(12, 5));
        System.out.println(add(-12, 5));
        System.out.println(add(-12, -5));
        System.out.println(add(12, 0));
    }

}

```





## 面试题48 不能被继承的类

>**题目：**
>
>用 C++设计一个不能被继承的类。

```
package algorithm.foroffer.top50;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 19:49
 * 面试题 48：不能被继承的类
 *
 * 题目：
 *      用 C++设计一个不能被继承的类。
 *
 * 考查点：
 *      1. 类的继承性
 *
 * 思路：
 *      1. Java语言中，被 final 修饰的类不能被继承，如 String 等
 */

final class FinalClass{

}


public class Test48 /**extends FinalClass*/{
}

```





## 面试题49 把字符串转换成整数

> **题目：**
>
> 把字符串转换成整数

```
package algorithm.foroffer.top50;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 19:54
 *
 * 面试题 49：把字符串转换成整数
 *
 * 考查点：
 *      1. 细节。空字符串，空指针，正负号，前几个数字是0（没啥影响），超出表示范围
 *
 * 思路：
 *      1. 从低位往高位（从右往左）计算
 *
 *
 */
public class Test49 {

    public int strToInt(char[] chars){
        String str = String.valueOf(chars);
        return Integer.valueOf(str); // Integer.parseInt(str);
    }

    public int strToInt2(char[] chars){
        if (chars == null || chars.length == 0) throw new RuntimeException("Invalid input. chars can be null or length is 0.");

        int sign = 1;
        int start = 0;
        if (chars[0] == '-') {
            start = 1;
            sign = -1;
        }
        else if (chars[0] == '+') start = 1;

        return strToIntCore(chars, start, sign);
    }

    private int strToIntCore(char[] chars, int start, int sign) {
        // int value = (int)Math.pow(2, 31); 2147483647,已经强转，表示int型最大值

        long value = sign;
        int base = 1;
        for (int i = chars.length - 1; i >= start; i --){
            if (chars[i] < '0' || chars[i] > '9')
                throw new NumberFormatException(String.valueOf(chars, start, chars.length-start) + ", Invalid input. Element of chars should range from '0' to '9' ");
            // try {  intValue += (chars[i] - '0') * base;  }
            // catch(Exception except){  throw new RuntimeException("beyond the range of int");  }
            value += (chars[i] - '0') * base;
            if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE)
                throw new NumberFormatException(String.valueOf(chars, start, chars.length-start) + ", beyond the range of int");
            base *= 10;
        }
        return (int)value;
    }


    @Test
    public void test(){
        String[] strs = {
                "123",
                "-123",
                "-0",
                "+123",
                "+12345671111111110",
                "-12345611111111170",
        };
        for (String str : strs){
            System.out.println(strToInt2(str.toCharArray()));
            System.out.println(strToInt(str.toCharArray()));
        }
        // char[] chars = new char[0]; System.out.println(chars.length == 0);
    }
}
```


----------

2017-8-18 10:22:42


```
public int StrToInt(String str){
    if (str == null || "".equals(str.trim())) return 0;
    
    int flag = 1;
    int i = 0;
    if (str.charAt(0) == '-') {
        flag = -1;
        i = 1;
    } else if (str.charAt(0) == '+')
        i = 1;
    
    for (; i < str.length(); i ++){
        if (str.charAt(i) != '0') break;
    }
    
    int num = 0;
    int base = 1;
    char ch;
    for (int j = str.length()-1; j >= i; j --){
        ch = str.charAt(j);
        if (ch < '0' || ch > '9') return 0;
        num += (str.charAt(j)-'0') * base;
        base *= 10;
    }
     
    return num * flag;
    
}



public int StrToInt0(String str) {
    if (str == null || "".equals(str.trim())) return 0;
    int result = 0;
    try{
        result = Integer.valueOf(str);
    }catch (Exception e){
    }
    return result;
}
```






## 面试题50 树中两个结点的最低公共祖先

>**题目：**
>
> 给出一棵树的根结点和树中的两个结点，找到这两个结点的最低公共祖先结点。
> 如下面的树中，给出根结点0以及5和7两个结点，找到5、7的最低公共祖先，结果是1。
<pre>
            0
           / \
         1    2
       /  \
      3    4
    / \   / | \
   5  6  7  8  9
</pre>



```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 21:26
 * 面试题 50：树中两个结点的最低公共祖先
 *
 * 考查点：
 *      1. 树的遍历
 *      2. 知识迁移能力，将问题转化为已有解决方法的问题
 *
 * 思路：
 *      1. 遍历树，找到根结点到指定结点的路径，是单向链表
 *      2. 从头到尾找到两条单向链表的最后一个公共结点
 *
 *
 *               0
 *              / \
 *            1    2
 *          /  \
 *         3    4
 *       / \   / | \
 *      5  6  7  8  9
 *
 */

class TreeNode{
    int             value;
    List<TreeNode> children = new ArrayList<>();
    public TreeNode(int _value){ value = _value; }
    public void addChild(TreeNode child){ children.add(child); }
    public void addChildren(TreeNode... children){
        for (TreeNode child : children) this.children.add(child);
    }

}

public class Test50 {

    /**
     * 找根结点到目标结点的路径
     * @param root 树的根结点
     * @param target 树中的一个结点
     * @param path 从根结点到目标结点的路径
     * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
     *
     *
    private void getNodePath(TreeNode root, TreeNode target, List<TreeNode> path){
        if (root == null) return ;

        // 添加当前结点
        path.add(root);

        // 处理孩子结点
        for (TreeNode child : root.children){
            // System.out.println(child.value);  // 0	1	3	5	4	7	8	9	2
            if (child == target){
                System.out.println(child.value);
                path.add(child);
                return ;
            }else{
                System.out.println("---- " + child.value);
                getNodePath(child, target, path);
            }
        }

        // 恢复现场
        path.remove(path.size()-1);
        // 0	1	3	5	4	7	8	9	2
        // 0	1	3	5	6	4	7	2
    }

    */

    /**
     * 找根结点到目标结点的路径
     * @param root 树的根结点
     * @param target 树中的一个结点
     * @param path 从根结点到目标结点的路径
     * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
     */
    private boolean getNodePath2(TreeNode root, TreeNode target, List<TreeNode> path){
        // 添加当前结点
        path.add(root);
        System.out.print(root.value + "\t");  //0	1	3	5	6	4	7

        if (root == target) return true;

        boolean found = false;

        // 处理孩子结点
        for (TreeNode child : root.children){
            found = getNodePath2(child, target, path);
            if (found) break;
        }
        
        // 以当前结点为根结点的子树中，不存在目标结点，则从路径中删除该结点
        if (!found) path.remove(path.size()-1);

        return found;
    }

    /**
     * 找两个链表的最后一个相同的结点
     * @param head1 链表一的头结点
     * @param head2 链表二的头结点
     * @return 两个链表的最后一个相同的结点
     */
    private TreeNode getLastCommonNode(List<TreeNode> head1, List<TreeNode> head2){
        for (int i = 1; i < head1.size() && i < head2.size(); i ++){
            if (head1.get(i).value != head2.get(i).value &&
                    head1.get(i-1).value == head2.get(i-1).value)
                return head1.get(i-1);
        }
        return null;
    }


    /**
     * 根据树的根结点和树中的两个结点，找到这两个结点的最低公共祖先结点
     * @param root 树的根结点
     * @param target1 树中结点1
     * @param target2 树中的结点2
     * @return 两个结点的最低公共祖先结点
     */
    public TreeNode getLastCommonParent(TreeNode root, TreeNode target1, TreeNode target2){
        if (root == null || target1 == null || target2 == null) return null;

        List<TreeNode> path1 = new ArrayList<>();
        getNodePath2(root, target1, path1);
        System.out.println();
        for(TreeNode node : path1) System.out.print(node.value + "\t");
        System.out.println();

        List<TreeNode> path2 = new ArrayList<>();
        getNodePath2(root, target2, path2);
        System.out.println();
        for(TreeNode node : path2) System.out.print(node.value + "\t");
        System.out.println();

        return getLastCommonNode(path1, path2);
    }


    @Test
    public void test(){
        TreeNode[] nodes = generateTree();
        TreeNode root = nodes[0];
        TreeNode target1 = nodes[1];
        TreeNode target2 = nodes[2];

        TreeNode lastCommonNode = getLastCommonParent(root, target1, target2);
        System.out.println("lastCommonNode.value = " + lastCommonNode.value);

    }


    /**
     *               0
     *              / \
     *            1    2
     *          /  \
     *         3    4
     *       / \   / | \
     *      5  6  7  8  9
     *
     */
    private TreeNode[] generateTree() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node0.addChildren(node1, node2);
        node1.addChildren(node3, node4);
        node3.addChildren(node5, node6);
        node4.addChildren(node7, node8, node9);

        return new TreeNode[]{node0, node5, node7};
    }


}

```






## 面试题51 数组中重复的数字

>**题目：**
> 
>在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道
每个数字重复了几次。请找出数组中任意一个重复的数字。例如，
如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应
的输出是重复的数字 2 或者 3。

```
package algorithm.foroffer.top60;

import org.junit.Test;

import java.util.Arrays;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-05 21:43
 * 面试题 51：数组中重复的数字
 *
 * 题目：
 *      在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字重复了，也不知道
 *      每个数字重复了几次。请找出数组中任意一个重复的数字。例如，
 *      如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应
 *      的输出是重复的数字 2 或者 3。
 *
 * 考查点：
 *
 * 思路：
 *      1. 方法一：
 *          时间复杂度小，需要辅助空间
 *          需要一个保存数字以及其出现次数的 map
 *      2. 方法二：
 *           时间复杂度高，空间复杂度是 O(1)
 *           两层循环遍历所有的数字
 *
 */
public class Test51 {

    public int findOneDuplicateDigit(int[] array){
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");
        // Map<Integer, Integer> map = new HashMap<>();
        int[] entrys = new int[array.length];
        int result = -1;
        for (int i = 0; i < array.length; i++){
            entrys[array[i]] += 1;
            if (entrys[array[i]] > 1) {
                result = array[i];
                break;
            }
        }
        System.out.println(Arrays.toString(entrys));
        return result;
    }

    public int findOneDuplicateDigit2(int[] array){
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");
        int result = -1;
        for (int i = 0; i < array.length; i ++){
            for (int j = i+1; j < array.length; j ++){
                if (array[i] == array[j]) return array[i];
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] array = {1, 2, 3, 5, 7, 2, 1, 3};
        System.out.println(findOneDuplicateDigit(array));
        System.out.println(findOneDuplicateDigit2(array));
    }
}

```


----------


更加高效的解法。
思路如下：
从头到尾遍历每一个数字，将以当前数字为下标的元素加 length，
当再次有跟这个下标一样的数字出现时，发现该下标处的元素大于 n-1，则这个数字出现了两次。

一个疑问，当被遍历到的数字大于length呢？
说明它的下标跟之前的数字相等，因此它的值被加 length。这是一个编码过程。
现在需要它的真实值，只需要 减去 length就可以得到它的原始值。

```
// Parameters:
//    numbers:     an array of integers
//    length:      the length of array numbers
//    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//    这里要特别注意~返回任意重复的一个，赋值duplication[0]
// Return value:       true if the input is valid, and there are some duplications in the array number
//                     otherwise false

public boolean duplicate(int numbers[],int length,int [] duplication) {
    duplication[0] = -1;
    boolean valid = false;
     
    if (numbers == null) return valid;
    
    for (int i = 0; i < length; i ++){
        int index = numbers[i];

        if (index >= length)    // index 要表示原来数组中i位置处的元素
            index -= length;

        if (numbers[index] > length){    // numbers[index]已经被一个同样的值为index的元素修改过
            valid = true;
            duplication[0] = index;
            break;
        }

        numbers[index] += length;
    }
    
    return valid;
}
```






## 面试题52 构建乘积数组

>**题目：**
>
> 给定一个数组 A[0, 1, ..., n-1]，请构建一个数组 B[0, 1, ..., n-1]，
 其中 B 中的元素 B[i] = A[0] * A[1] * A[2] * ... * A[i+1] * A[i+2]。
 不能使用除法运算。

```
package algorithm.foroffer.top60;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-06 17:36
 * 面试题52：构建乘积数组
 *
 * 题目：
 *      给定一个数组 A[0, 1, ..., n-1]，请构建一个数组 B[0, 1, ..., n-1]，
 *      其中 B 中的元素 B[i] = A[0] * A[1] * A[2] * ... * A[i+1] * A[i+2]。
 *      不能使用除法运算。
 *
 * 考查点：
 *      1. 找规律，提高计算速度
 *      2. 把计算过的，且以后会用到的数据保存起来，减少计算次数，提升执行效率
 *
 * 思路：
 *      1. B[i] = A[0] * A[1] * A[2] * ... * A[i+1] * A[i+2] * ... * A[n-1]
 *         可以定义，B[i] = C[i] + D[i]
 *         其中，C[i] = A[0] * A[1] * A[2] * ... * A[i-1],
 *         D[i] = A[i+1] * A[i+2] * ... * A[n-1]
 *              = A[n-1] * A[n-2] * ... * A[i+1]
 *
 *         则 B[i+1] = C[i+1] * D[i+1]，
 *         其中，C[i+1] = C[i] * A[i], D[i+1] = A[n-1] * A[n-2] * ... * A[i+2]
 *
 */
public class Test52 {

    public int[] multiply(int[] array){
        if (array == null || array.length == 0) return null;

        int[] multiArr = new int[array.length];
        multiArr[0] = 1;
        for (int i = 1; i < array.length; i ++)
            multiArr[i] = multiArr[i-1] * array[i-1];

        int tmp = 1;
        for (int i = array.length-2; i >= 0; i --){
            tmp *= array[i + 1];
            multiArr[i] *= tmp;
        }

        return multiArr;
    }

    @Test
    public void test(){
        int[] array = {1, 2, 3, 4, 5};
        int[] multiArr = multiply(array);
        System.out.println(Arrays.toString(multiArr));
    }
}

```






## 面试题55 字符流中第一个不重复的字符

> **题目：**
>
>请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符 "goo" 时，第一个只出现一次的字符是 "g"，
当从该字符串中读出前六个字符 "google" 时，第一个只出现一次的字符是 "l"。
```
package algorithm.foroffer.top60;

import org.junit.Test;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 10:51
 *
 * 题目：
 *      请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *      例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"，
 *      当从该字符串中读出前六个字符 "google" 时，第一个只出现一次的字符是 "l"。
 *
 * 考查点：
 *      1. 字符串
 *
 * 思路：
 *      0。要做到：
 *          一、统计字符出现的次数；
 *          二、标记只出现一次的字符的先后位置
 *      1. 使用长度为 256 的整型数组，数组元素的值是字符出现的"先后顺序"，如果出现多次标记为-1，否则标记为 order
 *         (order初始值为 1，随输入的字符流个数增长)
 *      2. 查找最小 order 出现的位置，也即是数组中不为0或-1的所有元素中的最小值。即是最小的order，
 *         对应下标就是字符流中第一个只出现一次的字符。
 *
 */
public class Test55 {

    public char firstCharAppearingOnce(char[] chars){
        // if (chars == null || chars.length == 0) throw new IllegalArgumentException("Argument is illegal.");
        if (chars == null) throw new IllegalArgumentException("Argument is illegal.");

        int order = 1;
        int[] occurence = new int[256];
        for (int idx : chars)  {
            if (idx < 0 || idx > 255) throw new IllegalArgumentException();

            if (occurence[idx] == 0)  occurence[idx] = order;
            else                      occurence[idx] = -1;
            order ++;
        }

        char ch = '\0';
        int minFlag = chars.length + 1;
        for (int i = 0; i < occurence.length; i ++){
            if (occurence[i] >= 1 && occurence[i] < minFlag){
                ch = (char)i;
                minFlag = occurence[i];
            }
        }
        return ch;
    }


    @Test
    public void test(){
        String[] strings = {
                "",
                "g",
                "go",
                "goo",
                "goog",
                "googl",
                "google",
        };

        for (String string : strings){
            char[] chars = string.toCharArray();
            String line = String.format("%s :: %s", string, firstCharAppearingOnce(chars));
            System.out.println(line);
        }
    }
}

```





## 面试题56 链表中环的入口结点

> **题目：**
>
> 一个链表中包含环，如何找出环的入口结点？
 例如，在链表 1 -> 2 -> 3 -> 4 -> 5 -> 6，其中 6 指向3，
 则该链表中环的入口结点是 3。
 
 
```
package algorithm.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 14:17
 *
 * 面试题56：链表环的入口结点
 *
 * 题目：
 *      一个链表中包含环，如何找出环的入口结点？
 *      例如，在链表 1 -> 2 -> 3 -> 4 -> 5 -> 6，其中 6 指向3，
 *      则该链表中环的入口结点是 3。
 *
 * 考查点：
 *      1. 链表
 *
 * 思路：
 *      1. 转换问题，
 *              如果已知环中的结点总数，（需要先获得环中的一个结点）
 *              则可将问题转换为链表中倒数第 k 个结点。
 *      2. 首先找到环中的一个结点（重点），然后统计环中结点的个数，最后找到环的入口。
 *         a. 找到环中的一个结点，使用两个指针，它们均指向头结点，移动速度分别为 1 和 2，
 *            直到两个结点相遇，相遇处的结点就是环中的一个结点
 *            （使用慢指针和快指针找到环中的一个结点，快与慢指针）
 *         b. 移动其中的一个结点，直到该指针再次回到出发点，移动过程中统计出环中的结点的个数 k
 *         c. 使这个两个结点同时指向头结点，先移动其中的一个结点 k 步，然后以同样的速度移动两者，
 *            直到它们相遇，相遇处即是环的入口结点
 */

class Node{
    int value;
    Node next;
    public Node(int _value){ value = _value; }
    public void setNext(Node _next){ next = _next; }
    public Node next(){ return next; }
}
public class Test56 {

    public Node entranceNode(Node head){
        Node pointer1, pointer2;

        // a. 找到环中的一个结点
        // for (pointer1 = pointer2 = head;)
        for (pointer1 = head, pointer2 = head.next();
             pointer1 != pointer2;
             pointer1 = pointer1.next(), pointer2 = pointer2.next().next());

        // b. 统计环中结点的个数
        int counter = 1;
        for (pointer1 = pointer1.next(); pointer1 != pointer2; pointer1 = pointer1.next())
            counter ++;

        // c. 找到环中的入口结点，也即是求解链表中的倒数第 k 个结点
        pointer1 = pointer2 = head;
        for (int i = 0; i < counter; i++) pointer2 = pointer2.next();
        for (; pointer1 != pointer2; pointer1 = pointer1.next(), pointer2 = pointer2.next());

        return pointer1;
    }


    @Test
    public void test(){
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node2);

        Node entranceNode = entranceNode(node0);
        System.out.println(entranceNode.value);
    }
}

```





## 面试题57 删除链表中重复的结点

> **题目：**
>
> 在一个排序的链表中，如何删除重复的结点？
例如，链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5，
删除重复结点后为 1 -> 2 - > 3 -> 4 -> 5

```
package algorithm.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 15:12
 * 面试题57：删除链表中重复的结点
 *
 * 题目：
 *      在一个排序的链表中，如何删除重复的结点？
 *      例如，链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5，
 *      删除重复结点后为 1 -> 2 - > 3 -> 4 -> 5
 *
 * 考查点：
 *      1. 链表
 *
 * 思路：
 *      1. 如果当前结点跟后继结点相等，则将当前结点指向其后继结点的后继结点
 */

class Node57 {
    int value;
    Node57 next;
    public Node57 (int _value){ value = _value; }
    @Override
    public String toString(){
        return String.format("value = %s, next = %s", value, next == null ? null : next.value );
    }
}
public class Test57 {

    public Node57 deleteDuplication(Node57 head){
        for (Node57 currNode = head; currNode.next != null; currNode = currNode.next){
            if (currNode.value == currNode.next.value)
                currNode.next = currNode.next.next;
        }

        return head;
    }

    @Test
    public void test(){
        Node57 node0 = new Node57(0);
        Node57 node1 = new Node57(1);
        Node57 node2 = new Node57(2);
        Node57 node3 = new Node57(3);
        Node57 node4 = new Node57(3);
        Node57 node5 = new Node57(4);
        Node57 node6 = new Node57(4);
        Node57 node7 = new Node57(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node57 newHead = deleteDuplication(node0);
        for (; newHead != null; newHead = newHead.next)
            System.out.println(newHead.value);
    }
}

```


----------


面试题57：删除链表中重复的结点
题目：
     在一个排序的链表中，如何删除重复的结点？
     例如，链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5，
     删除重复结点后为 1 -> 2 -> 5

2017-8-19 20:49:45

```
 private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 双指针
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode dummyHead = new ListNode(-1);  // small trick，哑结点（头指针）
        dummyHead.next = pHead;

        ListNode first = dummyHead;  
        ListNode second = pHead;
        int currVal;

        while(second != null){
            currVal = second.val;
            // 情况一：当前结点跟后面的结点相等，则删除这些结点
            if (second.next != null && second.next.val == currVal){ 
                while (second != null && second.val == currVal){
                    second = second.next;
                }
                first.next = second;  // 此时只需要删除重复的元素，first不需要移动
            } else{  // 情况二：当前结点跟后面的结点不相等，则向后移动这两个指针
                // first.next = second;
                first = second;
                second = second.next;
            }
        }
        return dummyHead.next;
    }
```





## 面试题58 二叉树的下一个结点

> **题目：**
>
> 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
> 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
> 例如，下图的中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
<pre>
             0
           /   \
          1     2
         / \   / \
        3  4  5   6
          / \
         7   8
     </pre>

```
package algorithm.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 15:32
 *
 * 面试题58：二叉树的下一个结点
 *
 * 题目：
 *      给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *      树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 *      例如，下图的中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
 *                  0
 *                /   \
 *               1     2
 *              / \   / \
 *             3  4  5   6
 *               / \
 *              7   8
 *
 *
 * 考查点：
 *      1. 二叉树的遍历
 *
 * 思路：
 *      1. 中序遍历序列，
 *         当前结点有右孩子，则其右子树的最左子结点即是下一个结点
 *         当前结点没有右孩子，而且是其父结点的左孩子，则其父结点即是下一个结点
 *         当前结点没有左孩子，而且是其父结点的右孩子，则其从下往上的祖先结点中是左孩子的结点即是下一个结点，可能不存在
 *
 */

class Node58{
    int value;
    Node58 parent;
    Node58 left;
    Node58 right;

    public Node58(int _value){ value = _value; }
    public void setParentAndChildren(Node58 _parent, Node58 _left, Node58 _right){
        parent = _parent;
        left = _left;
        right = _right;
    }
    @Override
    public String toString(){
        return String.format("value = %s", value);
    }
}
public class Test58 {

    public Node58 nextNode(Node58 node){
        if (node == null) return null;
        Node58 next = null;

        if (node.right != null){   // 当前结点有右孩子，则下一个结点是其右子树的最左子结点
            Node58 currNode = node.right;
            for (; currNode.left != null; currNode = currNode.left);
            next = currNode;
        } else if (node.parent != null){ // 当前结点没有右孩子，但存在父结点
            Node58 parentNode = node.parent;   // 初始默认当前结点是其父结点的左孩子，则下一个结点就是其父结点
            Node58 currNode = node;
            // 若当前结点是父结点的右孩子，则一直向上遍历，直到遇到其祖先结点是一个左孩子的情况
            // 该祖先结点的父结点的左子树已被遍历完成，则中序遍历的下一个结点就是其父结点
            while (parentNode != null && currNode == parentNode.right){
                currNode = parentNode;
                parentNode = parentNode.parent;
            }
            next = parentNode;
        }

        return next;
    }


    @Test
    /**
     *                  0
     *                /   \
     *               1     2
     *              / \   / \
     *             3  4  5   6
     *               / \
     *              7   8
     *
     * 其中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
     */
    public void test(){
        Node58 node0 = new Node58(0);
        Node58 node1 = new Node58(1);
        Node58 node2 = new Node58(2);
        Node58 node3 = new Node58(3);
        Node58 node4 = new Node58(4);
        Node58 node5 = new Node58(5);
        Node58 node6 = new Node58(6);
        Node58 node7 = new Node58(7);
        Node58 node8 = new Node58(8);

        node0.setParentAndChildren(null, node1, node2);
        node1.setParentAndChildren(node0, node3, node4);
        node2.setParentAndChildren(node0, node5, node6);
        node3.setParentAndChildren(node1, null, null);
        node4.setParentAndChildren(node1, node7, node8);
        node5.setParentAndChildren(node2, null, null);
        node6.setParentAndChildren(node2, null, null);
        node7.setParentAndChildren(node4, null, null);
        node8.setParentAndChildren(node4, null, null);

        System.out.println(0 + " -> " + nextNode(node0));
        System.out.println(1 + " -> " + nextNode(node1));
        System.out.println(2 + " -> " + nextNode(node2));
        System.out.println(3 + " -> " + nextNode(node3));
        System.out.println(4 + " -> " + nextNode(node4));
        System.out.println(5 + " -> " + nextNode(node5));
        System.out.println(6 + " -> " + nextNode(node6));
        System.out.println(7 + " -> " + nextNode(node7));
        System.out.println(8 + " -> " + nextNode(node8));

        /**
         0 -> value = 5
         1 -> value = 7
         2 -> value = 6
         3 -> value = 1
         4 -> value = 8
         5 -> value = 2
         6 -> null
         7 -> value = 4
         8 -> value = 0
         */
    }
}

```





## 面试题59 对称的二叉树

<pre>题目：
请实现一个函数，用来判断一颗二叉树是不是对称的。
如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，下图中第一棵二叉树是对称的，另外两棵不是。
       8                  8                 7
     /   \              /   \             /   \
    6     6            6     9           7     7
   / \   / \          / \   / \         / \   /
  5  7  7   5        5  7  7   5       7  7  7
</pre>

```
package algorithm.ac.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 19:48
 *
 * 面试题59：对称的二叉树
 *
 * 题目：
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。
 *      如果一棵二叉树和它的镜像一样，那么它是对称的。
 *      例如，下图中第一棵二叉树是对称的，另外两棵不是。
 *             8                  8                 7
 *           /   \              /   \             /   \
 *          6     6            6     9           7     7
 *         / \   / \          / \   / \         / \   /
 *        5  7  7   5        5  7  7   5       7  7  7
 *
 * 考查点：
 *      1. 二叉树前序遍历的应用，先遍历左子树的前序遍历和先遍历右子树的前序遍历
 *      2. 对于像第三棵树这样的特殊情况，需要考虑叶子结点的孩子 null 才能，这一点至关重要
 *
 * 思路：
 *      1.二叉树的前序遍历和对称前序遍历
 *
 */

class BinTreeNode59{
    int value;
    BinTreeNode59 left;
    BinTreeNode59 right;

    public BinTreeNode59 (int _value){ value = _value; }
    public void setChildren (BinTreeNode59 _left, BinTreeNode59 _right){
        left = _left;
        right = _right;
    }
}
public class Test59 {

    public boolean isSymmetrical (BinTreeNode59 root){
        return isSymmetrical (root, root);
    }

    public boolean isSymmetrical (BinTreeNode59 root1, BinTreeNode59 root2){
        if (root1 == null && root2 == null) return true;  // 唯一正确的出口

        // 一般情况下，不这么表示两者只有一个为空，但有上一句的限制，则可以使用
        if (root1 == null || root2 == null) return false;

        if (root1.value != root2.value) return false;

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }


    @Test
    /**
     *             8          
     *           /   \        
     *          6     6       
     *         / \   / \      
     *        5  7  7   5     
     */
    public void test(){
        BinTreeNode59 node0 = new BinTreeNode59(8);
        BinTreeNode59 node1 = new BinTreeNode59(6);
        BinTreeNode59 node2 = new BinTreeNode59(6);
        BinTreeNode59 node3 = new BinTreeNode59(5);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);
        BinTreeNode59 node6 = new BinTreeNode59(5);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        System.out.println(isSymmetrical(node0));
    }

    @Test
    /**
     *          8
     *        /   \
     *       6     9
     *      / \   / \
     *     5  7  7   5
     */
    public void test1(){
        BinTreeNode59 node0 = new BinTreeNode59(8);
        BinTreeNode59 node1 = new BinTreeNode59(6);
        BinTreeNode59 node2 = new BinTreeNode59(9);
        BinTreeNode59 node3 = new BinTreeNode59(5);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);
        BinTreeNode59 node6 = new BinTreeNode59(5);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        System.out.println(isSymmetrical(node0));
    }

    @Test
    /**
     *          7
     *        /   \
     *       7     7
     *      / \   /
     *     7  7  7
     */
    public void test2(){
        BinTreeNode59 node0 = new BinTreeNode59(7);
        BinTreeNode59 node1 = new BinTreeNode59(7);
        BinTreeNode59 node2 = new BinTreeNode59(7);
        BinTreeNode59 node3 = new BinTreeNode59(7);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, null);

        System.out.println(isSymmetrical(node0));
    }


}

```





## 面试题60 把二叉树打印成多行

> **题目：**
>    从上到下按层打印二叉树，同一层的结点按从左到右顺序打印，
>    每一层打印到一行。例如下面的二叉树的结果为：
<pre> 
                8
               / \
              6  10
            / \  / \
           5  7 9  11
           
     结果为：
     8
     6 10
     5 7 9 11
</pre>

```
package algorithm.foroffer.top60;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-08 17:24
 *
 * 面试题60：把二叉树打印为多行
 *
 * 题目：
 *      从上到下按层打印二叉树，同一层的结点按从左到右顺序打印，
 *      每一层打印到一行。例如下面的二叉树的结果为：
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 *
 *       结果为：
 *       8
 *       6 10
 *       5 7 9 11
 *
 * 考查点：
 *      1. 树的层次遍历，属于广度优先遍历，使用的数据结构是队列
 *
 * 思路：
 *      1. 队列，
 *      2. 两个辅助变量，一个变量保存当前层还没有打印的结点数，
 *         另一个变量保存下一层结点的数目
 *
 */

class BinTreeNode{
    int value;
    BinTreeNode left;
    BinTreeNode right;
    public BinTreeNode(int _value){ value = _value; }
    public void setChildren(BinTreeNode _left, BinTreeNode _right){
        left = _left;
        right = _right;
    }
}
public class Test60 {

    public void printBinTree(BinTreeNode root){
        if (root == null) return;

        Queue<BinTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int thisLevel = 1;

        while (!queue.isEmpty()){
            BinTreeNode currNode = queue.poll();

            if (currNode.left != null){
                queue.offer(currNode.left);
                nextLevel ++;
            }

            if (currNode.right != null){
                queue.offer(currNode.right);
                nextLevel ++;
            }


            System.out.print(currNode.value + "\t");
            thisLevel --;

            if (thisLevel == 0){
                System.out.println();
                thisLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

    @Test
    public void test(){
        BinTreeNode node8 = new BinTreeNode(8);
        BinTreeNode node6 = new BinTreeNode(6);
        BinTreeNode node10 = new BinTreeNode(10);
        BinTreeNode node5 = new BinTreeNode(5);
        BinTreeNode node7 = new BinTreeNode(7);
        BinTreeNode node9 = new BinTreeNode(9);
        BinTreeNode node11 = new BinTreeNode(11);

        node8.setChildren(node6, node10);
        node6.setChildren(node5, node7);
        node10.setChildren(node9, node11);

        printBinTree(node8);
    }
}

```





## 面试题61 按之字形顺序打印二叉树

<pre>题目：
请实现一个函数按照之字型顺序打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
例如：按之字形顺序打印下面的二叉树的结果为：
1
3  2
4  5  6 7
15 14 13 12 11 10 9 8

             1
         /       \
       2          3
     /  \        /   \
    4    5      6     7
  / \   / \    / \   / \
 8  9  10 11  12 13 14 15
</pre>
```
package algorithm.ac.foroffer.top70;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 8:37
 *
 * 题目：
 *      请实现一个函数按照之字型顺序打印二叉树，即第一行按照从左到右的顺序打印，
 *      第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *      例如：按之字形顺序打印下面的二叉树的结果为：
 *      1
 *      3  2
 *      4  5  6 7
 *      15 14 13 12 11 10 9 8
 *
 *               1
 *           /       \
 *         2          3
 *       /  \        /   \
 *      4    5      6     7
 *    / \   / \    / \   / \
 *   8  9  10 11  12 13 14 15
 *
 * 考查点：
 *      1. 层次遍历（广度优先遍历）不使用递归
 *      2. 栈的应用
 *
 * 思路：
 *      1. 使用两个栈协同工作
 *      2. 当遍历到奇数层时，先保存其右孩子到栈中，再保存其左孩子
 *         当遍历到偶数层时，先保存其左孩子到栈中，再保存其右孩子
 *         （打印后的元素立刻出栈，则刚进入到一个新的层时，其中的一个栈是空的，将新层中的元素的孩子保存到这个空栈中）
 *
 *
 */

class BinTreeNode61{
    int value;
    BinTreeNode61 left;
    BinTreeNode61 right;
    public BinTreeNode61 (int _value){ value = _value; }
    public void setChildren(BinTreeNode61 _left, BinTreeNode61 _right){
        left = _left;
        right = _right;
    }

}

public class Test61 {

    public void snakePrint(BinTreeNode61 root){
        if (root == null) return;

        LinkedList<BinTreeNode61> stack1 = new LinkedList<>();  // 保存奇数层的元素
        LinkedList<BinTreeNode61> stack2 = new LinkedList<>();  // 保存偶数层的元素
        // LinkedList[] stacks = new LinkedList[2]; 分析结合使用泛型和数组可能会带来的问题，为什么不能？
        int current = 1;  // 1 表示奇数层，0 表示偶数层
        // int next = 2;

        stack1.push(root);
        LinkedList<BinTreeNode61> currStack;
        LinkedList<BinTreeNode61> nextStack;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            currStack = current == 1 ? stack1 : stack2;  // 选取奇数层或者偶数层为当前层，以访问该层的元素
            nextStack = current == 1 ? stack2 : stack1;  // 选取奇数层或者偶数层为下一层，以存放当前层元素的孩子

            BinTreeNode61 node = currStack.pop();  // 访问当前层的元素，栈顶元素
            System.out.print(node.value + "\t");   // System.out.print(node.value + '\t');

            if (current == 1){  // 若当前层是奇数层，则先保存左孩子，再保存右孩子
                if (node.left != null) nextStack.push(node.left);
                if (node.right != null) nextStack.push(node.right);
            }
            else{  // 若当前层是偶数层，则先保存右孩子，再保存左孩子
                if (node.right != null) nextStack.push(node.right);
                if (node.left != null) nextStack.push(node.left);
            }

            // 当前层的元素被打印完毕，则换行，
            // 并将当前行设置为下一行，也即是若当前行是奇数层，则设置为偶层数，反之，设置为奇数层。
            if (currStack.isEmpty()){
                System.out.println();
                // int tmp = current;  current = next;  next = tmp;
                current = current == 0 ? 1 : 0;
            }
        }
    }


    @Test
    public void test(){
        BinTreeNode61 node1 = new BinTreeNode61(1);
        BinTreeNode61 node2 = new BinTreeNode61(2);
        BinTreeNode61 node3 = new BinTreeNode61(3);
        BinTreeNode61 node4 = new BinTreeNode61(4);
        BinTreeNode61 node5 = new BinTreeNode61(5);
        BinTreeNode61 node6 = new BinTreeNode61(6);
        BinTreeNode61 node7 = new BinTreeNode61(7);
        BinTreeNode61 node8 = new BinTreeNode61(8);
        BinTreeNode61 node9 = new BinTreeNode61(9);
        BinTreeNode61 node10 = new BinTreeNode61(10);
        BinTreeNode61 node11 = new BinTreeNode61(11);
        BinTreeNode61 node12 = new BinTreeNode61(12);
        BinTreeNode61 node13 = new BinTreeNode61(13);
        BinTreeNode61 node14 = new BinTreeNode61(14);
        BinTreeNode61 node15 = new BinTreeNode61(15);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, node5);
        node3.setChildren(node6, node7);
        node4.setChildren(node8, node9);
        node5.setChildren(node10, node11);
        node6.setChildren(node12, node13);
        node7.setChildren(node14, node15);

        snakePrint(node1);
    }
}

```


----------

类比面试题60 把二叉树打印成多行，可以得到一个更加直观更加简单的方法

2017-8-20 08:46:16

```
import java.util.ArrayList;
import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
*/
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return lines;
        
        ArrayList<Integer> line = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        
        TreeNode currNode;
        int thisLevel = 1;
        int nextLevel = 0;
        
        int level = 1;
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(!queue.isEmpty()){
            currNode = queue.poll();
            if (currNode.left != null) {
                queue.offer(currNode.left);
                nextLevel ++;
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
                nextLevel ++;
            }
            
            if (level % 2 == 1) line.add(currNode.val);
            else			    stack.push(currNode.val);
            
            thisLevel --;
            if (thisLevel == 0){
                if (level % 2 == 0){
                    while (!stack.isEmpty()){
                        line.add(stack.pop());
                    }
                    
                }
                lines.add(line);
                line = new ArrayList<Integer>();
                thisLevel = nextLevel;
                nextLevel = 0;
                level ++;
            }
        }
        return lines;
    }
}
```





## 面试题62 序列化和反序列化二叉树

>**题目：**
>
>请实现两个函数，分别用来序列化和反序列化二叉树。


```
package algorithm.ac.foroffer.top70;

import org.junit.Test;

import java.util.LinkedList;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 11:08
 *
 * 面试题62：序列化二叉树
 *
 * 题目：
 *      请实现两个函数，分别用来序列化和反序列化二叉树。
 *                    1
 *                  /  \
 *                2     3
 *               /     / \
 *              4     5  6
 *
 * 考查点：
 *      1. 二叉树
 *
 * 思路：
 *      1. 序列化二叉树，采用前序遍历的方式
 *            而且要保证任何结点均有两个孩子，若没有孩子或者只有一个孩子，则将缺失的孩子设置为 null
 *      2. 反序列化二叉树，
 *
 */

class BinTreeNode62{
    int value;
    BinTreeNode62 left;
    BinTreeNode62 right;
    public BinTreeNode62(){}
    public BinTreeNode62 (int _value){ value = _value; }
    public void setChildren(BinTreeNode62 _left, BinTreeNode62 _right){
        left = _left;
        right = _right;
    }

}

public class Test62 {

    /**
     * 序列化二叉树
     * @param root 二叉树的根结点
     * @return 序列化后的字符串
     */
    public String serializeToString(BinTreeNode62 root){
        if (root == null) return null;
        String[] sequence = new String[]{""};
        serializeToString(root, sequence);
        return sequence[0].substring(1);
    }

    private void serializeToString(BinTreeNode62 root, String[] sequence){
        if (root == null) {
            sequence[0] += ",#";
            return;
        }
        else sequence[0] += ("," + root.value);

        serializeToString(root.left, sequence);
        serializeToString(root.right, sequence);
    }


    /**
     * 反序列化二叉树
     * @param sequence 序列化后的二叉树
     * @return 二叉树的根结点
     */
    public BinTreeNode62 deserializeToBinTree(String sequence){
        if (sequence == null || sequence.length() == 0) return null;
        String[] values = sequence.split(",");
        return deserializeToBinTree(values, new int[]{0});
    }

    private BinTreeNode62 deserializeToBinTree(String[] values, int[] index) {
        String value = values[index[0]++];
        BinTreeNode62 root = null;
        if (value.matches("[0-9]+")){
            root = new BinTreeNode62();
            root.value = Integer.valueOf(value);

            // System.out.println(root.value);

            root.left = deserializeToBinTree(values, index);
            root.right = deserializeToBinTree(values, index);
        }
        return root;
    }


    @Test
    public void test(){
        BinTreeNode62 node1 = new BinTreeNode62(1);
        BinTreeNode62 node2 = new BinTreeNode62(2);
        BinTreeNode62 node3 = new BinTreeNode62(3);
        BinTreeNode62 node4 = new BinTreeNode62(4);
        BinTreeNode62 node5 = new BinTreeNode62(5);
        BinTreeNode62 node6 = new BinTreeNode62(6);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, null);
        node3.setChildren(node5, node6);

        String sequence = serializeToString(node1);
        System.out.println(sequence);  // 1,2,4,#,#,#,3,5,#,#,6,#,#

        BinTreeNode62 root = deserializeToBinTree(sequence);
        System.out.println("-------------------");
        System.out.println(root.value);
        System.out.println(root.left.value);
        System.out.println(root.left.left.value);
        System.out.println(root.right.value);
        System.out.println(root.right.left.value);
        System.out.println(root.right.right.value);

        LinkedList<BinTreeNode62> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinTreeNode62 node = queue.poll();
            System.out.print(node.value + "\t");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

    }

}

```




## 面试题63 二叉搜索树的第 k 个结点

<pre>题目：
    给定一棵二叉搜索树，请找出其中的第 k 大的结点。
    例如下面的二叉树中，按结点数值大小升序顺序，第三个结点的值是 7。
                 8
                / \
               6  10
             / \  / \
            5  7 9  11
</pre>

```
package foroffer.top70;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-08 19:42
 * 面试题63：二叉搜索树的第 k 个结点
 *
 * 题目：
 *      给定一棵二叉搜索树，请找出其中的第 k 大的结点。
 *      例如下面的二叉树中，按结点数值大小升序顺序，第三个结点的值是 7。
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 *
 * 考查点：
 *      1. 二叉搜索树
 *      2. 二叉树的中序遍历
 *      3. 递归，递归中状态变量的设置
 */


class BinTreeNode{
    int value;
    BinTreeNode left;
    BinTreeNode right;
    public BinTreeNode(int _value){ value = _value; }
    public void setChildren(BinTreeNode _left, BinTreeNode _right){
        left = _left;
        right = _right;
    }
}


public class Test63 {

    public BinTreeNode kthNode(BinTreeNode root, int[] k){
        BinTreeNode kthNode = null;
        if (root.left != null) kthNode = kthNode(root.left, k);  // 左子树的遍历
        // System.out.println("--------" + k[0]);
        if (kthNode == null){  // 中序遍历的操作
            k[0] --;
            if (k[0] == 0) kthNode = root;
        }
        if (kthNode == null && root.right != null)  // 右子树的遍历
            kthNode = kthNode(root.right, k);
        return kthNode;
    }


    @Test
    public void test(){
        BinTreeNode node8 = new BinTreeNode(8);
        BinTreeNode node6 = new BinTreeNode(6);
        BinTreeNode node10 = new BinTreeNode(10);
        BinTreeNode node5 = new BinTreeNode(5);
        BinTreeNode node7 = new BinTreeNode(7);
        BinTreeNode node9 = new BinTreeNode(9);
        BinTreeNode node11 = new BinTreeNode(11);

        node8.setChildren(node6, node10);
        node6.setChildren(node5, node7);
        node10.setChildren(node9, node11);

        BinTreeNode node = kthNode(node8, new int[]{3});
        System.out.println(node.value);
    }
}

```




## 面试题64 数据流中的中位数

> **题目：**
>
> 如何得到一个数据流中的中位数？
 如果从数据流中读出期数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

```
package algorithm.ac.foroffer.top70;

import org.junit.Test;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 16:26
 *
 * 面试题64：数据流中的中位数
 *
 * 题目：
 *      如何得到一个数据流中的中位数？
 *      如果从数据流中读出期数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 考查点：
 *      1. 查找
 *      2. 最大堆和最小堆
 *
 * 思路：
 *      1. 将数据流中的数据保存到两个容器中，这两个容器需要满足以下的条件：
 *            a. 保证一个容器中的最大值不大于另一个容器中的最小值
 *            b. 保证两个容器中的元素个数相差 0 或者 1
 *            c. 存放较小值的容器能够快读获取到最大值，存放较大值的容器能够快速获取到最小值
 *      2. 这个数据结构就是最大堆和最小堆
 *      3. 步骤：
 *            当新输入一个数据时，
 *            若两个容器中元素的总数目是偶数，
 *              则将最大堆中的最大值和当前值中较大值保存到最小堆中，较小者保存到最大堆中。
 *              （为了保证一个容器中的最大值不大于另一个容器中的最小值）
 *            若两个容器中元素的总数目是奇数，
 *              则将最小堆中的最小值和当前值中的较小者保存到最大堆中，较大者保存到最小堆中。
 *              （为了保证一个容器中的最大值不大于另一个容器中的最小值）
 *            通过对两个容器中总元素个数的判断，控制新的数据保存到哪一个堆中，实现了两个容器中元素个数相差为 0 或者 1。
 *            此时，已然满足了 1 中的 a、b 和 c 三个条件。
 *
 *
 *
 */
public class Test64 {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    // Comparator<Integer> reverse = new Comparator<Integer>(){
    //    @Override public int compare(Integer obj1, Integer obj2){ return obj2 - obj1; }
    // };
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void insert(int num){
        if (((minHeap.size() + maxHeap.size()) & 1) == 0){ // 数字的总数为偶数，将新的数据插入到最小堆中（最小堆中保存的都是较大的数字）
            // 若当前值最大堆中的最大值小，则将当前数字和最大数字交换（为了保证最大堆的最大值始终不大于最小堆中的最小值）
            // 即，将当前数字保存到最大堆中，将最大堆中的最大数字弹出并保存到最小堆中
            if (maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
        else{  // 数字的总数为奇数，将新的数据插入到最大堆中（最大堆中保存的都是较小的数字）
            // 若当前值比最小堆中的最小值大，则将当前数字和最小值交换（为了保证最大堆中的最大值始终不大于最小堆中的最小值）
            // 即，将当前数字存放到最小堆中，将最小堆中的最小数字弹出并保存到最大堆中
            if (minHeap.size() > 0 && num > minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }


    public double getMedain(){
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) throw new IllegalArgumentException("Argument is illegal.");
        double medain = -1;
        if ((size & 1) == 1) medain = minHeap.peek();
        else                 medain = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return medain;
    }

    @Test
    public void test(){
        Random random = new Random();
        int N = 10;
        for (int i = 0; i < N; i ++)  insert(random.nextInt(100));

        for (int i = 0; i < 5; i ++) {
            insert(random.nextInt(100));
            System.out.println("maxHeap : " + maxHeap);
            System.out.println("minHeap : " + minHeap);
            System.out.println(getMedain());
            System.out.println();
        }
    }
}

```

测试结果：
```
maxHeap : [53, 33, 42, 4, 28]
minHeap : [55, 76, 64, 99, 91, 92]
55.0

maxHeap : [53, 33, 42, 4, 28, 2]
minHeap : [55, 76, 64, 99, 91, 92]
54.0

maxHeap : [42, 33, 16, 4, 28, 2]
minHeap : [53, 76, 55, 99, 91, 92, 64]
53.0

maxHeap : [42, 33, 16, 4, 28, 2, 16]
minHeap : [53, 76, 55, 99, 91, 92, 64]
47.5

maxHeap : [42, 33, 16, 4, 28, 2, 16]
minHeap : [53, 70, 55, 76, 91, 92, 64, 99]
53.0
```





# 面试题65 滑动窗口的最大值

> **题目：**
>
>   给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
     例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小 3，
     那么移动存在 6 个滑动窗口，它们的最大值分别为 {4, 4, 6, 6, 6, 5}。

```
package foroffer.top70;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 20:53 // 2017-8-21 10:46:30
 *
 * 面试题65：滑动窗口的最大值
 *
 * 题目：
 *      给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *      例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小 3，
 *      那么移动存在 6 个滑动窗口，它们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 *
 * 考查点：
 *      1. 双端队列的应用
 *
 * 思路：
 *      1. 新的元素比队列中的任何元素都大，则清空队列，并将其添加到队尾
 *      2. 新的元素比队尾中的元素小，则将其添加到队尾
 *      3. 新的元素比队尾元素大，但是比队首元素小，则将比其小的元素移出队列，然后将其添加到队尾。（从队尾删除元素）
 *
 *      怎么控制窗口的大小呢？
 *          队列里面存放的是下标，
 *          插入元素之前，先判断尾首下标之差是否等于 n-1，如果是，则将队首元素移出队列
 *
 *
 * Deque的12种方法总结如下：
 * 	                   First Element (Head)	                      Last Element (Tail)
 *              Throws exception	Special value	        Throws exception	Special value
 *  Insert	      addFirst(e)	     offerFirst(e)	            addLast(e)	     offerLast(e)
 *  Remove	      removeFirst()      pollFirst()     	        removeLast()	 pollLast()
 *  Examine	      getFirst()	     peekFirst()	            getLast()	     peekLast()
 *
 */
public class Test65 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1) return result;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i ++){
            // 保证添加新的元素之前，窗口中首尾元素下标之差最大是size
            if (i > 0 && !deque.isEmpty()){
                int firstIdx = deque.peekFirst();
                int diff = i - firstIdx;
                if (diff == size)
                    deque.pollFirst();
            }
            /*
            if (!deque.isEmpty() && num[i] > deque.peekFirst()){
                deque.clear();
            }else{
                while(!deque.isEmpty() && num[i] >= deque.peekLast())
                    deque.pollLast();
            }
            */

            // 同一个窗口中的元素如果小于新元素，则被删除
            // 由于前面的元素总是大于后面的元素，所以从后面开始删除
            while(!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();

            // 新元素总是会被添加到双端队列的末尾
            deque.offerLast(i);

            // 双端队列的队头存放的是一个窗口的最大值
            if (i >= size-1)
                result.add(num[deque.peekFirst()]);
        }
        return result;
    }
}
```



>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>


