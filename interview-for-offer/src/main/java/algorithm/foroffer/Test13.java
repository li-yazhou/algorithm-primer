package algorithm.foroffer;

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


class Node13 {
    int value;
    Node13 next;
}

public class Test13 {


    /**
     * 删除单向链表中的某个结点
     * @param head 单向链表头结点
     * @param deleteNode 链表中的某个结点，由该方法的调用者控制，此方法在 O(1)时间无法检验该结点是否属于链表
     * @return
     */
    public static Node13 deleteNode(Node13 head, Node13 deleteNode){
        if (head == null || deleteNode == null) return head;
        // throw new RuntimeException("inValid input. Head node and deleteNode can't be null.");

        // 只有一个结点的单向链表，由于已经保证两个结点都属于链表，所以此处两者相同
        if (head.next == null) return null;

        // 有两个及以上结点的单向链表，且要删除的结点位于单向链表末尾
        if (deleteNode.next == null){
            Node13 preNode;
            // 找到最后倒数第二个结点
            for (preNode = head; preNode.next.next != null; preNode = preNode.next);
            preNode.next = null;
            return head;
        }

        // 要删除的节点在单链表中间位置
        Node13 nextNode = deleteNode.next;  // 获取待删除结点的后继结点
        deleteNode.value = nextNode.value; // 将待删除结点的后继结点，复制到待删除结点
        deleteNode.next = nextNode.next;  // 将待删除结点的后继结点设置为其后继结点的后继结点

        return head;
    }


    public void main(String[] args){
        Node13 head = new Node13();
        head.value = 0;
        Node13 tmpNode = head;
        Node13 deleteNode = null;
        for (int i = 1; i < 10; i++){
            Node13 currNode = new Node13();
            currNode.value = i;

            tmpNode.next = currNode;
            tmpNode = currNode;

            if (i == 4) deleteNode = currNode;
        }

        Node13 link = Test13.deleteNode(head, deleteNode);
        for(Node13 currNode = link; currNode != null && currNode.next != null; currNode = currNode.next)
            System.out.println(String.format("currNode = %d, nextNode = %d", currNode.value, currNode.next.value));
    }
}
