package leetcode;

/**
 * @No          160
 * @problem     Intersection of Two Linked Lists
 * @level       Easy
 * @desc        相交链表
 * @author      liyazhou1
 * @date        2017/08
 *
 * <pre>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 *
 * Example 1:
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * </pre>
 */
public class _0160_IntersectionOfTwoLinkedLists {


    /**
     * Note
     *
     * Thought
     *      链表的双指针应用。
     *
     *      参考，一个链表的倒数第K个结点。
     *
     *      计算两条链表的长度；
     *      使用两个指针“右对齐”两个链表；
     *      查找相同的结点。
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    private static class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            int lenA = length(headA);
            int lenB = length(headB);

            if (lenA > lenB) {
                int diff = lenA - lenB;
                for (; diff > 0; diff --, headA = headA.next);
            }
            if (lenA < lenB) {
                int diff = lenB - lenA;
                for (; diff > 0; diff --, headB = headB.next);
            }

            for (; headA != headB; headA = headA.next, headB = headB.next);

            return headA;

        }

        private int length(ListNode head) {
            int length = 0;
            for (; head != null; head = head.next, length ++);
            return length;
        }
    }


    private static class Solution1 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int len1 = lenOfLinkedList(headA);
            int len2 = lenOfLinkedList(headB);


            // "右对齐"两条链表
            int diff = len1 - len2;
            if (diff < 0){
                diff = - diff;
                while (diff > 0){
                    headB = headB.next;
                    diff --;
                }
            }else{
                while (diff > 0){
                    headA = headA.next;
                    diff --;
                }
            }


            // 查找两条链表的公共节点
            while (headA != null && headB != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;

        }

        private int lenOfLinkedList(ListNode head){
            int len = 0;
            while (head != null){
                len ++;
                head = head.next;
            }
            return len;
        }
    }
}
