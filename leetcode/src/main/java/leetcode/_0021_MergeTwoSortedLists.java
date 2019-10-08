package leetcode;

/**
 * @No          21
 * @problem     Merge Two Sorted Lists
 * @level       Easy
 * @desc        合并两个有序链表
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * </pre>
 */
public class _0021_MergeTwoSortedLists {


    /**
     * Note
     *
     * Thought
     *      链表
     *          单向链表的标配是头哑结点
     *          双向链表的标配是首、尾哑结点
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

        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode prev = dummyHead;
            ListNode curr = null;

            ListNode p1 = l1;
            ListNode p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    curr = new ListNode(p1.val);
                    p1 = p1.next;
                } else {
                    curr = new ListNode(p2.val);
                    p2 = p2.next;
                }
                prev.next = curr;
                prev = curr;
            }

            if (p1 != null) prev.next = p1;
            if (p2 != null) prev.next = p2;

            return dummyHead.next;
        }


        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode currNode = dummyHead;


            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    currNode.next = l1;
                    l1 = l1.next;
                }else{
                    currNode.next = l2;
                    l2 = l2.next;
                }
                currNode = currNode.next;
            }

            if (l1 != null) currNode.next = l1;
            if (l2 != null) currNode.next = l2;

            return dummyHead.next;
        }

    }
}
