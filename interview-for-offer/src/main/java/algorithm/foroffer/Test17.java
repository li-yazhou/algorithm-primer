package algorithm.foroffer;

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
