package offerV2;

import offerV2.common.ListNode;

/**
 * @No          v2-024,v1-016
 * @problem     反转链表
 * @tag         链表、递归
 * @author      liyazhou1
 * @date        2017/5/26
 *
 * <pre>
 *      定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *      链表结点定义如下
 * </pre>
 */
public class _024_Reverse_List {

    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 取出第一个结点和第二个结点，将第一个结点的后继结点设置为 null
     *      2. 取出链表中两个相邻的结点 A、B
     *         tmp = B.next
     *         B.next = A
     *         A = B
     *         B = tmp
     *         直到 B 结点为空
     */
    private static class Solution {

        public static ListNode reverseList(ListNode head){
            if (head == null || head.next == null) return head;

            ListNode first = head;
            ListNode second = head.next;

            // 首先，第一个元素的后继结点设置为 null
            first.next = null;

            for (ListNode tmpNode; second != null;){
                // System.out.println(second.val);
                tmpNode = second.next;  // 取出第二个结点的后继结点，保存到临时变量中
                second.next = first;    // 第二个结点的后继结点设置为第一个结点
                first = second;         // 第一个结点向后移动一位
                second = tmpNode;       // 第二个结点向后移动一位
            }
            return first;
        }
    }
}
