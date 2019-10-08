package leetcode;

/**
 * @No          19
 * @problem     Remove Nth Node From End of List
 * @level       Medium
 * @desc        删除链表的倒数第N个节点
 * @author      liyazhou1
 * @date        2019/09/19 休，看牙
 *
 * <pre>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 * </pre>
 */
public class _0019_RemoveNthNodeFromEndOfList {


    /**
     * Note
     *
     * Thought
     *      方法一，单指针遍历两次，删除第 len - n + 1 个节点
     *      方法二，前后指针
     *
     * Challenge
     *      边界控制
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

         public class ListNode {
             int val;
             ListNode next;

             ListNode(int x) {
                 val = x;
             }
         }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 本题目的关键
            // 边界问题

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            int len = 0;
            for (ListNode curr = dummyHead; curr != null; curr = curr.next, len ++);

            ListNode prev = dummyHead;
            int offset = len - n - 1;
            for (; offset > 0; offset --, prev = prev.next);

            // 哑结点可以保证每个结点都有前一个结点
            prev.next = prev.next.next;
            return dummyHead.next;
        }
    }
}
