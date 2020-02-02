package offerV2;

import offerV2.common.ListNode;

/**
 * @No          v2-022,v1-15
 * @problem     链表中倒数第 k 个结点
 * @tag         链表、双指针
 * @author      liyazhou1
 * @date        2017/5/26
 *
 * <pre>
 *      输入一个链表，输出该链表第 k 个结点。
 *      为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾结点是倒数第 1 个结点。
 *      例如一个链表有 6 个结点，从头结点开始它们的值依次是 1、2、3、4、5、6.
 *      这个链表的倒数第 3 个结点是值为 4 的结点。
 * </pre>
 */
public class _022_Kth_ListNode_From_Tail {


    /**
     * Note
     *
     * Thought
     *      1. 索引单向链表中的元素
     *      2. 边界问题
     *      
     * Algorithm
     *      1. 顺序遍历
     *      2. trick，两个前后间隔相差 k 的指针顺序遍历整个单向链表到末尾，前面一个指针指向的元素即为倒数第 k 个结点
     */
    private static class Solution {

        public static ListNode findKthFromTail(ListNode head, int k){
            if (head == null || k < 0)
                throw new RuntimeException("Invalid input, linked list is null or k is smaller than zero.");

            ListNode first= head;
            ListNode second = head;

            for (int i = 1; i < k; i++) { // 从 1 开始计数
                second = second.next;
                // 单向链表的长度小于 k
                if (second == null) return null;
            }

            for (; second.next != null; second = second.next)
                first = first.next;

            return first;
        }


        public static void main(String[] args){
            ListNode head = new ListNode();
            head.val = 0;

            ListNode tmpNode = head;
            int length = 10;
            for (int i = 1; i < length; i++){
                ListNode currNode = new ListNode();
                currNode.val = i;
                tmpNode.next = currNode;
                tmpNode = currNode;
            }

            ListNode kNode = findKthFromTail(head, 10);
            StringBuilder sBuilder = new StringBuilder();
            for (ListNode currNode = head; currNode != null; currNode = currNode.next )
                sBuilder.append(currNode.val).append("-");
            sBuilder.deleteCharAt(sBuilder.length()-1);

            System.out.println(sBuilder.toString() + "\n");

            System.out.println(kNode.val);
        }
    }
}
