package offerV2;

import offerV2.common.ListNode;

/**
 * @No          v2-018,v1-057
 * @problem     删除链表中重复的结点
 * @tag         链表
 * @author      liyazhou1
 * @date        2017-06-18
 *
 * <pre>
 *      在一个排序的链表中，如何删除重复的结点？
 *      例如，链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5，
 *      删除重复结点后为 1 -> 2 - > 3 -> 4 -> 5
 * </pre>
 */
public class _018_Delete_Duplicate_ListNode {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 如果当前结点跟后继结点相等，则将当前结点指向其后继结点的后继结点
     */
    private static class Solution {
        
        public ListNode deleteDuplication(ListNode head){
            for (ListNode currNode = head; currNode.next != null; currNode = currNode.next){
                if (currNode.val == currNode.next.val)
                    currNode.next = currNode.next.next;
            }

            return head;
        }


        public static void main(String[] args) {
            ListNode node0 = new ListNode(0);
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(3);
            ListNode node5 = new ListNode(4);
            ListNode node6 = new ListNode(4);
            ListNode node7 = new ListNode(5);

            node0.next = node1;
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;
            node6.next = node7;

            ListNode newHead = new Solution().deleteDuplication(node0);
            for (; newHead != null; newHead = newHead.next)
                System.out.println(newHead.val);
        }


        //--------------------------------------------------------------------


        // 双指针
        public ListNode deleteDuplication2(ListNode pHead)
        {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = pHead;

            ListNode first = dummyHead;
            ListNode second = pHead;
            int currVal;

            while(second != null){
                currVal = second.val;
                if (second.next != null && second.next.val == currVal){
                    while (second != null && second.val == currVal){
                        second = second.next;
                    }
                    first.next = second;  // 此时只需要删除重复的元素，first不需要移动
                } else{
                    // first.next = second;
                    first = second;
                    second = second.next;
                }
            }
            return dummyHead.next;
        }
    }
}
