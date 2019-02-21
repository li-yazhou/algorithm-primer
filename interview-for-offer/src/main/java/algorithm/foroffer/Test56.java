package algorithm.foroffer;

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
