package leetcode;

/**
 * @No          206
 * @problem     Reverse Linked List
 * @level       Easy
 * @desc        反转链表
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * </pre>
 */
public class _0206_ReverseLinkedList {


    /**
     * Note
     *
     * Thought
     *
     * Challenge
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

        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode tmpNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmpNode;
            }
            return prev;
        }


        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode first = head;
            first.next = null;
            ListNode second = head.next;

            while (second != null){
                ListNode tempNode = second.next;
                second.next = first;
                first = second;
                second = tempNode;
            }
            return first;
        }
    }
}
