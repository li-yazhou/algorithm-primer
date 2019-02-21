package algorithm.foroffer;

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
