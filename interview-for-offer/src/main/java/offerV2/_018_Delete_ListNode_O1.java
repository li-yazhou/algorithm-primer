package offerV2;

import offerV2.common.ListNode;

/**
 * @No          v2-018,v1-013
 * @problem     在 O(1) 时间删除链表结点
 * @tag         链表
 * @author      liyazhou1
 * @date        2017/5/25
 *
 * <pre>
 *      给定单项链表的头指针和一个结点指针，定义一个函数在 O(1) 时间删除该节点。
 *      链表结点与函数定义如下：
 * </pre>
 */
public class _018_Delete_ListNode_O1 {


    /**
     * Note
     *
     * Thought
     *      快速定位结点位置
     *      
     * Algorithm
     *      1. 一般思路是，删除单向链表的一个结点，需要获取该结点的前驱节点，但时间复杂度是 O(n)，不可行
     *      2. 要删除单向链表的一个结点，可以将其后继结点复制到当前结点，并删除该后继结点即可
     *         存在特殊情况，
     *              如果单向链表只有一个结点，则将头指针赋值为空既可以
     *              如果要删除的结点位于单向链表的末尾，则需要顺序遍历所有的结点，直到倒数第二个结点，把其后继结点设置为空
     */
    private static class Solution {

        /**
         * 删除单向链表中的某个结点
         * @param head 单向链表头结点
         * @param deleteNode 链表中的某个结点，由该方法的调用者控制，此方法在 O(1)时间无法检验该结点是否属于链表
         * @return
         */
        public static ListNode deleteNode(ListNode head, ListNode deleteNode){
            if (head == null || deleteNode == null) return head;
            // throw new RuntimeException("inValid input. Head node and deleteNode can't be null.");

            // 只有一个结点的单向链表，由于已经保证两个结点都属于链表，所以此处两者相同
            if (head.next == null) return null;

            // 有两个及以上结点的单向链表，且要删除的结点位于单向链表末尾
            if (deleteNode.next == null){
                ListNode preNode;
                // 找到最后倒数第二个结点
                for (preNode = head; preNode.next.next != null; preNode = preNode.next);
                preNode.next = null;
                return head;
            }

            // 要删除的节点在单链表中间位置
            ListNode nextNode = deleteNode.next;  // 获取待删除结点的后继结点
            deleteNode.val = nextNode.val; // 将待删除结点的后继结点，复制到待删除结点
            deleteNode.next = nextNode.next;  // 将待删除结点的后继结点设置为其后继结点的后继结点

            return head;
        }



        public static void main(String[] args){
            ListNode head = new ListNode();
            head.val = 0;
            ListNode tmpNode = head;
            ListNode deleteNode = null;
            for (int i = 1; i < 10; i++){
                ListNode currNode = new ListNode();
                currNode.val = i;

                tmpNode.next = currNode;
                tmpNode = currNode;

                if (i == 4) deleteNode = currNode;
            }

            ListNode link = new Solution().deleteNode(head, deleteNode);
            for(ListNode currNode = link; currNode != null && currNode.next != null; currNode = currNode.next)
                System.out.println(String.format("currNode = %d, next = %d", currNode.val, currNode.next.val));
        }
    }
}
