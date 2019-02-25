## 剑指offer合辑之面试01-20

>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>


## [面试题2 实现单例模式](#面试题2-实现单例模式)
## [面试题3 二维数组中的查找](#面试题3-二维数组中的查找)
## [面试题4 替换空格](#面试题4-替换空格)
## [面试题5 从尾到头打印链表](#面试题5-从尾到头打印链表)
## [面试题6 重建二叉树](#面试题6-重建二叉树)
## [面试题7 用两个栈实现队列](#面试题7-用两个栈实现队列)
## [面试题8 旋转数组的最小数字](#面试题8-旋转数组的最小数字)
## [面试题9 斐波那契数列/青蛙跳台阶/矩形覆盖/变态跳台阶](#面试题9-斐波那契数列/青蛙跳台阶/矩形覆盖/变态跳台阶)
## [面试题10 二进制中 1 的个数](#面试题10-二进制中1的个数)
## [面试题11 数值的整数次方](#面试题11-数值的整数次方)
## [面试题12 打印 1 到最大的 n 位整数](#面试题12-打印1到最大的n位整数)
## [面试题13 在o(1)时间删除链表结点](#面试题13-在o(1)时间删除链表结点)
## [面试题14 调整数组顺序使奇数位于偶数前面](#面试题14-调整数组顺序使奇数位于偶数前面)
## [面试题15 链表中倒数第 k 个结点](#面试题15-链表中倒数第k个结点)
## [面试题16 反转链表](#面试题16-反转链表)
## [面试题17 合并两个排序的链表](#面试题17-合并两个排序的链表)
## [面试题18 树的子结构](#面试题18-树的子结构)
## [面试题19 二叉树的镜像](#面试题19-二叉树的镜像)
## [面试题20 顺时针打印矩阵](#面试题20-顺时针打印矩阵)



## 面试题2 实现单例模式

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



## 面试题3 二维数组中的查找

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


## 面试题4 替换空格  

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

## 面试题5 从尾到头打印链表
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



## 面试题6 重建二叉树

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



## 面试题7 用两个栈实现队列
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



## 面试题8 旋转数组的最小数字
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



## 面试题9 斐波那契数列/青蛙跳台阶/矩形覆盖/变态跳台阶

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




## 面试题10 二进制中1的个数

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



>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>

