package offerV2;

import offerV2.common.ListNode;

/**
 * @No          v2-052,v1-037
 * @problem     两个链表的第一个公共结点
 * @tag         链表、双指针
 * @author      liyazhou
 * @date        2017/5/31
 *
 * <pre>
 *      输入两个链表，找出它们的第一个公共结点。
 *      链表结点的定义如 ListNode.
 *      1 --> 2 --> 3 \
 *                      6 --> 7 --> 8
 *            4 --> 5 /
 * </pre>
 */
public class _052_First_Common_ListNode {


    /**
     * Note
     *
     * Thought
     *      1. 栈的使用
     *      2. trick，链表的bias（偏置），“对齐”两个链表
     *      注：本题目跟取链表的后k个结点有异曲同工之妙
     *
     * Algorithm
     *      1. 计算链表的长度
     *      2. 右“对齐”两个链表
     *      3. 对齐后，遍历并比较对应结点是否相同
     */
    private static class Solution {

        public ListNode findFirstCommonNode(ListNode head1, ListNode head2){
            if (head1 == null || head2 == null) return null;

            int len1 = 0, len2 = 0;
            for (ListNode currNode = head1; currNode != null; currNode = currNode.next, len1 ++);
            for (ListNode currNode = head2; currNode != null; currNode = currNode.next, len2 ++);

            int bias = len1 - len2;
            if (bias > 0){
                for (int i = 0; i < bias; i++) head1 = head1.next;
            }else{
                for (int i = 0; i < -bias; i++) head2 = head2.next;
            }

            for (; head1 != null && head2 !=null && head1 != head2; head1 = head1.next, head2 = head2.next);
            return head1;
        }


        /**
         * 链表A的长度为 a+c，
         * 链表B的长度为 b+c，
         * 其中，c是两个链表的公共长度。
         *
         * 两个指针指定链表的头节点，同时向后移动，
         * 若指针移动到末尾且没有遇到相等节点，则指针指向另一个链表的头节点，继续往后移动
         *
         * (a+c)+b = (b+c)+a
         */
        public ListNode findFirstCommonNode2(ListNode head1, ListNode head2) {
            ListNode p1 = head1;
            ListNode p2 = head2;
            while (p1 != p2) {
                p1 = p1 == null ? head2 : p1.next;
                p2 = p2 == null ? head1 : p2.next;
            }
            return p1;
        }
    }
}
