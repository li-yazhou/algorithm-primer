package leetcode;

/**
 * @No          142
 * @problem     Linked List Cycle II
 * @level       Medium
 * @desc        环形链表II
 * @author      liyazhou1
 * @date        2019/10/02
 *
 * <pre>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *      3 - 2 - 0 - -4
 *          |        |
 *          ----------
 *
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *      1 - 2
 *      |   |
 *      -----
 *
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *      1
 *
 *
 * Follow-up:
 * Can you solve it without using extra space?
 * </pre>
 */
public class _0142_LinkedListCycleII {


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
     *      1. 快慢指针找到环中的一个结点，然后求解该环的长度m，若不存在环形则返回null；
     *      2. 前后双指针 p1 和 p2，p1向前移动m步，p1 和 p2 同速移动，直到两者相遇
     *         （若链表长度为n，则p1向前移动m步后，p1和p2距离环形部分入口长度均为n-m，也即同时同速移动p1和p2两者会相遇在环形入口结点）。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode quick = head;
            ListNode slow = head;
            boolean isCycle = false;
            while (quick != null && quick.next != null) {
                quick = quick.next.next;
                slow = slow.next;
                if (quick == slow) {
                    isCycle = true;
                    break;
                }
            }

            // 不存在环
            if (!isCycle) {
                return null;
            }

            // 环形部分的长度
            int cycleLen = 1;
            for (; slow.next != quick; slow = slow.next, cycleLen ++) ;
            // System.out.println("cycleLen = " + cycleLen);

            ListNode p1 = head;
            ListNode p2 = head;
            for (int i = 0; i < cycleLen; i ++, p1 = p1.next) ;
            for (; p1 != p2; p1 = p1.next, p2 = p2.next) ;
            return p2;
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
                ListNode start = new Solution().detectCycle(head);
                if (start != null) {
                    System.out.println("start.val = " + start.val);
                } else {
                    System.out.println("start = " + start);
                }
                System.out.println("-----------------------------");
            }
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
     *      1. 快慢指针找到环中的一个结点，若不存在环形则返回null；
     *      2. 使快慢指针中一个指针再次指向头结点，然后同时移动两个指针，它们再次相遇的结点即是环形的入口结点。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution1 {

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode quick = head;
            ListNode slow = head;
            boolean isCycle = false;
            while (quick != null && quick.next != null) {
                quick = quick.next.next;
                slow = slow.next;
                if (quick == slow) {
                    isCycle = true;
                    break;
                }
            }

            // 不存在环
            if (!isCycle) {
                return null;
            }

            slow = head;
            while (slow != quick) {
                slow = slow.next;
                quick = quick.next;
            }
            return slow;
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
                ListNode start = new Solution1().detectCycle(head);
                if (start != null) {
                    System.out.println("start.val = " + start.val);
                } else {
                    System.out.println("start = " + start);
                }
                System.out.println("-----------------------------");
            }
        }
    }
}
