package algorithm.foroffer;

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

            // if (cpNode.next == null)  cpNode.next = null;   // 最后一个元素的后继结点是 null
            // else                      cpNode.next = cpNode.next.next;
            if (cpNode.next != null) cpNode.next = cpNode.next.next;
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
