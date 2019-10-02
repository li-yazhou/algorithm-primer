package leetcode;

/**
 * @No          141
 * @problem     Linked List Cycle
 * @level       Medium
 * @desc        环形链表
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *      3 - 2 - 0 - -4
 *          |        |
 *          ----------
 *
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *      1 - 2
 *      |   |
 *      -----
 *
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *      1
 *
 *
 * Follow-up:
 * Can you solve it without using extra space?
 * </pre>
 */
public class _0141_LinkedListCycle {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Note
     *
     * Thought
     *      前后双指针、快慢指针
     *
     * Challenge
     *      推理结点位置
     *
     * Algorithm
     *      1. 快慢指针找到环中的一个结点，若不存在环形则返回null。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode quick = head;
            ListNode slow = head;

            while (quick != null && slow != null){
                if (quick.next != null) quick = quick.next.next;
                else                    return false;
                slow = slow.next;
                if (quick == slow) return true;
            }

            return false;
        }

        public boolean hasCycle1(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode quickPointer = head.next;
            ListNode slowPointer = head;
            while (slowPointer != null && quickPointer != null) {
                if (slowPointer == quickPointer) {
                    return true;
                }
                slowPointer = slowPointer.next;
                quickPointer = quickPointer.next;
                if (quickPointer != null) {
                    quickPointer = quickPointer.next;
                }
            }
            return false;
        }


        public static void main(String[] args) {
            ListNode head1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(5);
            ListNode node6 = new ListNode(6);
            head1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;
            node6.next = node3;

            ListNode head2 = new ListNode(1);
            head2.next = head2;

            ListNode[] listNodes = {
                    head1,
                    head2,
                    new ListNode(1)
            };

            for (ListNode head: listNodes) {
                boolean yes = new Solution().hasCycle(head);
                System.out.println("yes = " + yes);
                System.out.println("-----------------------------");
            }
        }
    }
}
