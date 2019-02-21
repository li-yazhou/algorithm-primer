package algorithm.foroffer;

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
