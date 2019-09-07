package leetcode;

/**
 * description:
 *  add two numbers
 * @author liyazhou
 * @since 2017-08-02 21:19
 */


/**

 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 */
public class _0002_AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     */
     private class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        int val = (l1.val + l2.val) % 10;
        int increment = (l1.val + l2.val) / 10;
        ListNode head = new ListNode(val);

        ListNode currNode = head;
        l1 = l1.next;
        l2 = l2.next;
        for (ListNode n1 = l1, n2 = l2; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next){
            int result = l1.val + l2.val + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;
        }

        for (; l1 != null; l1 = l1.next){
            int result = l1.val + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;
        }

        for (; l2 != null; l2 = l2.next){
            int result = l2.val + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;
        }

        if (increment == 1){
            currNode.next = new ListNode(1);
        }
        return head;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // 第二个结点是链表的头结点
        int increment = 0;
        ListNode currNode = dummyHead;

        for (ListNode n1 = l1, n2 = l2; l1 != null || l2 != null;){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int result = x + y + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (increment == 1){
            currNode.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}
