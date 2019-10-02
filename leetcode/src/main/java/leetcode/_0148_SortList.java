package leetcode;

/**
 * @No          148
 * @problem     Sort List
 * @level       Medium
 * @desc        排序链表
 * @author      liyazhou1
 * @date        2019/10/02
 *
 * <pre>
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * </pre>
 */
public class _0148_SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Note
     *
     * Thought
     *      链表归并排序
     *      链表快速排序
     *
     * Challenge
     *      递归
     *
     * Algorithm
     *      1. 使用快慢指针将字符串切分为两半
     *      2. 左右两部分分别排序
     *      3. 合并排序结果
     *
     * Complexity
     *      Time, O(nlogn)
     *      Space,
     */
    private static class Solution {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // step1 使用快慢指针将字符串切分为两半
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                fast = fast.next.next;
                slow = slow.next;
            }
            prev.next = null;

            // step2 左右两部分分别排序
            ListNode left = sortList(head);
            ListNode right = sortList(slow);

            // step3 合并排序结果
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode head = new ListNode(-1);
            ListNode curr = head;
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    curr.next = left;
                    left = left.next;
                } else {
                    curr.next = right;
                    right = right.next;
                }
                curr = curr.next;
            }

            if (left != null) {
                curr.next = left;
            }
            if (right != null) {
                curr.next = right;
            }

            return head.next;
        }

        private static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + ", ");
                head = head.next;
            }
            System.out.println();

        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {5, 1, 2, 6, 7, 10, 3},
                    {9, 8, 7, 6, 5, 4, 3, 2, 1}
            };

            for (int[] input: inputs) {
                ListNode head = new ListNode(-1);
                ListNode curr = head;
                for (int element: input) {
                    curr.next = new ListNode(element);
                    curr = curr.next;
                }
                printList(head.next);
                ListNode sortedList = new Solution().sortList(head.next);
                printList(sortedList);
                System.out.println("\n------------------------------");
            }
        }
    }
}
