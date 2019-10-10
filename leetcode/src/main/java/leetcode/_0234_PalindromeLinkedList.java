package leetcode;

/**
 * @No          234
 * @problem     Palindrome Linked List
 * @level       Easy
 * @desc        回文链表
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * </pre>
 */
public class _0234_PalindromeLinkedList {


    /**
     * Note
     *
     * Thought
     *      双指针找到链表的中间结点；
     *      反转链表的后半部分；
     *      比较链表的前半部分和“后半部分”。
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
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            // slow 是链表后半截的头指针
            if (fast != null) slow = slow.next;

            ListNode head1 = head;
            ListNode head2 = reverseList(slow); // 反转链表的后半截

            while (head1 != null && head2 != null){
                if (head1.val != head2.val) return false;

                head1 = head1.next;
                head2 = head2.next;
            }

            return true;
        }


        // 反转链表
        private ListNode reverseList(ListNode head){
            if (head == null || head.next == null) return head;

            ListNode first = head;
            ListNode second = head.next;
            first.next = null;  // 表示链表末尾
            while (second != null){
                ListNode tempNode = second.next;
                second.next = first;
                first = second;
                second = tempNode;
            }
            return first;
        }
    }



    private static class Solution1 {

        public boolean isPalindrome(ListNode head) {
            int len = len(head);
            int half = len - len/2;
            ListNode halfHead = head;
            for (; half > 0; halfHead = halfHead.next, half --);
            ListNode newHead = reverse(halfHead);
            while (newHead != null) {
                if (newHead.val != head.val) {
                    return false;
                }
                newHead = newHead.next;
                head = head.next;
            }
            return true;
        }


        int len(ListNode head) {
            int len = 0;
            for (; head != null; head = head.next, len++);
            return len;
        }

        ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = head;
            ListNode curr = head.next;
            head.next = null;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }

}
