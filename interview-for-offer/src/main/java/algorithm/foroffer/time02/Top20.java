package algorithm.foroffer.time02;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 10:47
 */
public class Top20 {


    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * 面试题11 数值的整数次方
     */
    public double test11_power(int base, int exponent){
        if (exponent == 0) return 1;
        boolean isNegative = exponent < 0;
        if (exponent < 0) exponent = - exponent;
        double result = 1;
        for (int i = 0; i < exponent; i ++) result *= base;
        if (isNegative) result = 1/result;
        return result;
    }



    public double test11_powerWithPositiveExponent(double base, int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = test11_powerWithPositiveExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) result *= base;
        return result;
    }

    @Test
    public void test11_powerTest(){
        for (int i = -5; i < 5; i ++){
            System.out.printf("power(2, %d) = %.6f , answer = %.6f\n", i, test11_power(2, i), Math.pow(2, i));
        }
    }


    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 连续打印1~length位的所有整数
     * @param length 最大整数的位数
     */
    public void test12_printOneToN(int length){
        BigInteger max = BigInteger.TEN.pow(length);
        for (BigInteger i = BigInteger.ONE; i.compareTo(max) < 0; i = i.add(BigInteger.ONE)){
            System.out.print(i + "\t");
        }
    }


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
            // if (isZero && arr[i] != 0) isZero = false;  // 小优化，只有isZero=true时，才可能执行该语句，为false时一定不会执行
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
//        boolean continues = true;
//        if (arr[0] == 1) continues = false;
//        return continues;
        return arr[0] != 1;
    }

    @Test
    public void test12_printOneToNTest(){
        test12_printOneToN(1);
        System.out.println();
        test12_printOneToN02(1);
        System.out.println();
        test12_printOneToN(2);
        System.out.println();
        test12_printOneToN02(2);
        System.out.println();
        test12_printOneToN(3);
        System.out.println();
        test12_printOneToN02(3);
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    private static class LinkedNode{
        int value;
        LinkedNode next;
    }

    /**
     * 以 O(1)的时间复杂度删除链表中的结点
     * @param head 头结点
     * @param deleteNode 待删除的结点
     */
    public LinkedNode test13_deleteLinkedNode(LinkedNode head, LinkedNode deleteNode){
        // 判断输入
        if(head == null || deleteNode == null) return head;

        if (deleteNode == head) head = head.next; // 1 如果待删除结点是第一个结点
        else if (deleteNode.next == null){  // 2 如果待删除结点是最后一个结点
            LinkedNode currNode;  // 找到倒数第二个结点
            for(currNode = head; currNode.next != deleteNode; currNode = currNode.next);
            currNode.next = null;
        }else{  // 3 待删除结点是中间的结点
            LinkedNode nextNode = deleteNode.next;
            deleteNode.value = nextNode.value;
            deleteNode.next = nextNode.next;
        }
        return head;
    }

    @Test
    public void test13_deleteLinkedNodeTest(){
        LinkedNode head = new LinkedNode();
        head.value = 0;
        LinkedNode tmpNode = head;
        LinkedNode deleteNode = null;
        for (int i = 1; i < 10; i ++){
            LinkedNode newNode = new LinkedNode();
            newNode.value = i;
            tmpNode.next = newNode;
            tmpNode = newNode;

            if (i == 9) deleteNode = newNode;
        }
        // deleteNode = head;

        for (LinkedNode currNode = head; currNode != null; currNode = currNode.next)
            System.out.print(currNode.value + "\t");
        System.out.println();

        head = test13_deleteLinkedNode(head, deleteNode);

        for (LinkedNode currNode = head; currNode != null; currNode = currNode.next)
            System.out.print(currNode.value + "\t");

    }


    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 面试题14：调整数组顺序使奇数位于偶数前面
     * @param arr 数组
     */
    public void test14_reorderOddEven(int[] arr){
        if (arr == null || arr.length == 0) return;
        int low = 0, high = arr.length-1;
        while(low < high){
            for(; low < high; low ++){
                if ((arr[low] & 1) == 0) break; // 在前面找到一个偶数
            }
            for(; high > low; high --){
                if ((arr[high] & 1) == 1) break;  // 在后面找到一个奇数
            }

            if(low < high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
    }

    @Test
    public void test14_reorderOddEvenTest(){
        Random random = new Random();
        for (int i = 0; i < 10; i ++){
            int len = 3 * i;
            int[] arr = new int[len];
            for (int j = 0; j < arr.length; j ++){
                arr[j] = random.nextInt(50);
            }
            System.out.println(Arrays.toString(arr));
            test14_reorderOddEven(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
    }


    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 面试题15：链表中的倒数第k个结点
     * @param head 链表的头结点
     * @param k 整数，表示倒数第k个结点
     */
    public LinkedNode test15_findKthToTail(LinkedNode head, int k){
        if(head == null || k <= 0) return null;

        LinkedNode first = head;
        LinkedNode second = head;

        for (int i = 1; i < k; i ++){
            second = second.next;
            if (second == null) throw new RuntimeException("链表的长度小于参数" + k);
        }

        for (; second.next != null; second = second.next)
            first = first.next;

        return first;
    }

    @Test
    public void test15_findKthToTailTest(){
        LinkedNode head = new LinkedNode();
        head.value = 0;
        LinkedNode tmpNode = head;
        for (int i = 1; i < 10; i ++){
            LinkedNode newNode = new LinkedNode();
            newNode.value = i;
            tmpNode.next = newNode;
            tmpNode = newNode;
        }
        for(LinkedNode currNode = head; currNode != null; currNode = currNode.next){
            System.out.print(currNode.value + "\t");
        }
        LinkedNode node = test15_findKthToTail(head, 3);
        System.out.println();
        System.out.println(node.value);
    }


    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 面试题16：反转链表
     * @param head 链表的头结点
     * @return 反转后的链表的头结点
     */
    public LinkedNode test16_reverseLinkedList(LinkedNode head){
        if (head == null || head.next == null) return head;

        LinkedNode preNode = null;  // TODO: 2017/7/31 链表的尾结点的next为 null
        LinkedNode currNode = head;
        LinkedNode postNode = null;
        while(currNode != null){
            // 当前结点跟前一个结点建立关系前，先取出后一个结点
            postNode = currNode.next;  // 更新后一个结点为新的当前结点的后一个结点
            currNode.next = preNode;  // 当前结点指向前一个结点
            if (postNode == null) break;
            preNode = currNode;  // 更新前一个结点为当前结点
            currNode = postNode;  // 更新当前结点为后一个结点
        }
        return currNode;
    }


    @Test
    public void test16_reverseLinkedListTest(){
        LinkedNode head = new LinkedNode();
        head.value = 0;
        LinkedNode tmpNode = head;
        for (int i = 1; i < 10; i ++){
            LinkedNode newNode = new LinkedNode();
            newNode.value = i;
            tmpNode.next = newNode;
            tmpNode = newNode;
        }
        for(LinkedNode currNode = head; currNode != null; currNode = currNode.next){
            System.out.print(currNode.value + "\t");
        }

        System.out.println();

        head = test16_reverseLinkedList(head);

        for(LinkedNode currNode = head; currNode != null; currNode = currNode.next){
            System.out.print(currNode.value + "\t");
        }
    }

    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 面试题17：合并两个排序的链表
     */
    public LinkedNode test17_mergeLinkedList(LinkedNode head1, LinkedNode head2){
        // 判断输入
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        // TODO: 2017/8/7 更为优雅的方式是采用哑的头结点，dummyHead
        // 1 确定头指针
        LinkedNode newHead = null;
        if (head1.value <= head2.value) {
            newHead = head1;
            head1 = head1.next;
        }else{
            newHead = head2;
            head2 = head2.next;
        }

        // 2 不断移动尾部指针
        LinkedNode tailNode = newHead;
        for(; head1 != null && head2 != null; ){
            if (head1.value <= head2.value){
                tailNode.next = head1;
                head1 = head1.next;
            } else{
                tailNode.next = head2;
                head2 = head2.next;
            }
            tailNode = tailNode.next;
        }

        // 3 尾部指针指向剩余链表
        if(head1 != null) tailNode.next = head1;
        if(head2 != null) tailNode.next = head2;

        return newHead;
    }


    @Test
    public void test17_mergeLinkedListTest(){
        LinkedNode head1 = new LinkedNode();
        head1.value = 0;
        LinkedNode tmpNode = head1;
        for (int i = 2; i < 10; i = i + 2){
            LinkedNode newNode = new LinkedNode();
            newNode.value = i;
            tmpNode.next = newNode;
            tmpNode = newNode;
        }

        LinkedNode head2 = new LinkedNode();
        head2.value = 1;
        LinkedNode tmpNode2 = head2;
        for (int i = 3; i < 10; i = i + 2){
            LinkedNode newNode = new LinkedNode();
            newNode.value = i;
            tmpNode2.next = newNode;
            tmpNode2 = newNode;
        }

        test17_printLinkedList(head1);
        test17_printLinkedList(head2);

        LinkedNode newHead = test17_mergeLinkedList(head1, head2);
        test17_printLinkedList(newHead);

    }

    private void test17_printLinkedList(LinkedNode head){
        for(LinkedNode currNode = head; currNode != null; currNode = currNode.next){
            System.out.print(currNode.value + "\t");
        }
        System.out.println();
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    private static class BinTreeNode{
        int value;
        BinTreeNode left;
        BinTreeNode right;
        public BinTreeNode(int value){ this.value = value; }
        public void setChildren(BinTreeNode left, BinTreeNode right){
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 面试题18：树的子结构
     * @param root1 树的根结点
     * @param root2 树的根结点
     */
    public void test18_hasSubTree(BinTreeNode root1, BinTreeNode root2){

    }


    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * 面试题19：二叉树的镜像
     */
    public void test19_mirrorOfTree(BinTreeNode root){
        if (root == null) return;

        BinTreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        // 在父结点交换的基础上，递归地交换
        test19_mirrorOfTree(root.left);
        test19_mirrorOfTree(root.right);
    }


    @Test
    public void test19_mirrorOfTreeTest(){
        BinTreeNode root = test19_generateTree1();
        test19_levelVisit(root);
        test19_inorderVisit(root);
        System.out.println();
        test19_mirrorOfTree(root);
        test19_levelVisit(root);
        test19_inorderVisit(root);

    }

    private void test19_inorderVisit(BinTreeNode root){
        if (root == null) return;
        test19_inorderVisit(root.left);
        System.out.print(root.value + "-");
        test19_inorderVisit(root.right);
    }


    private void test19_levelVisit(BinTreeNode root){
        if (root == null) return;
        Queue<BinTreeNode> queue = new LinkedList<>();
        queue.add(root);  // queue.offer(root);
        while (!queue.isEmpty()){
            BinTreeNode currNode = queue.poll();
            if (currNode.left != null)  queue.add(currNode.left); // queue.offer(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
            System.out.print(currNode.value + "-");
        }
        System.out.println();
    }

    private  BinTreeNode test19_generateTree1() {
        BinTreeNode root0 = new BinTreeNode(8);
        BinTreeNode root1 = new BinTreeNode(6);
        BinTreeNode root2 = new BinTreeNode(10);
        BinTreeNode root3 = new BinTreeNode(5);
        BinTreeNode root4 = new BinTreeNode(7);
        BinTreeNode root5 = new BinTreeNode(9);
        // BinTreeNode root6 = new BinTreeNode(11);

        root0.setChildren(root1, root2);
        root1.setChildren(root3, root4);
        // root2.setChildren(root5, root6);
        root2.setChildren(root5, null);
        // root0.left = root1;
        // root1.left = root2;

        return root0;
    }


    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 面试题20：顺时针打印矩阵
     */



}
