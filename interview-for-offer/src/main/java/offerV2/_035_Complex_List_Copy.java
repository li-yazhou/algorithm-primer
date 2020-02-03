package offerV2;

/**
 * @No          v2-035,v1-0
 * @problem     复杂链表的复制
 * @tag         链表
 * @author      liyazhou1
 * @date        2017/5/28
 *
 * <pre>
 *      请实现函数 ComplexListNode clone(ComplexListNode head)，
 *      复制一个复杂链表。在复杂链表中，每个结点除了有一个指向下一个结点的指针外，
 *      还有一个指向链表中的任意结点或者 null。结点的定义如下：
 * </pre>
 */
public class _035_Complex_List_Copy {

    static class ComplexListNode{
        int value;
        ComplexListNode next;
        ComplexListNode sibling;

        public ComplexListNode(int value){ this.value = value; }
        public void setNodes(ComplexListNode next, ComplexListNode sibling){
            this.next = next;
            this.sibling = sibling;
        }
    }
    /**
     * Note
     *
     * Thought
     *      1. 链表的遍历
     *      2. 链表的指针操作
     *
     * Algorithm
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
     */
    private static class Solution {

        public ComplexListNode clone(ComplexListNode head){
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
            ComplexListNode newHead = head.next;
            cpNode = newHead;
            for (ComplexListNode currNode = head; currNode != null; currNode = currNode.next){
                currNode.next = currNode.next.next;

                if (cpNode.next != null) cpNode.next = cpNode.next.next;
                cpNode = cpNode.next;
            }

            return newHead;
        }
    }
}
