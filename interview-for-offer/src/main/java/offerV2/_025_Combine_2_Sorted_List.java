package offerV2;

import offerV2.common.ListNode;

/**
 * @No          v2-025,v1-017
 * @problem     合并两个排序的链表
 * @tag         链表
 * @author      liyazhou1
 * @date        2017/5/26
 *
 * <pre>
 *      输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 *      例如输入链表1，1-3-5-7，和链表2，2-4-6-8，则合并之后的升序链表如链表3，
 *      1-2-3-4-5-6-7-8。链表结点的定义如下。
 * </pre>
 */
public class _025_Combine_2_Sorted_List {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 两个指针分别指向两个链表的头结点
     *      2. 比较两个指针指向的元素的大小
     *          将较小者添加到新链表中，并将指针往后移动一位
     *          循环执行
     *          当一个指针为空时，将另一个指针设置为新链表尾结点的后继结点
     */
    private static class Solution {
        public static ListNode mergeOrderList(ListNode head1, ListNode head2){
            if (head1 == null) return head2;
            if (head2 == null) return head1;

            ListNode newHead = new ListNode();
            ListNode tailNode = newHead;
            while (head1 != null && head2 != null){
                if (head1.val < head2.val) {
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
    }
}
